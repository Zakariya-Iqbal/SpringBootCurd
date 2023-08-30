  import logo from './logo.svg';
  import './App.css';
  import React from 'react';
  import NavBar from './components/NavBar';
  import AllDepartments from './components/AllDepartments';
  import AddDepartment from './components/AddDepartment';
  import AddEmployee from './components/AddEmployee';
  import AllEmployees from './components/AllEmployees';
  import { BrowserRouter, Routes, Route } from 'react-router-dom';
  import EditDepartment from './components/EditDepartment';
  import EditEmployee from './components/EditEmployee';
  // import Page from './components/Page';
  function App() {
    return (
      <div className="App">  
      <BrowserRouter>
      <NavBar />
        <Routes>
        <Route path="/" element = {<AllDepartments />} />
        <Route path="/add" element = {<AddDepartment />} />
      {/* // <Route path="/page" element = {<Page />} />  */}
        <Route path="/edit/:id" element = {<EditDepartment />}></Route>
        <Route path="/addemp" element = {<AddEmployee />}></Route>
        <Route path="/allemp" element = {<AllEmployees />}></Route>
        <Route path="/edite/:id" element = {<EditEmployee />}></Route>
        </Routes>
        </BrowserRouter>
      
      </div>
    );
  }

  export default App;
