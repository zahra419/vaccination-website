import { useEffect, useState } from "react"
import ChildCard from "../components/childcard"
import '../style/childcard.css'
import axios from 'axios';
import { useNavigate } from "react-router-dom";

function Patient (){
    const [kidslist,setKidsList]=useState([])
    const navigate=useNavigate();
    useEffect(()=>{
        const token = localStorage.getItem('token');
        const getChildrenDate=async()=>{
            try{
            const res = await axios.get("http://localhost:8080/api/patient", {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
            setKidsList(res.data);
            }catch(err){
             if(err.response.status>=500){
             navigate('/server-erreur');
              }
            }

        }
       getChildrenDate();

    },[])
   
    return(
        <div className="child-card-container">{kidslist.map((item)=><ChildCard key={item.childId} props={item} />)}</div>
    )

}
export default Patient;