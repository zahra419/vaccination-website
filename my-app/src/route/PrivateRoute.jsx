import {Navigate} from 'react-router-dom';
import { jwtDecode } from "jwt-decode";
<<<<<<< HEAD
=======

>>>>>>> fd87f22 (updates/fixes)

function PrivateRoute({ children, role }) {
  const token = localStorage.getItem("token");
  if (!token) return <Navigate to="/login" />;
  try {
    const decoded = jwtDecode(token);
    if (role && decoded.role !== role) {
      return <Navigate to="/login" />;
    }
  } catch (err) {
    return <Navigate to="/login" />;
  }
  return children;
}
export default PrivateRoute;
