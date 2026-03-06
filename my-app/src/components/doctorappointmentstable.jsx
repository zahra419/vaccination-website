import { useEffect, useState } from "react";
import axios from "axios";
function BookedAppointmentsTable({refreshKey}) {
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    const token=localStorage.getItem("token");
    const getAllAppointments=async()=>{
    const res=await axios.get("http://localhost:8080/api/doctor/appointmentsTable",{
      headers: {
        Authorization: `Bearer ${token}`,
      }});
    console.log(res.data)
    setAppointments(res.data);
    };
    getAllAppointments();
    

  }, [refreshKey]);

  const today = new Date();
  const yyyy = today.getFullYear();
  const mm = String(today.getMonth() + 1).padStart(2, "0");
  const dd = String(today.getDate()).padStart(2, "0");
  const todayDate = `${yyyy}-${mm}-${dd}`;

  const [selectedDate, setSelectedDate] = useState(todayDate);

  const bookedAppointments = appointments
    .filter((appt) => appt.status === "accepted" && appt.appointmentDate.slice(0,10) === selectedDate)
    .sort((a, b) => new Date(a.appointmentDate) - new Date(b.appointmentDate));
  
  return (
    <div className="container">
      <h2 className="section-title">Booked Appointments</h2>

      <div className="date-picker">
        <label>Select Date: </label>  
        <input
          type="date"
          value={selectedDate}
          onChange={(e) => setSelectedDate(e.target.value)}
        />
      </div>

      {bookedAppointments.length === 0 ? (
        <p className="info-text">No booked appointments for this day.</p>
      ) : (
        <table className="vaccine-table">
          <thead>
            <tr>
              <th>Child</th>
              <th>Gender</th>
              <th>Vaccine</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {bookedAppointments.map((appt) => (
              <tr key={appt.appointmentId}>
                <td>{appt.fullName}</td>
                <td>{appt.gender === "f" ? "Female" : "Male"}</td>
                <td>{appt.vaccinName}</td>
                <td>
                  <span className="status">{appt.status}</span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default BookedAppointmentsTable;
