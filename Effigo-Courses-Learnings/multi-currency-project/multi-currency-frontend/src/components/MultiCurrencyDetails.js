import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Table, Button, Container, Form } from "react-bootstrap";
import "../static/css/MultiCurrencyDetails.css"

const MultiCurrencyDetails = () => {
    const [data, setData] = useState([]);
    const [selectedRows, setSelectedRows] = useState([]);
    const navigate = useNavigate(); 

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = () => {
        axios.get("http://localhost:8080/api/multi-currency/all")
            .then((response) => {
                setData(response.data);
            })
            .catch((error) => {
                console.error("Error fetching data:", error);
            });
    };

    const handleCheckboxChange = (id) => {
        setSelectedRows((prevSelected) =>
            prevSelected.includes(id)
                ? prevSelected.filter((rowId) => rowId !== id) // Unselect
                : [...prevSelected, id] // Select
        );
    };

    const handleDelete = () => {
        if (selectedRows.length === 0) {
            alert("Please select at least one row to delete.");
            return;
        }

        if (window.confirm(`Are you sure you want to delete ${selectedRows.length} records?`)) {
            axios.delete("http://localhost:8080/api/multi-currency/delete", {
                data: selectedRows, // Sending selected row IDs
            })
            .then(() => {
                alert("Selected records deleted successfully.");
                setSelectedRows([]); // Clear selection
                fetchData(); // Refresh table
            })
            .catch((error) => {
                alert("Error deleting records.");
                console.error("Error:", error);
            });
        }
    };

    return (
        <Container>
            <h2 className="mt-4">View All Multicurrency Details</h2>
            <div className="d-flex justify-content-end mb-3">
                <Button variant="primary" className="me-2" onClick={() => navigate("/multi-currency-import")}>Import from Excel</Button>
                <Button variant="danger" className="me-2" onClick={handleDelete}>Delete</Button>
                <Button variant="secondary" onClick={() => navigate("/")}>Close</Button>
            </div>

            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Multi Currency ID</th>
                        <th>From Currency ID</th>
                        <th>To Currency ID</th>
                        <th>Conversion Rate</th>
                        <th>From Date</th>
                        <th>To Date</th>
                        <th>Created By</th>
                        <th>Client ID</th>
                        <th>Created Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item) => (
                        <tr key={item.multi_currency_id}>
                            <td>
                                <Form.Check 
                                    type="checkbox"
                                    checked={selectedRows.includes(item.multi_currency_id)}
                                    onChange={() => handleCheckboxChange(item.multi_currency_id)}
                                    className="custom-checkbox"
                                />
                            </td>
                            <td>{item.multi_currency_id}</td>
                            <td>{item.from_currency_id}</td>
                            <td>{item.to_currency_id}</td>
                            <td>{item.conversion_rate}</td>
                            <td>{item.from_date}</td>
                            <td>{item.to_date}</td>
                            <td>{item.created_by}</td>
                            <td>{item.client_id}</td>
                            <td>{item.created_date}</td>
                            <td>{item.status}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    );
};

export default MultiCurrencyDetails;
