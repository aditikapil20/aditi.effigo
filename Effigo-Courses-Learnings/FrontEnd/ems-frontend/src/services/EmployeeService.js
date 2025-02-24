import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

// Fetch Employee List (GET)
export const listEmployees = () => axios.get(`${REST_API_BASE_URL}/all`);


// Add Employee (POST)
export const createEmployee = (employee) => {
  return axios.post(REST_API_BASE_URL, employee, {
    headers: {
      "Content-Type": "application/json",
    },
  });
};

export const updateEmployee = (id, employee) => axios.put(`${REST_API_BASE_URL}/${id}`, employee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/' + employeeId);

