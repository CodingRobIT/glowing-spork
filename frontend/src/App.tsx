import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import StyleRSPage2 from "./components/StyleRSPage2";
import {Button} from "@mui/material";


function App() {

    return (
        <BrowserRouter>
            <div className="App">
                <Link to="/page2">Zu Page 2</Link>
                <Button> Header </Button>
                <Routes>
                    <Route path="/page2" element={<StyleRSPage2 />} />
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
