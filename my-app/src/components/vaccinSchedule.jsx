import { useEffect, useState } from "react";
import axios from "axios";
import '../style/childpageinfo.css';
import ScheduleForm from "./scheduleForm";
import { useNavigate } from "react-router-dom";
import toTitleCase from "../functions/toTitleCase";
function VaccinSchedule({ childId }) {
  const [display, setDisplay] = useState(false);
  const [submit,setSubmit]=useState({status:false,date:""});
  const [appt,setAppt]=useState({});
  const [bookedAppt,setBookedAppt]=useState({});
  const navigate=useNavigate();

  useEffect(()=>{
    const token=localStorage.getItem('token');
     const fetchData = async () => {
      try {
        const [upcomingRes, latestRes] = await Promise.all([
          axios.get(`http://localhost:8080/api/patient/upcoming/${childId}`, {
            headers: { Authorization: `Bearer ${token}` }
          }),
          axios.get(`http://localhost:8080/api/patient/bookedappt/${childId}`, {
            headers: { Authorization: `Bearer ${token}` }
          })
        ]);

        setAppt(upcomingRes.data);
        setBookedAppt(latestRes.data);  
        console.log("latest appointment", latestRes.data);

      } catch (err) {
        if (err.response?.status >= 500) {
          navigate('/server-erreur');
        }
      }
    }
      fetchData();
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
        <div className="upcoming-title">
        <span className="section-title">Upcoming Vaccination</span>
        {bookedAppt.appointmentDate && <span>{bookedAppt.appointmentDate.slice(0, 10)}</span>}
        </div>
        <div className="schedule-container">
        {( ! bookedAppt || bookedAppt.status ==="rejected") ? 
        <>
        <span>Vaccine: {appt.vaccinName}</span>
        <span> At {appt.monthDue} months old</span>
        {!submit.status  ? <button onClick={toggleForm}>Schedule Now</button> : (<span>Scheduled On {submit.date}</span>)}
         </>
       :<>
        <span><strong>Vaccine</strong><br/>{bookedAppt.vaccinName}</span>
        <span><strong>Location & Provider</strong><br/>{bookedAppt.centerName}/{toTitleCase(bookedAppt.fullName)}</span>
        <span><strong>Status</strong><br/>{bookedAppt.status}</span>
       </> }
      </div>
     
      </div>
      
      {display  && <ScheduleForm info={{childId,vaccinId:appt.vaccinId}} onSubmit={scheduleHandle}/>}
      </>

  );
}

export default VaccinSchedule;
//          