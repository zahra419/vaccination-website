function TablespaceOverview (){
    const tablespace=[{id:1,name:'sysaux',used:80,usedmb:76,free:399,autoextended:'yes'},
                      {id:2,name:'undo',used:40,usedmb:56,free:599,autoextended:'yes'}]
    const progressStyle=(value)=>{
        let backgroundColor = value <= 50 ? "green" : value < 80 ? "yellow" : "red";
        return {backgroundColor, width:  `${value}%`};
        }
        
    return (
<div className="container vaccin">
<h2 className="section-title">Tablespace Overview</h2>
<table className="vaccine-table">
          <thead>
            <tr>
              <th>Tablespace</th>
              <th>Used %</th>
              <th>Used MB</th>
              <th>Free MB</th>
              <th>Autoextended</th>
            </tr>
          </thead>
          <tbody>
            {tablespace.map((item) => (
              <tr key={item.id}>
                <td>{item.name}</td>
                <td><div className="progress-wrapper">
          <div className="progress-bar" style={progressStyle(item.used)}></div></div></td>
                <td>{item.usedmb}</td>
                <td>{item.free}</td>
                <td>{item.autoextended}</td>
              </tr>
            ))}
          </tbody>
        </table>

</div>
)
}
export default TablespaceOverview