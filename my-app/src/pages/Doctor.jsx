import AppointmentCard from "../components/appointmentcard"
import DoctorAppointmentsTable from "../components/doctorappointmentstable"
import SearchHistory from "../components/searchhistory"
import VaccinationHistory from "../components/vaccinationHistory"
import VaccinCard from "../components/vaccincard"
import { useState } from "react"
import '../style/hcg.css'

function Doctor (){
     const [refresh, setRefresh] = useState(0);
     const handleRefresh = () => {
        setRefresh(prev => prev + 1);
      }

    return(
        <>
        <div className="cards-container">
        <div>
        <AppointmentCard triggerRefresh={handleRefresh}/></div>
        </div>
        <VaccinCard/>
        <div className="inline-views">
        <DoctorAppointmentsTable refreshKey={refresh}/>
        <SearchHistory/>
        </div>
        </>
    )

}
export default Doctor