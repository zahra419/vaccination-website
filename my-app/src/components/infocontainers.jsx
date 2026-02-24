import  { useEffect, useState } from "react";
import axios from "axios";  
function DbaInfoContainer (){
    const [pdbStorage,setPdbStorage]=useState({});
    const info={pdbStatus:'online',pdbName:'PDB_VACCINATION_PRIMARY',pdbVersion:'Oracle 19c',pdbRole:'primary',totalUsed:3.4,totalStorage:5.9}
    useEffect(()=>{
        const token=localStorage.getItem('token');
        const getStorageData=async()=>{
            try{
                const response=await axios.get('http://localhost:8080/api/dba/storage',{
                    headers:{  
                        'Authorization': `Bearer ${token}`
                    }
                });
                
                setPdbStorage(response.data[0]);
               
                
            }catch(error){
                console.error('Error fetching storage data:', error);
            }
        };
        getStorageData();
    },[])   
    
    
    return(
        <div className="containers-row">
        <div className="container pdb">
        <span className="small-title">Database Status</span>
        <div className="dbstatus">
        <h3 className={`${info.pdbStatus}`}>{info.pdbStatus}</h3><small>{info.pdbName}</small>
        <small>{info.pdbVersion}</small>
        </div>
        </div>
        <div className="container pdb">
        <span className="small-title">Role</span>
        <h1 className="main-info">{info.pdbRole}</h1>
        </div>
        <div className="container pdb">
        <span className="small-title">Storage Used</span>
        <h1 className="storage-content"><span className="main-info">{pdbStorage.usedSpaceGb} GB </span><span className="sec-info">/ {pdbStorage.totalSizeGb} GB</span></h1>
        </div>

        </div>
    )
}
export default DbaInfoContainer;