import AppointmentCard from "../components/appointmentcard"
import DoctorAppointmentsTable from "../components/doctorappointmentstable"
import SearchHistory from "../components/searchhistory"
import VaccinCard from "../components/vaccincard"
import { useState } from "react"
import '../style/hcg.css'

function Doctor (){
     const [refresh, setRefresh] = useState(0);
     const handleRefresh = () => {
        setRefresh(prev => prev + 1);
      }

    return(
        <div className="doctorPage">
        <div className="cards-container">
        <AppointmentCard triggerRefresh={handleRefresh}/>
        </div>
        <VaccinCard/>
        <DoctorAppointmentsTable refreshKey={refresh}/>
        <SearchHistory/>
        </div>
    )

}
export default Doctor