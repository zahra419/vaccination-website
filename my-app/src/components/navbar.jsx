import { useNavigate } from "react-router-dom";
function Navbar (){
      const navigate=useNavigate()
    const logingout=()=>{
      localStorage.removeItem('token');
      navigate('/login')
    }
    return (
        <>
         <button onClick={logingout}>logout</button>
        </>
    )
}
export default Navbar;