import { jwtDecode } from "jwt-decode";

const token = localStorage.getItem('token');
export default  jwtDecode(token);

