import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';
import '../style/login.css';
import login_img from '../assets/login_img.png'

function Login(){
  const [cin, setcin] = useState("")
  const [password,setpassword]= useState("")
  const [loginstatus,setloginstatus]=useState("")
  const navigate=useNavigate();
  const handleLogin = async()=>{
    try {
       const res=await axios.post("http://localhost:8080/api/login",{cin,password},
        { headers: { 'Content-Type': 'application/json' }});
       const token=res.data.token;
       localStorage.setItem('token',token);
       const decoded=jwtDecode(token);
       console.log(decoded);
       if (decoded.role ==='dba') navigate('/dba');
       else if (decoded.role === 'doctor') navigate('/doctor');
       else navigate('/patient');
    }catch(err){ 
      console.log(err.response.data.status)
      setloginstatus(err.response.data.error);
      setcin("");
      setpassword("");
      if(err.response.status>=500){
        navigate('/server-erreur');
      }
      
       
       
    }
  }
    return(
      <div className='login-page'>
        <div className='login-image'>
          <img src={login_img}/>
        </div>
        <div className='login-form-container'>
          <div className='login-form-card'>
          <h1>Welcome Back</h1>
          <p>Please login to access your account</p>
        <div className='form'>
        <label htmlFor="cin">CIN</label>
        <input type='text' name='cin'  placeholder='CIN' onChange={(e)=>setcin(e.target.value)}/>
        <label htmlFor="password">Password</label>
        <input type='password' name='password' placeholder='Mode de Passe' onChange={(e)=>setpassword(e.target.value)} />
        <button onClick={handleLogin} >Login</button>
        {loginstatus!=="" && <span className='errormsg'>{loginstatus}</span>}
      </div>
      </div>
      </div>
      </div>
    )
}
export default Login;