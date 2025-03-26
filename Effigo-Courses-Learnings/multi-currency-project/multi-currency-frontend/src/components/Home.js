import React from "react";
import { useNavigate } from "react-router-dom";
import "../static/css/Home.css";

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div className="overlay"></div>

      <div className="content text-center">
        <h1 className="title">Multi Currency Project</h1>
        <button className="btn btn-success btn-lg" onClick={() => navigate("/multi-currency-details")}>
          View Details
        </button>
      </div>
    </div>
  );
};

export default Home;
