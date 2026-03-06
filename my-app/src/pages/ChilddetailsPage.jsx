import { useLocation, useParams } from "react-router-dom";
import ChildInfo from "../components/childInfo";
import VaccinSchedule from "../components/vaccinSchedule"
import VaccinationHistory from "../components/vaccinationHistory";
import '../style/childpageinfo.css';
function ChildDetails(){
    const {id}=useParams();
    const location=useLocation();
    const {fullName,gender,birthDate}=location.state || {}
    console.log(fullName,gender,birthDate)
   
    /*useEffect(()=>{

    },[{id}])*/
    return(
        <div className="detailPage">
        <ChildInfo info={{fullName,gender,birthDate,id}} />
        <VaccinSchedule childId={id} />
        <VaccinationHistory childId={id}/>
        </div>
    )
}
export default ChildDetails;