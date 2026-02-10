import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
function AppointmentCard(props){
    return (
      <div className="card">
        <div className='card-info'>
        <div className='card-icon'>
          {props.gender=='f'?<img src={boy_toddler} width={80} height={80}/> : <img src={girl_toddler} height={80} width={80}/>}
        </div>
        <div className='card-details' >
          <p><strong>{props.child}</strong></p>
          <p><span>vaccine:</span>{props.vaccin}</p>
        </div>
        </div>
        <div className="appt-date">
          <p>Date:{props.date}</p>
        </div>
        <div className="card-footer">
          <button className='btn-primary'>Accept</button>
          <button className='btn-secondary'>Reject</button>
        </div>
        </div>
    )
}
export default AppointmentCard;
