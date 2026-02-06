import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';

function Login(){
  const [username, setusername] = useState("")
  const [password,setpassword]= useState("")
  const [loginstatus,setloginstatus]=useState("")
  const navigate=useNavigate();
  const handleLogin = async()=>{
    try {
       const res=await axios.post("http://localhost:8080/api/login",{username,password},
        { headers: { 'Content-Type': 'application/json' }});
       const token=res.data.token;
       localStorage.setItem('token',token);
       const decoded=jwtDecode(token);
       console.log(decoded);
       if (decoded.role ==='dba') navigate('/dba');
       else if (decoded.role === 'doctor') navigate('/doctor');
       else navigate('/patient');
    }catch(err){ 
       setloginstatus(err.response.data.error);
    }
  }
    return(
        <div>
        <input type='text' name='username' placeholder='User Name' onChange={(e)=>setusername(e.target.value)}/>
        <input type='password' name='password' placeholder='Password' onChange={(e)=>setpassword(e.target.value)} />
        <button onClick={handleLogin} >Submit</button>
        {loginstatus!=="" && <span>{loginstatus}</span>}
      </div>
    )
}
export default Login;