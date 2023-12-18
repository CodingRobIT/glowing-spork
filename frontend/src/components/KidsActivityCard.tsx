import {KidsActivity} from "../models/KidsActivity";
import {useNavigate} from "react-router-dom";
import React from "react";
import {Box, Button, Card, CardActions, CardContent, CardHeader} from "@mui/material";


type KidsActivityProps = {
    kidsActivity: KidsActivity;
};

export default function KidsActivityCard(props: KidsActivityProps) {
    const navigate = useNavigate();

    return (
        <Box sx={{ display: 'flex', flexWrap: 'wrap' }}>
            <Card sx={{ maxWidth: 345, bgcolor: '#2E3B55', color: '#fff', margin: '16px' }}>
                <CardHeader title={props.kidsActivity.name} />
                <CardContent>
                    {/*<img src={props.game.imageUrl}*/}
                    {/*     alt="Ohne Bild"*/}
                    {/*     style={{ objectFit: 'cover', width: '100%', height: '100%' }} />*/}
                </CardContent>
                <CardActions sx={{
                    display: 'flex',
                    justifyContent: 'center'
                }}>
                    <Button sx={{
                        color: '#fff',
                        fontWeight: 'bold' }}
                            size="small"
                            onClick={() => navigate('/kidsactivity/' + props.kidsActivity.id)}>
                        Game Details
                    </Button>
                </CardActions>
            </Card>
        </Box>

    );
}