import DbaInfoContainer from "../components/infocontainers";
import TablespaceOverview from "../components/tablespace";
import '../style/dba.css';

function Dba (){


    return(
        <>
        <DbaInfoContainer/>
        <TablespaceOverview/>
        </>
    )

}
export default Dba;