import { jwtDecode } from "jwt-decode";

const token = localStorage.getItem('token');
const decoded=jwtDecode(token);
export default  decoded;

