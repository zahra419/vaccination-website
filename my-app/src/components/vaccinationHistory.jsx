import axios from "axios";
import { useEffect, useState } from "react";
import getValueInDate from '../services/getAgeInMonths'

function VaccinationHistory({childId}){
    const [history,setHistoy]=useState([]);
    useEffect(()=>{
        const token = localStorage.getItem('token');
        const getHistory=async()=>{
            const res = await axios.get(`http://localhost:8080/api/patient/${childId}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
           
        setHistoy(res.data);
        }
        getHistory();
    },[])
  
    return(
        
        <div className="container history">
       <h2 className="section-title">Vaccination History</h2>
       <table className='vaccine-table'>
            <thead>
            <tr>
            <th>Vaccin</th>
            <th>Centre</th>
            <th>Doctor</th>
            <th>Date</th>
            <th>Status</th>
            </tr>
            </thead>
            <tbody>{history.map((item,index)=><tr key={index}>
             <td>{item.vaccinName}</td>
            <td>{item.centerName}</td>
            <th>{item.doctorFullName}</th>
            <td>{item.vaccinationDate.slice(0,10)}</td>
            <td className="status Done">Done</td>
            </tr>)}
            </tbody>
        </table>
        </div>
       
    )
}
export default VaccinationHistory;


    