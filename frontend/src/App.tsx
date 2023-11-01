import {BrowserRouter, Route, Routes} from "react-router-dom";
import StyleRSPage2 from "./components/StyleRSPage2";
import StyleKSHome from "./components/StyleKSHome";
import Header from "./components/Header";


function App() {

    return (
        <BrowserRouter>
            <div className="App">
                <Header/>
                <Routes>
                    <Route path="/page2" element={<StyleRSPage2 />} />
                    <Route path="/" element={<StyleKSHome/>} />
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
