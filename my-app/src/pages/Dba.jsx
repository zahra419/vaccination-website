import DbaInfoContainer from "../components/infocontainers";
import TablespaceOverview from "../components/tablespace";
import '../style/dba.css';

function Dba (){


    return(
        <div className="dbaPage">
        <DbaInfoContainer/>
        <TablespaceOverview/>
        </div>
    )

}
export default Dba;