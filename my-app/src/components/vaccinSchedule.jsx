import { useEffect, useState } from "react";
import axios from "axios";
import '../style/childpageinfo.css';
import ScheduleForm from "./scheduleForm";
function VaccinSchedule({ childId }) {
  const [display, setDisplay] = useState(false);
  const [submit,setSubmit]=useState({status:false,date:""});
  const [appt,setAppt]=useState({});
  
  
  useEffect(()=>{
    const getupcoming=async()=>{
     const token=localStorage.getItem('token');
     const res=await axios.get(
      `http://localhost:8080/api/patient/upcoming/${childId}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
      setAppt(res.data)
      console.log(res.data)
    }
    getupcoming()
  },[])
    const toggleForm=()=>setDisplay(true)
    const scheduleHandle = ({status,date}) => {
    setDisplay(prev=>!prev)
    setSubmit({date,status});
     // toggle form
  };
  return (
    <>
      <div className="container upcoming">
        <span className="section-title">Upcoming Vaccination</span>
        <div className="schedule-container">
        <span>Vaccine: {appt.vaccinName}</span>
        <span> At {appt.monthDue} months old</span>
        
        {!submit.status  ? <button onClick={toggleForm}>Schedule Now</button> : (<span>Scheduled On {submit.date}</span>)}
        
      </div>
      </div>
      
      {display  && <ScheduleForm info={{childId,vaccinId:appt.vaccinId}} onSubmit={scheduleHandle}/>}

    </>
  );
}

export default VaccinSchedule;
//          