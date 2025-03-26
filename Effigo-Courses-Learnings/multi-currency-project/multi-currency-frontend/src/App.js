import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import MultiCurrencyDetails from "./components/MultiCurrencyDetails";
import MultiCurrencyImport from "./components/MultiCurrencyImport";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/multi-currency-details" element={<MultiCurrencyDetails />} />
                <Route path="/multi-currency-import" element={<MultiCurrencyImport />} />
            </Routes>
        </Router>
    );
}

export default App;
