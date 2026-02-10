import { useNavigate } from "react-router-dom";
import {useState,useEffect} from 'react';
import { jwtDecode } from "jwt-decode";

function Navbar (){
    const [userName, setUserName]=useState("");
    useEffect(()=>{
      const token = localStorage.getItem('token');
      const decoded=jwtDecode(token);
      setUserName(decoded.full_name);
    },[])
      const navigate=useNavigate()
    const logouthandler=()=>{
      localStorage.removeItem('token');
      navigate('/login')
    }
    return (
        <div className="navbar">
         <span><strong>{userName}</strong></span>
         <button onClick={logouthandler}>logout</button>
        </div>
    )
}
export default Navbar;