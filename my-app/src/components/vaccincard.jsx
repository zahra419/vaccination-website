import axios from "axios";
import { useEffect, useState } from "react";

function VaccinCard() {
  const [vaccins, setVaccins] = useState([]);

  const [showForm, setShowForm] = useState(false);

  const [form, setForm] = useState({
    name: "",
    fabricant: "",
    age: ""
  });

  // ✅ Load vaccines list
  const fetchVaccins = async () => {
    try {
      const token = localStorage.getItem("token");

      const res = await axios.get(
        "http://localhost:8080/api/doctor/vaccins",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      setVaccins(res.data);
    } catch (error) {
      console.error("Error fetching vaccines", error);
    }
  };

  // ✅ Load data when page opens
  useEffect(() => {
    fetchVaccins();
  }, []);

  // ✅ Handle form change
  const handleChange = (e) => {
    const { name, value } = e.target;

    setForm((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  // ✅ Submit new vaccine
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!form.name || !form.age || !form.fabricant) return;

    try {
      const newVaccin = {
        vaccinName: form.name,
        fabricant: form.fabricant,
        monthDue: parseInt(form.age)
      };

      const token = localStorage.getItem("token");

      await axios.post(
        "http://localhost:8080/api/doctor/add",
        newVaccin,
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      // ✅ Refresh table after adding vaccine
      fetchVaccins();

      // Reset form
      setForm({
        name: "",
        fabricant: "",
        age: ""
      });

      setShowForm(false);
    } catch (error) {
      console.error("Error adding vaccine", error);
    }
  };

  return (
    <div className="container">
      <h2 className="section-title">Vaccine Management</h2>

      {/* Vaccine Table */}
      <table className="vaccine-table">
        <thead>
          <tr>
            <th>Vaccine Name</th>
            <th>Fabricant</th>
            <th>Target Age (months)</th>
          </tr>
        </thead>

        <tbody>
          {vaccins.map((vaccin) => (
            <tr key={vaccin.vaccinId}>
              <td>{vaccin.vaccinName}</td>
              <td>{vaccin.fabricant}</td>
              <td>{vaccin.monthDue} months</td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Add Vaccine Button */}
      <button className="add-btn" onClick={() => setShowForm(true)}>
        + Add Vaccine
      </button>

      {/* Add Vaccine Form */}
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
            type="number"
            name="age"
            placeholder="Target age (months)"
            value={form.age}
            onChange={handleChange}
            required
          />

          <div className="form-actions">
            <button type="submit">Save</button>

            <button
              type="button"
              className="btn-secondary"
              onClick={() => setShowForm(false)}
            >
              Cancel
            </button>
          </div>
        </form>
      )}
    </div>
  );
}

export default VaccinCard;