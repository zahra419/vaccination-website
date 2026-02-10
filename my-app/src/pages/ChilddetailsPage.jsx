import { useEffect } from "react";
import { useParams } from "react-router-dom";
import VaccinTab from "../components/vaccintab";
import '../style/childinfocard.css';
import ChildInfo from "../components/childInfo";

function ChildDetails(){
    const {id}=useParams();
    const childInfo=[{id:1,name:'doha',age:3,gender:'f'}]
    useEffect(()=>{

    },[{id}])
    return(
        <div className="detailPage">

        <ChildInfo/>
        <VaccinTab childInfo={childInfo}/>
        </div>
    )
}
export default ChildDetails;