import React, { useEffect, useState }  from "react";
import { useParams } from "react-router-dom";
import Menu from '../components/Menu';
import Axios from 'axios'
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import './ViewNote.css'

function ViewNote () {

    const [notesList, setNotesList] = useState([]);
    const [noteName, setNoteName] = useState([]);
    const [noteContent, setNoteContent] = useState([]);

    const [note, setNote] = useState([{
        Name: "",
        Content: "",
    }]);

    const handleChangeNote = (event) => {
        setNoteName(event.target.value);
        
      };

    useEffect(() => {
        Axios.get("http://localhost:8080/allnotes").then((response) =>{

            setNotesList(response.data);
            console.log(response.data);
        })
    }, [])

    const getNote = (noteName) => {

        Axios.get("http://localhost:8080/onenote",  {
            params: {name: noteName}
         }
        ).then((response) =>{
    
        setNote(response.data);
        console.log(response.data);
    
     })}

    return(
        <div className= "box-class">
            <Menu/>
            <Box sx={{ minWidth: 300, top: 200 }}>
                        <FormControl fullWidth sx = {{top: 250, left: 250}}>
                            <InputLabel id="demo-simple-select-label">Note name</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={noteName}
                                    label="Note Name"
                                    onChange={handleChangeNote}
                                >
                                {notesList.map((val) => {
                                    return (
                                    <MenuItem value={val.Name}> {val.Name} </MenuItem>
                                    )
                                } )}
        
                                </Select>
                            </FormControl>
                            <Button style = {{color: "#FAF8FA", backgroundColor: "#d6c7d9", top: 200, left: 750}} onClick={() => {getNote(noteName)}}>Search</Button>
                    </Box>

                    <div className= 'result-box' style={{position:'absolute', left:370, top:'55%', fontSize:'100',  color: "white"}}>
                    <Box sx={{ minWidth: 450, top: 400, left: 250 }}>
                        <Card sx={{ minWidth: 450, maxHeight: 150}}>
                        <CardContent>
                            {note.Content}
                        </CardContent>
                        </Card>
                    </Box>
                    </div>
            </div>

    );


}

export default ViewNote