import React, {useEffect, useState} from 'react';
import {KidsActivity} from "../models/KidsActivity";
import useKidsActivity from "../CustomHooks/useKidsActivity";
import {TextField} from "@mui/material";
import KidsActivityCard from "./KidsActivityCard";


const containerStyle = {
    display: "flex",
    justifyContent: "center",
    height: "280vh",
    backgroundColor: "lightblue",
};

const buttonStyle = {
    backgroundColor: "black",
    color: "#2196F3",
    fontWeight: "bold",
    "&:hover": {
        color: "yellow",
        backgroundColor: "blue",
    },
};
// Dieser Code nimmt immer die Breite des Bildes, egal wie hoch es ist. Daher lohnt es sich hier, höhere Bilder zu verwenden.
const cardStyle = {
    //backgroundImage: `url(${kidsImage})`,
    backgroundSize: "100% auto", // Breite wird angepasst, Höhe bleibt unverändert
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
    backgroundColor: "gray",
    height: "150px", // Hier sollte, wenn nötig die Anpassung für mobile Geräte vorgenommen werden, damit die Schrift im Banner sichtbar bleibt.
};

// Dieser Code passt das Bild immer so an, dass entweder die maximale Breite oder maximale Höhe übernommen wird, und das Bild im Verhältnis bleibt.
// const cardStyle = {
//     backgroundImage: `url(${kidsImage})`,
//     backgroundSize: "contain",
//     backgroundRepeat: "no-repeat",
//     backgroundPosition: "center",
//     backgroundColor: "gray",
//     height: "120px",
// };

const headTextStyle = {
    fontWeight: "snow",
    color: "snow",
    textAlign: "center",
};

const infoTextStyle = {
    color: "snow",
    textAlign: "center"
};

const kidsZone = {
    fontSize: "2rem", // Doppelt so groß wie die normale Schrift
    fontFamily: "Comic Sans MS", // Hier kannst du die gewünschte Schriftart einfügen
    fontWeight: "bold",
    color: "snow",
    textAlign: "center",
    marginBottom: "1em", // Fügt eine separate Leerzeile hinzu
};

type KidsActivityGalleryProps = {
    kidsActivity: KidsActivity[],
}

export default function KidsActivityGallery(props: KidsActivityGalleryProps) {
    const { loadAllKidsActivity } = useKidsActivity();
    const [searchTerm, setSearchTerm] = useState("");

    const filteredKidsActivity = props.kidsActivity.filter(activity =>
        activity.name.toLowerCase().includes(searchTerm.toLowerCase())
    );

    useEffect(() => {
        loadAllKidsActivity().catch((response) => {
            console.error(response);
        });
        //eslint-disable-next-line
    }, []);

    return (
        <div>
            <div className="searchbar">
                <TextField id="outlined-basic"
                           label="Nach Aktivitäten für Kinder Suchen..."
                           variant="filled"
                           value={searchTerm}
                           InputProps={{sx: {color: "deepskyblue", fontWeight: "bold"}}}
                           InputLabelProps={{sx: {color: "Snow"}}}
                           onChange={(e) => setSearchTerm(e.target.value)}/>
                <div className="game-cards">
                    {[...filteredKidsActivity].reverse().map((card) => (
                        // eslint-disable-next-line react/jsx-no-undef
                        <KidsActivityCard key={card.id} kidsActivity={card}/>
                    ))}
                </div>
            </div>
        </div>
    );
}


