import React from 'react'

const FooterComponent = ({ copyright = "© 2025 Employee Management System. All Rights Reserved." }) => {
    return (
      <footer className="bg-dark text-white py-3 text-center fixed-bottom">
        <p>{copyright}</p>
      </footer>
    );
  };

export default FooterComponent