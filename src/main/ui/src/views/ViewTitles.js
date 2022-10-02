import React, { useEffect, useState }  from "react";
import Menu from '../components/Menu';
import Axios from 'axios'
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Card from '@mui/material/Card';
import './ViewTitles.css'


function ViewTitles () {

    const [notesList, setNotesList] = useState([]);

    useEffect(() => {
        Axios.get("http://localhost:8080/allnotes").then((response) =>{

            setNotesList(response.data);
           console.log(response.data);
        })
    }, [])

    return(
        <div className="content-titiles">
            <Menu/>
            <div className="title-cards" style={{position:'absolute', left:215, top:'35%', fontSize:'100',  color: "white"}}>
            {notesList.map((val) => {
                return(
                    <Card sx={{ minWidth: 750, maxHeight: 150}}>
                        <CardContent>
                            <Typography sx={{ fontSize: 20}} variant="h5" component="div">
                                {val.Name}
                            </Typography>
                        </CardContent>
                    </Card>
                );
            })}

            </div>
        </div>
    );
}

export default ViewTitles