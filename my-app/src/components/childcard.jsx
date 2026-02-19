import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
import { useNavigate } from "react-router-dom";
import getAgeInMonths from '../services/getAgeInMonths';

function ChildCard({props}){
    const navigate=useNavigate();
    const loadDetailsPage=()=>{
        navigate(`/patient/${props.childId}`,{state:{
            fullName:props.fullName,
            gender:props.gender,
            birthDate:props.birthDate
        }});
    }
    return(
    
        <div className='child-card'>
       <div className='card-icon'>
            {props.gender=='f'?<img src={girl_toddler} width={90} height={90}/> : <img src={boy_toddler} height={80} width={80}/>}
        </div>
        <div><strong>{props.fullName}</strong></div>
        <div>{getAgeInMonths(props.birthDate)} months</div>
        <button onClick={loadDetailsPage}>View details</button>
        </div>
    
    )
}
export default ChildCard;