import React from 'react';
import {Button, CardContent, Typography} from "@mui/material";
import  kidsImage from './dreamKids.png';

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
        backgroundColor: "black",
    },
};
// Dieser Code nimmt immer die breite des Bildes egal wie hoch es ist daher lohnt es sich hier höhere bilder zu verwenden
const cardStyle = {
    backgroundImage: `url(${kidsImage})`,
    backgroundSize: "100% auto", // Breite wird angepasst, Höhe bleibt unverändert
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
    backgroundColor: "gray",
    height: "150px", // hier ggf fürs handy anpassen
};

// dieser code passt es immer so an das entweder max breite oder Max höhe übernommen wird und das Bild im verhältniss bleibt
// const cardStyle = {
//     backgroundImage: `url(${kidsImage})`,
//     backgroundSize: "contain",
//     backgroundRepeat: "no-repeat",
//     backgroundPosition: "center",
//     backgroundColor: "gray",
//     height: "120px",
// };

const headTextStyle = {
    fontWeight: "bold",
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

export default function StyleRSPage2() {

    return (
        <div style={containerStyle}>
            <div className="actualGenre">
                <CardContent style={cardStyle}>
                    <Typography sx={kidsZone}>
                        KidsZone
                    </Typography>
                    <Typography sx={headTextStyle}>
                        Sie suchen Freizeitideen mit Kindern?
                    </Typography>

                    <Typography sx={infoTextStyle}>
                        Wählen Sie zwischen Indoor- und Outdoormöglichkeiten
                    </Typography>
                </CardContent>
                <CardContent style={{
                    display: "flex",
                    justifyContent: "space-around"
                }}>
                    <Button sx={buttonStyle}>
                        Outdoor
                    </Button>
                    {/* Hier wollte ich mal als Beispiel zeigen, welche Möglichkeiten wir haben, die Buttons oder auch Cards zu stylen. */}
                    {/* Oben ruft der Button die Konstante buttonStyle auf, welche alles an Design beinhaltet. */}
                    {/* Unten ist alles an Stil direkt im Button, was den Code unübersichtlich macht. */}
                    {/*Natürlich könnte man auch mehrere Button-Styles hinzufügen, die unterschiedlich aussehen. */}
                    {/*Zum Beispiel wird bei "Save" der Button grün und bei "Abbrechen" rot. Dafür legt man jeweils die passenden Funktionen an, */}
                    {/*wie "buttonSave" oder "buttonAbort", so dass es absolut eindeutig ist, was genau der "Style" beinhaltet.*/}
                    <Button sx={{
                        backgroundColor: "black",
                        color: "#2196F3",
                        fontWeight: "bold",
                        "&:hover": {
                            color: "yellow",
                            backgroundColor: "black"
                        },
                    }}>
                        Indoor
                    </Button>

                </CardContent>

            </div>
        </div>
    );
}

