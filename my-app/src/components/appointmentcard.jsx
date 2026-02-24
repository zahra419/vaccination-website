import { useEffect, useState } from 'react';
import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
import axios from 'axios';
function AppointmentCard({triggerRefresh}) {
  const [status,setStatus]=useState('none');
  const [info, setInfo]=useState([])
  useEffect(()=>{
    const token=localStorage.getItem('token');
    const pendinglist=async()=>{
      const res=await axios.get('http://localhost:8080/api/doctor/apprequest', {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
            console.log(res.data);
      setInfo(res.data)
      
      
    }
    pendinglist();

  },[])
  const acceptHandle=async(id)=>{
    const token=localStorage.getItem('token');
    const res=await axios.put(`http://localhost:8080/api/doctor/accept/${id}/status`, null,
  {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    },
    params: { status: 'accepted' } // query param
  });
    console.log(res);
    if(res.status=200){
      setStatus('Accepted')
      triggerRefresh();
    }
      

  }
  const rejectHandle=async()=>{
    const token=localStorage.getItem('token');
    const res=await axios.put(`http://localhost:8080/api/doctor/accept/${id}/status`, null,
  {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    },
    params: { status: 'rejected' } // query param
  });
    if(res.status=200){
      setStatus('Rejected')
      triggerRefresh();
    }
  }
    return (
      <>
      <h2 className="section-title">Booking Requests</h2>
      <div className='title-content'>{info.length===0 && <p>No pending appointments</p>}</div>
     {info.map((item)=>(
      <div className="card" key={item.appointmentId}>
        <div className='card-info'>
  
        <div className='card-icon'>
          {item.gender=='f'?<img src={girl_toddler} width={80} height={80}/> : <img src={boy_toddler} height={80} width={80}/>}
        </div>
        <div className='card-details' >
          <p><strong>{item.fullName}</strong></p>
          <p><span>vaccine:</span>{item.vaccinName}</p>
        </div>
        </div>
        <div className="appt-date">
          <p>Date:{item.appointmentDate.slice(0,10)}</p>
        </div>
        <div className="card-footer">
          {status =='none'?
          <>
          <button className='btn-primary'onClick={()=>acceptHandle(item.appointmentId)}>Accept</button>
          <button className='btn-secondary' onClick={()=>rejectHandle(item.appointmentId)}>Reject</button>
          </>
          : <button className='btn-status' disabled={true}>{status}</button>
}
        </div>
        </div>    
        ))}
         </>
    )
}
export default AppointmentCard;
