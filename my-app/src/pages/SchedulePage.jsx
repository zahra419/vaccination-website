import { useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import '../style/schedule.css';

function SchedulePage() {
  const {id}=useParams();
  const location=useLocation();
  console.log(location.state)
  const {name,age}=location.state || {};
  const [form, setForm] = useState({
    id: "",
    date: "",
    center: "",
    doctor: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Scheduled:", form);
    alert(`Vaccination scheduled for ${form.vaccine} on ${form.date} at ${form.center}`);
    // Here you can send the data to backend API
  };

  return (
    <div className="container">
      <h2>Vaccination Schedule</h2>
      <h3>{name}</h3>
      <p>{id} months</p>
      <p>vaccine:</p>
      <form className="form-container" onSubmit={handleSubmit} >
      

        <label>
          Date:
          <input type="date" name="date" value={form.date} onChange={handleChange} required />
        </label>

        <label>
          Center:
          <select name="select" value={form.center} onChange={handleChange}>
            <option value="Pfizer">Pfizer</option>
            <option value="Moderna">Moderna</option>
            <option value="AstraZeneca">AstraZeneca</option>
            <option value="Johnson & Johnson">Johnson & Johnson</option>
          </select>
        </label>
        <label>
          Doctor:
          <select name="select" value={form.doctor} onChange={handleChange}>
            <option value="Pfizer">Pfizer</option>
            <option value="Moderna">Moderna</option>
            <option value="AstraZeneca">AstraZeneca</option>
            <option value="Johnson & Johnson">Johnson & Johnson</option>
          </select>
        </label>

        <button type="submit">Schedule Vaccination</button>
      </form>
    </div>
  );
}

/*const styles = {
  container: {
    maxWidth: "500px",
    margin: "50px auto",
    padding: "20px",
    borderRadius: "10px",
    boxShadow: "0 0 10px rgba(0,0,0,0.1)",
    backgroundColor: "#F5F9FF",
    fontFamily: "Arial, sans-serif",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "15px",
  },
};*/

export default SchedulePage;
