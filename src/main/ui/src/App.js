import React, { useState } from "react";
import { BrowserRouter, Route, Routes, Link} from 'react-router-dom'
import Menu from './components/Menu';
import ViewTitles from './views/ViewTitles';
import ViewNote from "./views/ViewNote";
import AddNote from "./views/AddNote";
import './App.css';


function App() {
  return (
    <div className="container-fluid homepage-bgimage">
      <BrowserRouter>

      <Routes>

      <Route exact path="/" element={< Menu />}></Route>
      <Route exact path="/listtitles" element={< ViewTitles />}></Route>
      <Route exact path="/shownote" element={< ViewNote />}></Route>
      <Route exact path="/addnote" element={< AddNote />}></Route>

      </Routes>

      </BrowserRouter>
    </div>
  );
}

export default App;
