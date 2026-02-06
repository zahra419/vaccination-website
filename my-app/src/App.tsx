import './App.css'
import { Routes,Route,Navigate} from 'react-router-dom'
import Doctor from './pages/Doctor'
import Dba from './pages/Dba'
import Patient from './pages/Patient'
import Login from './pages/Login'
import PrivateRoute from './route/PrivateRoute'
import Layout from './components/layout'
import NotFound from './pages/notfound'

/* add private route to doctor, dashboard,patient*/
function App() {
  return (
    <Routes>
     <Route path='/' element={<Navigate to="/login"/>}/>
     <Route path='/login' element={<Login/>} />
     <Route path='/doctor' element={<PrivateRoute role='doctor'><Layout><Doctor/></Layout></PrivateRoute>} />
     <Route path='/dba' element={<PrivateRoute role='dba'><Layout><Dba/></Layout></PrivateRoute>} />
     <Route path='/patient' element={<PrivateRoute role='patient'><Layout><Patient/></Layout></PrivateRoute>}/>
     <Route path='*' element={<NotFound/>}/>
    </Routes>
  )
}
export default App
