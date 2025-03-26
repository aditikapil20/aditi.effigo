import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import { FaUpload, FaDownload, FaArrowLeft } from "react-icons/fa";
import * as XLSX from "xlsx"; 
import axios from "axios"; 

const MultiCurrencyImport = () => {
    const [file, setFile] = useState(null);
    const [excelData, setExcelData] = useState([]);
    const navigate = useNavigate();

    const handleFileChange = (event) => {
        const selectedFile = event.target.files[0];
        if (selectedFile && (selectedFile.name.endsWith(".xls") || selectedFile.name.endsWith(".xlsx"))) {
            setFile(selectedFile);
            readExcel(selectedFile);
        } else {
            alert("Only .xls and .xlsx files are allowed!");
            setFile(null);
            setExcelData([]);
        }
    };

    const readExcel = (file) => {
        const reader = new FileReader();
        reader.readAsBinaryString(file);
        reader.onload = (e) => {
            const binaryData = e.target.result;
            const workbook = XLSX.read(binaryData, { type: "binary" });
            const sheetName = workbook.SheetNames[0];
            const sheet = workbook.Sheets[sheetName];
            const parsedData = XLSX.utils.sheet_to_json(sheet);
            setExcelData(parsedData);
        };
    };

    const handleImportClick = () => {
        document.getElementById("fileInput").click();
    };

    const handleSubmit = async () => {
        if (!file) {
            alert("Please select a valid Excel file before submitting.");
            return;
        }
        if (excelData.length === 0) {
            alert("No data found in the Excel file!");
            return;
        }

        try {
            const response = await axios.post("http://localhost:8080/api/multi-currency/add-list", excelData, {
                headers: { "Content-Type": "application/json" },
            });

            if (response.status === 200) {
                alert("Data uploaded successfully!");
                setFile(null);
                setExcelData([]);
                navigate("/multi-currency-details");
            }
        } catch (error) {
            console.error("Error uploading data:", error);
            alert("Failed to upload data.");
        }
    };

    const handleDownloadTemplate = () => {
        const fileUrl = "https://multi-currency-project-bucket.s3.us-east-1.amazonaws.com/multi_currency_template_file.xlsx";
    
        const link = document.createElement("a");
        link.href = fileUrl;
        link.setAttribute("download", "multi_currency_template_file.xlsx"); 
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    };
    
    

    const handleBack = () => {
        navigate("/multi-currency-details");
    };

    return (
        <div className="container mt-4">
            <div className="d-flex justify-content-between align-items-center">
                <h2 className="text-left">Multi Currency Spreadsheet</h2>
                <Button variant="secondary" onClick={handleBack}>
                    <FaArrowLeft className="me-2" /> Back
                </Button>
            </div>

            <div className="mt-3 d-flex align-items-center">
                <span className="me-3">Multi Currency Document</span>

                <input type="file" id="fileInput" accept=".xls,.xlsx" onChange={handleFileChange} style={{ display: "none" }} />

                <Button variant="primary" className="me-2" onClick={handleImportClick}>
                    <FaUpload className="me-2" /> Import
                </Button>

                <Button variant="success" onClick={handleSubmit}>Submit</Button>
            </div>

            {file && (
                <div className="mt-2">
                    <strong>Selected File: </strong> {file.name}
                </div>
            )}

            <div className="mt-3">
                <span className="me-3">Multi Currency Template File</span>
                <Button variant="info" onClick={handleDownloadTemplate}>
                    <FaDownload />
                </Button>
            </div>

            <div className="mt-4 border p-3">
                <strong>Note:</strong>
                <ul>
                    <li>Download the Excel file in application as (.xls) or (.xlsx), NOT (.XLS) or (.XLSX)</li>
                    <li>Should not upload different formats (for .xls, do not upload .xlsx or vice versa)</li>
                    <li>Do not change first-row heading content and order, write user details in the next row</li>
                    <li>Currency content should match the application database</li>
                    <li>While uploading the file, DO NOT USE DOUBLE CLICK, USE SINGLE CLICK on IMPORT BUTTON</li>
                </ul>
            </div>
        </div>
    );
};

export default MultiCurrencyImport;
