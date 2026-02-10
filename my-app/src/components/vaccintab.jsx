import VaccinationTable from "./vaccintable";
import VaccinationHistory from "./vaccinationHistory";
import '../style/tabnav.css';

import { useState } from "react";

function VaccinTab({childInfo}){
  
    
    const [active, setActive] = useState("upcoming");
    const history=[   
    {id:1,vaccin:'demdfj',doctor:'sfsd',center:'tashfine',date:'12-06-2023'},
    {id:2,vaccin:'demdfj',doctor:'sfsdfs',center:'tashfine',date:'12-06-2023'},
    {id:3,vaccin:'demdfj',doctor:'sdfsf',center:'tashfine',date:'12-06-2023'}]
    const upcoming=[   
    {id:1,vaccin:'demdfj',date:'12-06-2023'}]
  

  return (
    <>
      {/* Tabs */}
      <div className="tabs-container">
        <button
          className={`tab ${active === "history" ? "active" : ""}`}
          onClick={() => setActive("history")}
        >
          History
        </button>

        <button
          className={`tab ${active === "upcoming" ? "active" : ""}`}
          onClick={() => setActive("upcoming")}
        >
          Upcoming
        </button>
      </div>

      {/* Content */}
      <div className="tab-content">
        {active === "upcoming" && <VaccinationTable data={upcoming} childInfo={childInfo}/>}
        {active === "history" && <VaccinationHistory history={history}/>}
      </div>
    </>
  );
}

export default VaccinTab;

