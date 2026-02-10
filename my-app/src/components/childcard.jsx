import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
import { useNavigate } from "react-router-dom";

function ChildCard({props}){
    const navigate=useNavigate();
    const loadDetailsPage=()=>{
        navigate(`/patient/${props.id}`);
    }
    return(
    
        <div className='child-card'>
       <div className='card-icon'>
            {props.gender=='f'?<img src={boy_toddler} width={90} height={90}/> : <img src={girl_toddler} height={80} width={80}/>}
        </div>
        <div><strong>{props.full_name}</strong></div>
        <div>{props.age} months</div>
        <button onClick={loadDetailsPage}>View details</button>
        </div>
    
    )
}
export default ChildCard;