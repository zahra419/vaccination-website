function DbaInfoContainer (){
    const info={pdbStatus:'open',pdbName:'vaccinpdb',pdbVersion:'Oracle 19c',pdbRole:'primary',totalUsed:3.4,totalStorage:5.9}
    return(
        <div className="containers-row">
        <div className="container pdb">
        <span className="small-title">Database Status</span>
        <h3 className={`${info.pdbStatus}`}>{info.pdbStatus}</h3><span>{info.pdbName}</span>
        <span>{info.pdbVersion}</span>
        </div>
        <div className="container pdb">
        <span className="small-title">Role</span>
        <h1 className="main-info">{info.pdbRole}</h1>
        </div>
        <div className="container pdb">
        <span className="small-title">Storage Used</span>
        <h1 className="storage-content"><span className="main-info">{info.totalUsed}GB</span>/<span className="sec-info">{info.totalStorage}GB</span></h1>
        </div>

        </div>
    )
}
export default DbaInfoContainer;