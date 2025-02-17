import axios from "axios";
 
const REST_API_BASE_URL = "http://localhost:8080/api/employees/all";

export const listEmployees = () => axios.get(REST_API_BASE_URL)

// Add Employee (POST Request)
export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee);




