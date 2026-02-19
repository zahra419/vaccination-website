import { useState } from "react";
import axios from "axios";

function SearchHistory() {

  const [childName, setChildName] = useState("");
  const [historyList, setHistoryList] = useState([]);

  const handleSearch = () => {
    // Filter by childName, case-insensitive
    const filtered = childName.trim().toLowerCase();
    const search=async ()=>{
    const token=localStorage.getItem('token');
    const res=await axios.get("http://localhost:8080/api/doctor/search", {
            params: { fullName:filtered },
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
            console.log(res.data);
    setHistoryList(res.data);
    }
    search();
  };

  return (
    <div className="container">
      <h2 className="section-title">Vaccine History</h2>

      <div className="search-input" >
        <input
          type="text"
          placeholder="Enter child's name"
          value={childName}
          onChange={(e) => setChildName(e.target.value)}
          style={{ flex: 1, padding: "0.5rem" }}
        />
        <button onClick={handleSearch} >
          <i className="fa fa-search" aria-hidden="true"></i> 
        </button>
      </div>

      {childName && historyList.length === 0 ? (
        <p className="info-text">No booked appointments found for "{childName}".</p>
      ) : historyList.length > 0 ? (
        <table className="vaccine-table">
          <thead>
            <tr>
              <th>Child Name</th>
              <th>Vaccin</th>
              <th>Centre</th>
              <th>Doctor</th>
              <th>Date</th>
              
            </tr>
          </thead>
         <tbody>
            {historyList.map((item,index) => (
              <tr key={index}>
                <td>{childName}</td>
                <td>{item.vaccinName}</td>
                <td>{item.centerName}</td>
                <td>Dr {item.doctorFullName}</td>
                <td>{item.vaccinationDate.slice(0,10)}</td>
                
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="info-text">Enter a child's name to see appointment history.</p>
      )}
    </div>
  );
}

export default SearchHistory;

/* */
