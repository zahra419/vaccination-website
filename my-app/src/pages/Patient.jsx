import ChildCard from "../components/childcard"
import '../style/childcard.css'
function Patient (){
    const kidslist=[{id:1,gender:'f',full_name:'meryam jamali',age:3},{id:2,gender:'m',full_name:'mohamed bilal',age:12}]
    const listItems=kidslist.map((item)=><ChildCard key={item.id} props={item} />)
    return(
        <div className="child-card-container">{listItems}</div>
    )

}
export default Patient;