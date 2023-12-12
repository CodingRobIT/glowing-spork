import {InputLabel, MenuItem, Select, SelectChangeEvent} from "@mui/material";
import * as React from 'react';
import FormControl from '@mui/material/FormControl';


export default function StyleKSHome() {
    const handleChange = (event: SelectChangeEvent) => {
        setGenre(event.target.value as string);
    };

    const [genre, setGenre] = React.useState('');

    const selectSettings = {
        labelId: "select-genre-label",
        id: "select-genre",
        label: "Genre",
        value: genre,

    };

    return (
        <div>
            <p>Style Home works!</p>
            <FormControl fullWidth>
                <InputLabel id="select-genre-label">Genre</InputLabel>
                <Select {...selectSettings} onChange={handleChange}>
                    <MenuItem value={'kids'}>Kids</MenuItem>
                    <MenuItem value={'adults'}>Adults</MenuItem>
                    <MenuItem value={'family'}>Family</MenuItem>
                </Select>
            </FormControl>

        </div>
    );
}