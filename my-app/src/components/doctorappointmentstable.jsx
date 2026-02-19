import { useState } from "react";

function BookedAppointmentsTable() {
  // Example list of appointments
  const appointments = [
    { id: 1, child: "Alice", gender: "f", vaccin: "MMR", date: "2026-02-15", status: "Booked" },
    { id: 2, child: "Bob", gender: "m", vaccin: "Polio", date: "2026-02-16", status: "Rejected" },
    { id: 3, child: "Charlie", gender: "m", vaccin: "Hepatitis B", date: "2026-02-15", status: "Booked" },
    { id: 4, child: "Diana", gender: "f", vaccin: "MMR", date: "2026-02-13", status: "Booked" },
  ];

  // Initialize selectedDate to today
  const today = new Date();
  const yyyy = today.getFullYear();
  const mm = String(today.getMonth() + 1).padStart(2, "0");
  const dd = String(today.getDate()).padStart(2, "0");
  const todayDate = `${yyyy}-${mm}-${dd}`;

  const [selectedDate, setSelectedDate] = useState(todayDate);

  // Filter only Booked appointments for selected date
  const bookedAppointments = appointments
    .filter((appt) => appt.status === "Booked" && appt.date === selectedDate)
    .sort((a, b) => new Date(a.date) - new Date(b.date));

  return (
    <div className="container vaccin">
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
              <tr key={appt.id}>
                <td>{appt.child}</td>
                <td>{appt.gender === "f" ? "Female" : "Male"}</td>
                <td>{appt.vaccin}</td>
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
