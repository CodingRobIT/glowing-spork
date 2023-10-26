import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import StyleRSPage2 from "./components/StyleRSPage2";
import StyleKSHome from "./components/StyleKSHome";


function App() {

    return (
        <BrowserRouter>
            <div className="App">
                <Link to="/"> Home </Link>
                <Link to="/page2">Zu Page 2</Link>
                <Routes>
                    <Route path="/page2" element={<StyleRSPage2 />} />
                    <Route path="/" element={<StyleKSHome/>} />
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
