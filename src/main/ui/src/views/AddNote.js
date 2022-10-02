import React, { useEffect, useState }  from "react";
import Menu from '../components/Menu';
import Axios from 'axios'
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { useNavigate } from 'react-router-dom'

function AddNote(){

    const navigate = useNavigate();

    const [noteName, setNoteName] = useState("");
    const [noteContent, setNoteContent] = useState("");
    const [note, setNote] = useState({
        name: "",
        content: "",
    });

    const [open, setOpen] = useState(false);

    const handleClickOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
        navigate("/");

      };
  


    const addNote = () => {
        Axios.post("http://localhost:8080/addnote", {
            Name: noteName,
            Content: noteContent
        });
    }

    return(
        <div>
            <Menu/>
            <Stack direction="column" justifyContent="flex-start" alignItems="flex-start" spacing={1}>

                <TextField style = {{left: 450, top: 250, minWidth: 300}} value={noteName}
                    onChange={(e) => setNoteName(e.target.value)} id="outlined-basic" label="Note Title" variant="outlined" />
                <TextField style = {{left:300, top: 300, minWidth: 600}} value={noteContent}
                    onChange={(e) => setNoteContent(e.target.value)} id="outlined-basic" label="Note Content"  variant="outlined" />

            </Stack>

            <Button style = {{color: "#FAF8FA", backgroundColor: "#d6c7d9", top: 400, left: 550}} onClick={() => {addNote(); handleClickOpen()}}>Add Note</Button>

            <Dialog
                    open={open}
                    onClose={handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                >
                <DialogTitle id="alert-dialog-title">
                    {"If a note with the same title does not exists already, note is added."}
                </DialogTitle>
                <Button style = {{color: "#FAF8FA", backgroundColor: "#d6c7d9", left:-3}} onClick={handleClose}>OK</Button>
                </Dialog>

        </div>
    );

}


export default AddNote
