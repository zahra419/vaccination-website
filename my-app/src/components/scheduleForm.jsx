import { useEffect, useState } from "react";
import axios from "axios";
function ScheduleForm(props){
    const [form, setForm] = useState({
        appointmentDate: "",
        centerId: "",
        doctorCin: ""
      });
      
      const [doctorslist,setDoctorsList]=useState([]);
      const [centerslist,setCentersList]=useState([]);
      const [selectedCenter,setSelectedCenter]=useState('');

      useEffect(()=>{
      const getCentersList=async()=>{
      const token=localStorage.getItem('token');
      const res=await axios.get(
      `http://localhost:8080/api/patient/centers`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
      setCentersList(res.data)
          }
      getCentersList()

      },[])
      useEffect(()=>{
       if (!selectedCenter) {
        setDoctorsList([]); 
        return;
      }
        const getDoctors=async()=>{
        const token=localStorage.getItem('token');
              const res=await axios.get(
      `http://localhost:8080/api/patient/centers/${parseInt(selectedCenter)}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
      setDoctorsList(res.data)
          }
          getDoctors()
      
      },[selectedCenter])
    
    
/*when you change something in form */
  const handleChange = (e) => {
    const { name, value } = e.target; 
    setForm(prev => ({
      ...prev,
      [name]: value
    }));
    if(name=="centerId")
    setSelectedCenter(value);
  };
/* after submitting */
  const handleSubmit = async(e) => {
    e.preventDefault();
    const newAppointment={...form,...props.info,status:'pending'}
    const token=localStorage.getItem('token');
    await axios.post(
    `http://localhost:8080/api/patient/appt`,newAppointment, {
     headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
    console.log("Scheduled vaccination:", form);
    props.onSubmit({status:true,date:form.appointmentDate})
  };


    return(
        <>
        <form className="form-container" onSubmit={handleSubmit}>
          <label>
            Date:
            <input
              type="date"
              name="appointmentDate"
              value={form.appointmentDate}
              onChange={handleChange}
              min={new Date().toISOString().split("T")[0]}
              required
            />
          </label>

          <label>
            Center:
            <select
              name="centerId"
              value={form.centerId}
              onChange={handleChange}
              required
            > 
              <option value="">Select center</option>
              {centerslist.map((item)=>(
                 <option value={item.centerId} key={item.centerId}>{item.centerName}</option>
              ))}
            </select>
          </label>

          <label>
            Doctor:
            <select
              name="doctorCin"
              value={form.doctorCin}
              onChange={handleChange}
              required
            >
              <option value="">Select doctor</option>
               {doctorslist.map((item)=>(
                 <option value={item.cin} key={item.cin}>{item.fullName}</option>
              ))}
            </select>
          </label>

          <button type="submit" >Schedule Vaccination</button>
        </form>
    
        
        </>
    )
}
export default ScheduleForm;
