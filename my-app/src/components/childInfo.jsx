import { useEffect, useState } from 'react';
import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'
import axios from 'axios';
import toTitleCase from '../functions/toTitleCase';

function ChildInfo(props){
    const [value,setValue]=useState(0);
    const {fullName,gender,birthDate,id}=props.info;
    useEffect(()=>{
        const token=localStorage.getItem('token');
        const getpercentage=async()=>{
        const res = await axios.get(`http://localhost:8080/api/patient/progress/${id}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
        setValue(res.data)
        console.log(res.data);
        }
        getpercentage();
        },[])
    
    return (
         
        <div className="container child-info-container">
        <div className='card-icon'>
            {gender=='f'?<img src={girl_toddler} width={90} height={90}/> : <img src={boy_toddler} height={80} width={80}/>}
        </div>
        <div className='child-info'>
          <span><strong>{toTitleCase(fullName)}</strong></span>
          <p>{birthDate.slice(0,10)} </p>
          <div className="progress-wrapper">
          <div className="progress-bar" style={{width: `${value}%`}}></div>
          </div>
        </div>
        
        </div>
    )
}
export default ChildInfo;