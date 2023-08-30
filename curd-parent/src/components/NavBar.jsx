
import React from "react";
import { AppBar, Toolbar, Typography} from '@mui/material';
import styled from "@emotion/styled";
import { NavLink } from "react-router-dom";

const Header = styled(AppBar)`
background: #111111;
`
const Tabs = styled(NavLink)`
font-size: 20px;
margin-right: 20px;
color: inherit;
text-decoration: none;
`

const NavBar = () => {
    console.log("Navbar");
 return(
    <Header position="static">
        <Toolbar>
            {/* <Tabs>CRUD APPLICATION</Tabs> */}
<Tabs to={"/"}>All Departments</Tabs>
<Tabs to={"/add"}>Add Department</Tabs>
<Tabs to={"/addemp"}>Add Employee</Tabs>
<Tabs to={"/allemp"}>All Employees</Tabs>
        </Toolbar>
    </Header>
 )
}
export default NavBar;