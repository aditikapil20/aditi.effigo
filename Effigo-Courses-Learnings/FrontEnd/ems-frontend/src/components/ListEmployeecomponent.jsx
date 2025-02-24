import React, { useEffect, useState } from "react";
import { listEmployees, updateEmployee ,deleteEmployee } from "../services/EmployeeService.js";
import { useNavigate } from "react-router-dom";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const [selectedEmployee, setSelectedEmployee] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    fetchEmployees();
  }, []);
  //  [] function pass krna , jisse sara render na ho 

  const fetchEmployees = async () => {
    try {
      const response = await listEmployees();
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching employees:", error);
    }
  };

  const handleUpdateClick = (employee) => {
    setSelectedEmployee(employee);
    setShowModal(true);
  };

  const handleInputChange = (e) => {
    setSelectedEmployee({ ...selectedEmployee, [e.target.name]: e.target.value });
  };

  const handleSave = async () => {
    // ind. work kr ske ,execution me kisi pr depend na krna pde 
    try {
      await updateEmployee(selectedEmployee.id, selectedEmployee);
      setEmployees((prevEmployees) =>
        prevEmployees.map((emp) => (emp.id === selectedEmployee.id ? { ...selectedEmployee } : emp))
      );
      alert("Employee updated successfully!");
      setShowModal(false);
    } catch (error) {  
      console.error("Error updating employee:", error);
      alert("Failed to update employee!");
    }
  };

  const removeEmployee = async (id) => {
    try {
      await deleteEmployee(id);
      setEmployees((prevEmployees) => prevEmployees.filter((emp) => emp.id !== id));
      alert("Employee deleted successfully!");
    } catch (error) {
      console.error("Error deleting employee:", error);
      alert("Failed to delete employee!");
    }
  };


  return (
    <div className="container d-flex flex-column align-items-center my-4">
      <h2 className="text-center mb-3">List of Employees</h2>
      <button className="btn btn-primary mb-3" onClick={() => navigate("/add-employee")}>
        Add Employee
      </button>
      
      <div className="table-responsive" style={{ maxHeight: "400px", overflowY: "auto", width: "80%" }}>
        <table className="table table-striped table-bordered text-center">
          <thead className="table-dark">
            <tr>
              <th>Employee Id</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.length > 0 ? (
              employees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.id}</td>
                  <td>{employee.firstName}</td>
                  <td>{employee.lastName}</td>
                  <td>{employee.email}</td>
                  <td>
                    <button className="btn btn-info btn-sm" onClick={() => handleUpdateClick(employee)}>
                      Update
                    </button>
                    <button className="btn btn-danger btn-sm ms-2" onClick={() => removeEmployee(employee.id)}>
                      Delete
                    </button>
                    
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="5" className="text-center">
                  No Employees Found
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      {showModal && selectedEmployee && (
        <div className="modal-overlay">
          <div className="modal-container">
            <div className="modal-header">
              <h5 className="modal-title">Update Employee</h5>
              <button className="btn-close" onClick={() => setShowModal(false)}></button>
            </div>
            <div className="modal-body">
              <label className="form-label">First Name:</label>
              <input
                type="text"
                name="firstName"
                value={selectedEmployee.firstName}
                onChange={handleInputChange}
                className="form-control mb-2"
              />
              <label className="form-label">Last Name:</label>
              <input
                type="text"
                name="lastName"
                value={selectedEmployee.lastName}
                onChange={handleInputChange}
                className="form-control mb-2"
              />
              <label className="form-label">Email:</label>
              <input
                type="email"
                name="email"
                value={selectedEmployee.email}
                onChange={handleInputChange}
                className="form-control mb-2"
              />
            </div>
            <div className="modal-footer">
              <button className="btn btn-secondary" onClick={() => setShowModal(false)}>
                Cancel
              </button>
              <button className="btn btn-success" onClick={handleSave}>
                Save Changes
              </button>
            </div>
          </div>
        </div>
      )}

      {/* Modal Styling */}
      <style>{`
        .modal-overlay {
          position: fixed;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          background: rgba(0, 0, 0, 0.5);
          display: flex;
          justify-content: center;
          align-items: center;
        }

        .modal-container {
          background: white;
          padding: 20px;
          border-radius: 10px;
          width: 400px;
          box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        }

        .modal-header {
          display: flex;
          justify-content: space-between;
          align-items: center;
          border-bottom: 1px solid #ddd;
          padding-bottom: 10px;
        }

        .table-responsive {
          border-radius: 10px;
          box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        }
      `}</style>
    </div>
  );
};

export default ListEmployeeComponent;
