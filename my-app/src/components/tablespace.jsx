import  { useEffect, useState } from 'react';
import axios from 'axios';

function TablespaceOverview (){
    const [tablespace,setTablespace]=useState([]);
    useEffect(()=>{
        const fetchTablespaceData=async()=>{
            const token=localStorage.getItem('token');
            const res=await axios.get('http://localhost:8080/api/dba/tablespaces', {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                }
            });
            setTablespace(res.data);
        }
        fetchTablespaceData();
    },[])


    
    const progressStyle=(value)=>{
        let backgroundColor = value <= 50 ? "green" : value < 80 ? "yellow" : "red";
        return {backgroundColor, width:  `${value}%`};
        }
        
    return (
<div className="container">
<h2 className="section-title">Tablespace Overview</h2>
<table className="vaccine-table">
          <thead>
            <tr>
              <th>Tablespace</th>
              <th>Status</th>
              <th>Used %</th>
              <th>Free MB</th>
              <th>Used MB</th>
            </tr>
          </thead>
          <tbody>
            {tablespace.map((item) => (
              <tr key={item.id}>
                <td>{item.tablespaceName}</td>
                <td>{item.tablespaceStatus}</td>
                <td><div className="progress-wrapper">
          <div className="progress-bar" style={progressStyle(item.pctUsed)}></div></div></td>
                
                <td>{item.freeSpace} MB</td>
                <td>{item.usedSpace} MB</td>
              </tr>
            ))}
          </tbody>
        </table>

</div>
)
}
export default TablespaceOverview