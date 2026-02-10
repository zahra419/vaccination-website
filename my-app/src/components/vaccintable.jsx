import { useNavigate } from "react-router-dom";
import '../style/table.css';


function VaccinationTable({data,childInfo}){
    const navigate=useNavigate();
    const scheduleHandle=()=>{
       navigate("schedule",{
        state:{
            id:childInfo.id,
            name:childInfo.name,
            age:childInfo.age,
            gender:childInfo.gender
        }
       })
    }
     const listItems=data.map(item=><tr key={item.id}>
        <td>{item.vaccin}</td>
        <td>{item.date}</td>
        <td><button onClick={scheduleHandle}>Schedule Now</button></td>
    </tr>)
return(
    <>
    <table className='vaccination-table upcoming'>
            <thead>
            <tr>
            <th>Vaccine</th>
            <th>Due Date</th>
            <th>Action</th>
            </tr>
            </thead>
            <tbody>{listItems}</tbody>
        </table>
    </>
)
}
export default VaccinationTable;