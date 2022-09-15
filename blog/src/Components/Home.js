import React from "react";
import './style.css';
import logo from './Images/gettyimages-1034485472-612x612.jpg';

const Home = () => {
  return (
      <div>
        <header>
          <h1 className="header">Cherry Blossom</h1>
        </header>
        <div className ="logo">
          <img src={logo} width="450" height="225"/>
        </div>
        <p className="p">
          Laboris cupidatat laborum tempor do labore ullamco irure velit incididunt reprehenderit cupidatat culpa esse eiusmod. Esse labore pariatur elit minim amet veniam do ea. Nostrud nulla cupidatat occaecat Lorem Lorem mollit laborum ut magna labore laboris. Aliquip incididunt sint magna ullamco ad est eiusmod consectetur Lorem sunt eiusmod. Incididunt enim in qui nostrud occaecat culpa deserunt tempor nostrud veniam ad voluptate. Laboris sunt magna ad incididunt et amet aliqua esse do deserunt dolor laborum ex. Ut anim Lorem veniam ad minim occaecat.
        </p>
      </div>
    
  );
}

export default Home;