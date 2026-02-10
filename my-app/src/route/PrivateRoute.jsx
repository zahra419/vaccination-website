import {Navigate} from 'react-router-dom';

function PrivateRoute({ children, role }) {
  const token = localStorage.getItem("token");
  if (!token) return <Navigate to="/login" />;
  try {
    const decoded = jwt_decode(token);
    if (role && decoded.role !== role) {
      return <Navigate to="/login" />;
    }
  } catch (err) {
    return <Navigate to="/login" />;
  }
  return children;
}
export default PrivateRoute;