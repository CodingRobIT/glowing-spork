import {BrowserRouter, Route, Routes} from "react-router-dom";
import StyleRSPage2 from "./components/StyleRSPage2";
import StyleKSHome from "./components/StyleKSHome";
import KidsActivityGallery from "./components/KidsActivityGallery";
import Header from "./components/Header";
import useKidsActivity from "./CustomHooks/useKidsActivity";
import {useEffect} from "react";



function App() {

    const {kidsActivity, loadAllKidsActivity} = useKidsActivity();

    useEffect(() => {
        loadAllKidsActivity();
        //eslint-disable-next-line
    }, []);

    return (
        <BrowserRouter>
            <div className="App">
                <Header/>
                <Routes>
                    <Route path="/page2" element={<StyleRSPage2 />} />
                    <Route path="/" element={<StyleKSHome/>} />
                    <Route path="/kidsactivity" element={<KidsActivityGallery kidsActivity={kidsActivity}/>} />
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
