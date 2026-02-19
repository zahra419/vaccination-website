import AppointmentCard from "../components/appointmentcard"
import DoctorAppointmentsTable from "../components/doctorappointmentstable"
import SearchHistory from "../components/searchhistory"
import VaccinationHistory from "../components/vaccinationHistory"
import VaccinCard from "../components/vaccincard"
import '../style/hcg.css'

function Doctor (){
    const items=[{id:1,child_name:'doha',gender:'f',vaccin:'sdfds',date:'13-07-2012'},{id:2,child_name:'doaa',gender:'m',vaccin:'sfsf',date:'12-07-2014'}]
    const history=[   
    {id:1,vaccin:'demdfj',doctor:'sfsd',center:'tashfine',date:'12-06-2023'},
    {id:2,vaccin:'demdfj',doctor:'sfsdfs',center:'tashfine',date:'12-06-2023'},
    {id:3,vaccin:'demdfj',doctor:'sdfsf',center:'tashfine',date:'12-06-2023'}]
     

    return(
        <>
        <div className="cards-container">
        <h2 className="section-title">Booking Requests</h2>
        <div>
        <AppointmentCard /></div>
        </div>
        <VaccinCard/>
        <div className="inline-views">
        <DoctorAppointmentsTable/>
        <SearchHistory/>
        </div>
        </>
    )

}
export default Doctor