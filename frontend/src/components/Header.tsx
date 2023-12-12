import {AppBar, Button, Toolbar, Typography} from "@mui/material";
import {Link} from "react-router-dom";
export default function Header() {

    return(
        <AppBar className="header" position="static" sx={{bgcolor: "#1E2432"}}>
            <Toolbar sx={{justifyContent: "center"}}>
                <div>
                    <Typography variant="h6" component="div" align="center">
                        Do-It!
                    </Typography>
                    <div>
                        <Button component={Link} to="/">Home</Button>
                        <Button component={Link} to="/page2">Zu Page 2</Button>
                    </div>
                </div>
            </Toolbar>
        </AppBar>
    );
}
