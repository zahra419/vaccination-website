import AppointmentCard from "../components/appointmentcard"
import '../style/hcg.css'

function Doctor (){
    const items=[{id:1,child_name:'doha',gender:'f',vaccin:'sdfds',date:'13-07-2012'},{id:2,child_name:'doaa',gender:'m',vaccin:'sfsf',date:'12-07-2014'}]
     const appointment=items.map(item=>(
     <AppointmentCard key={item.id} child={item.child_name} gender={item.gender} vaccin={item.vaccin} date={item.date}/>))

    return(
        <>
        <div className="cards-container">
        <div>{appointment}</div>
        </div>
        </>
    )

}
export default Doctor