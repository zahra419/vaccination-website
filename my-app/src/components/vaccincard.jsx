import axios from 'axios';
import { useEffect, useState } from "react";

function VaccinCard() {
  const [vaccins, setVaccins] = useState([]);

  const [showForm, setShowForm] = useState(false);
  const [form, setForm] = useState({
    name: "",
    age: ""
  });
  useEffect(()=>{
    const getVaccins=async()=>{
    const token=localStorage.getItem('token')
    const res=await axios.get("http://localhost:8080/api/doctor/vaccins", {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
    setVaccins(res.data);
    }
    getVaccins();
   
    
  },[])
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!form.name || !form.age || !form.fabricant) return;

    const newVaccin = {
      vaccinName: form.name,
      fabricant: form.fabricant,
      monthDue: parseInt(form.age)
    };
   
    const postNewVaccin=async()=>{
      const token=localStorage.getItem('token');
      const res=await axios.post("http://localhost:8080/api/doctor/add",newVaccin,{
         headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }});
            console.log(res)
      }
      setForm({ name: "",fabricant:"", age: "" });
      postNewVaccin();
      
      setShowForm(false);
    
   
    }
    


  return (
    <div className="container">
      <h2 className="section-title">Vaccine Management</h2>

      <table className="vaccine-table">
        <thead>
          <tr>
            <th>Vaccine Name</th>
            <th>fabricant</th>
            <th>Target Age</th>
          </tr>
        </thead>
        <tbody>
          {vaccins.map(vaccin => (
            <tr key={vaccin.vaccinId}>
              <td>{vaccin.vaccinName}</td>
              <td>{vaccin.fabricant}</td>
              <td>{vaccin.monthDue} months</td>
            </tr>
          ))}
        </tbody>
      </table>

      <button className="add-btn" onClick={() => setShowForm(true)}>
        + Add Vaccine
      </button>

      {showForm && (
        <form className="add-vaccine-form" onSubmit={handleSubmit}>
          <input
            type="text"
            name="name"
            placeholder="Vaccine name"
            value={form.name}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="fabricant"
            placeholder="Fabricant"
            value={form.fabricant}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="age"
            placeholder="Target age (In months)"
            value={form.age}
            onChange={handleChange}
            required
          />

          <div className="form-actions">
            <button type="submit">Save</button>
            <button type="button" className=".btn-secondary" onClick={() => setShowForm(false)}>
              Cancel
            </button>
          </div>
        </form>
      )}
    </div>
  );
}

export default VaccinCard;