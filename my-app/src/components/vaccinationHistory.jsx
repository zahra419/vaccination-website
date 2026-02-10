import '../style/table.css'

function VaccinationHistory({history}){
    const listItems=history.map(item=><tr key={item.id}>
        <td>{item.vaccin}</td>
        <td>{item.center}</td>
        <th>{item.doctor}</th>
        <td>{item.date}</td>
        <td className="status Done">Done</td>
    </tr>)
    return(
        <>
       <table className='vaccination-table'>
            <thead>
            <tr>
            <th>Vaccin</th>
            <th>Centre</th>
            <th>Doctor</th>
            <th>Date</th>
            <th>Status</th>
            </tr>
            </thead>
            <tbody>{listItems}</tbody>
        </table>
        
        </>
    )
}
export default VaccinationHistory;