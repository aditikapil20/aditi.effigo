  import React, { useState } from "react";
  import { useNavigate } from "react-router-dom";
  import { createEmployee } from "../services/EmployeeService";

  const EmployeeComponent = () => {
    const [employee, setEmployee] = useState({
      firstName: "",
      lastName: "",
      email: "",
    });

    const [errors, setErrors] = useState({}); // ✅ Validation Errors Store Karne Ke Liye
    const [loading, setLoading] = useState(false); // ✅ Button Disabled Hone Ke Liye
    const navigate = useNavigate();

    // ✅ Handle Input Change
    const handleChange = (e) => {
      setEmployee({ ...employee, [e.target.name]: e.target.value });
    };

    // ✅ Validate Email Function
    const validateEmail = (email) => {
      const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
      return emailRegex.test(email);
    };

    // ✅ Handle Form Submit
    const handleSubmit = (e) => {
      e.preventDefault();
      let validationErrors = {};

      if (!employee.firstName.trim()) {
        validationErrors.firstName = "First Name is required!";
      }
      if (!employee.lastName.trim()) {
        validationErrors.lastName = "Last Name is required!";
      }
      if (!employee.email.trim()) {
        validationErrors.email = "Email is required!";
      } else if (!validateEmail(employee.email)) {
        validationErrors.email = "Enter a valid email address!";
      }

      setErrors(validationErrors);

      // ✅ Agar koi validation error nahi to API call karega
      if (Object.keys(validationErrors).length === 0) {
        setLoading(true); // ✅ Button disable karega
        createEmployee(employee)
          .then((response) => {
            console.log("Employee Added Successfully:", response.data);
            alert("Employee Added Successfully!");
            navigate("/employees"); //  Employee List Page Par Redirect Karega
          })
          .catch((error) => {
            console.error("Error Adding Employee:", error);
            alert("Failed to add employee. Try again!");
          })
          .finally(() => {
            setLoading(false); // ✅ API Response aane ke baad button enable hoga
          });
      }
    };

    return (
      <div className="container">
        <h2 className="text-center mt-4">Add Employee</h2>

        <form onSubmit={handleSubmit} className="mt-3">
          <div className="mb-3">
            <label className="form-label">First Name:</label>
            <input
              type="text"
              name="firstName"
              value={employee.firstName}
              onChange={handleChange}
              placeholder="Enter First Name"
              className={`form-control ${errors.firstName ? "is-invalid" : ""}`}
            />
            {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
          </div>

          <div className="mb-3">
            <label className="form-label">Last Name:</label>
            <input
              type="text"
              name="lastName"
              value={employee.lastName}
              onChange={handleChange}
              placeholder="Enter Last Name"
              className={`form-control ${errors.lastName ? "is-invalid" : ""}`}
            />
            {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
          </div>

          <div className="mb-3">
            <label className="form-label">Email:</label>
            <input
              type="email"
              name="email"
              value={employee.email}
              onChange={handleChange}
              placeholder="Enter Email (e.g. example@gmail.com)"
              className={`form-control ${errors.email ? "is-invalid" : ""}`}
            />
            {errors.email && <div className="invalid-feedback">{errors.email}</div>}
          </div>

          {/* ✅ Save Employee Button */}
          <button type="submit" className="btn btn-success w-100" disabled={loading}>
            {loading ? "Saving..." : "Save Employee"}
          </button>
        </form>
      </div>
    );
  };

  export default EmployeeComponent;
