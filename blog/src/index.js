import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
//import './App.css';
import Footer from './Components/Footer';
//import './index.css';
import{ BrowserRouter as Router} from 'react-router-dom';
export {default} from "./Components/Footer";

ReactDOM.render(
  <Router>
      <App/>
    
  </Router>,
  document.getElementById('root')
);

