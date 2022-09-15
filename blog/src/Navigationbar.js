import React from "react";
import {Nav, Navbar, NavLink} from "react-bootstrap";
import{ Link } from "react-router-dom";
import "./App.css";

const Navigationbar = () =>{
    return(
        <Navbar className="color-nav" collapseOnSelect expand="sm"variant="light">
            <Navbar.Toggle aria-controls="navbarScroll" data-bs-target="#navbarScroll"/>
            <Navbar.Collapse id="navbarScroll">
                <Nav>
                    <NavLink eventKey="1" as={Link} to="/">Home</NavLink>
                    <NavLink eventKey="2" as={Link} to="/about">About</NavLink>
                    <NavLink eventKey="3" as={Link} to="/contact">Contact</NavLink>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}

export default Navigationbar;
