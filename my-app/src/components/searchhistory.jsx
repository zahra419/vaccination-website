import { useState } from "react";
import axios from "axios";
import toTitleCase from "../functions/toTitleCase";

function SearchHistory() {

  const [childName, setChildName] = useState("");
  const [historyList, setHistoryList] = useState([]);
  const [searched, setSearched] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleSearch = async () => {

    if (!childName.trim()) return;

    setLoading(true);
    setSearched(true);

    try {

      const filtered = childName.trim().toLowerCase();
      const token = localStorage.getItem('token');

      const res = await axios.get(
        "http://localhost:8080/api/doctor/search",
        {
          params: { fullName: filtered },
          headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
          }
        }
      );

      setHistoryList(res.data || []);

    } catch (error) {
      console.error(error);
      setHistoryList([]);
    }

    setLoading(false);
  };

  return (
    <div className="container">

      <h2 className="section-title">Vaccine History</h2>

      {/* Search Box */}
      <div className="search-input">
        <input
          type="text"
          placeholder="Enter child's name"
          value={childName}
          onChange={(e) => setChildName(e.target.value)}
          style={{ flex: 1, padding: "0.5rem" }}
        />

        <button onClick={handleSearch}>
          <i className="fa fa-search" />
        </button>
      </div>

      {/* Messages */}
      {!searched && (
        <p className="info-text">
          Enter a child's name to see appointment history.
        </p>
      )}

      {loading && <p className="info-text">Searching...</p>}

      {searched && !loading && historyList.length === 0 && (
        <p className="info-text">
          No booked appointments found for "{childName}".
        </p>
      )}

      {/* Table */}
      {historyList.length > 0 && !loading && (
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
            {historyList.map((item, index) => (
              <tr key={index}>
                <td>{toTitleCase(item.childFullName)}</td>
                <td>{item.vaccinName}</td>
                <td>{item.centerName}</td>
                <td>Dr {toTitleCase(item.doctorFullName)}</td>
                <td>{item.vaccinationDate?.slice(0, 10)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

    </div>
  );
}

export default SearchHistory;