import { useEffect, useState } from 'react';
import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
import axios from 'axios';
import toTitleCase from '../functions/toTitleCase';

function AppointmentCard({triggerRefresh}) {

  const [info, setInfo] = useState([]);

  useEffect(()=>{
    const token = localStorage.getItem('token');

    const pendinglist = async () => {
      const res = await axios.get(
        'http://localhost:8080/api/doctor/apprequest',
        {
          headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
          }
        }
      );

      setInfo(res.data);
    }

    pendinglist();
  },[]);


  const acceptHandle = async(id) => {
    const token = localStorage.getItem('token');

    const res = await axios.put(
      `http://localhost:8080/api/doctor/accept/${id}/status`,
      null,
      {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        params: { status: 'accepted' }
      }
    );

    if(res.status === 200){   
      setInfo(prev =>
        prev.map(item =>
          item.appointmentId === id
            ? { ...item, localStatus: 'Accepted' }
            : item
        )
      );
      triggerRefresh && triggerRefresh();
    }
  }


  const rejectHandle = async(id) => {   
    const token = localStorage.getItem('token');

    const res = await axios.put(
      `http://localhost:8080/api/doctor/accept/${id}/status`,
      null,
      {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        params: { status: 'rejected' }
      }
    );

    if(res.status === 200){
      setInfo(prev =>
        prev.map(item =>
          item.appointmentId === id
            ? { ...item, localStatus: 'Rejected' }
            : item
        )
      );
      triggerRefresh && triggerRefresh();
    }
  }


  return (
    <>
      <h2 className="section-title">Booking Requests</h2>

      <div className='title-content'>
        {info.length === 0 && <p>No pending appointments</p>}
      </div>

      {info.map((item)=>(
        <div className="card" key={item.appointmentId}>

          <div className='card-info'>
            <div className='card-icon'>
              {item.gender == 'f'
                ? <img src={girl_toddler} width={80} height={80} />
                : <img src={boy_toddler} height={80} width={80} />
              }
            </div>

            <div className='card-details'>
              <p><strong>{toTitleCase(item.fullName)}</strong></p>
              <p><span>vaccine:</span>{item.vaccinName}</p>
            </div>
          </div>

          <div className="appt-date">
            <p>Date:{item.appointmentDate.slice(0,10)}</p>
          </div>

          <div className="card-footer">
            {!item.localStatus ?
              <>
                <button 
                  className='btn-primary appt'
                  onClick={()=>acceptHandle(item.appointmentId)}
                >
                  Accept
                </button>

                <button 
                  className='btn-secondary appt'
                  onClick={()=>rejectHandle(item.appointmentId)}
                >
                  Reject
                </button>
              </>
              :
              <button className='btn-status' disabled={true}>
                {item.localStatus}
              </button>
            }
          </div>

        </div>
      ))}
    </>
  )
}

export default AppointmentCard;