import React from "react";

import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Footer from "./Components/Footer";
import Navigationbar from './Navigationbar';
import { BrowserRouter as Router, Switch, Route,  } from "react-router-dom";



function App() {
  return (
    <div className="App">
        <Router>
          <Navigationbar/>
          <Switch>
            <Route exact path='/' component={Home}/>
            <Route path='/about' component={About}/>
            <Route path='/about' componet={Contact}/>
          </Switch>
          <Footer/>
        </Router>
    </div>
  
    
  );
}

export default App;