import React from "react";
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import './Menu.css';
import { useNavigate } from 'react-router-dom'

function Menu () {

    const navigate = useNavigate();

    const goToListTitles = () => {
        navigate("/listtitles");
    }
    const goToShowNote = () => {
        navigate("/shownote");
    }
    const goToAddNote = () => {
        navigate("/addnote");
    }

    return (
        <div  className="menu-nav">
             <div  className="menu-stack">
                <Stack direction="column" justifyContent="flex-end" alignItems="center" spacing={2.5}>

                    <Button sx={{fontSize: 20, color: "white"}} variant="text" onClick={goToListTitles}>View all Notes titles</Button>
                    <Button sx={{fontSize: 20, color: "white"}} variant="text" onClick={goToShowNote}>View Note</Button>
                    <Button sx={{fontSize: 20, color: "white"}} variant="text" onClick={goToAddNote}>add new Note</Button>
  
                </Stack>
            </div>
        </div>
    );

}

export default Menu
