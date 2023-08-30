import { useState } from "react";
import { FormControl,InputLabel,Input, FormGroup,styled, Button, Typography, MenuItem, Select} from "@mui/material";
import { addEmployee } from "./service/api";
import { useNavigate } from "react-router-dom";
const Container = styled(FormGroup)`
width: 50%;
margin: 5% auto 0 auto;
& > div {
    margin-top: 20px;
}
`
const initialvalues = {
    //departmentId: '',
    employeeName: '',
    employeeEmail: '',
    departmentName: '',
    departmentManager: ''
}

const AddEmployee = ()=> {

    const [user, setUser] = useState(initialvalues)
    const navigate = useNavigate();

  const onValueChange = (e) => {
     console.log(e.target.name,e.target.value);
         setUser({...user,[e.target.name]: e.target.value})
         console.log(user)
    }
    const onDepartmentNameChange = (e) => {
        console.log("Department Name Selected:", e.target.value);
        setUser({...user, departmentName: e.target.value});
    }
    const onDepartmentManagerChange = (e) => {
        console.log("Department Manager Selected:", e.target.value);
        setUser({...user, departmentManager: e.target.value});
    }
    const addEmployeeDetails = async () => {
        if (user.employeeName && user.employeeEmail && user.departmentName && user.departmentManager){
            console.log("Adding employee:", user);
            await addEmployee(user);
            navigate('/allemp');
        }
        else {
            alert("Please enter all the required details.");
          }
      }


    return(
        <Container>
            <Typography variant="h4">Add Employee</Typography>
        <FormControl>
                <InputLabel>Employee Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeName" />
            </FormControl>
            
            <FormControl>
                <InputLabel>Employee email</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeEmail" />
            </FormControl>

            <FormControl fullWidth>
                <InputLabel> Department Name</InputLabel>
             <Select value={user.departmentName || ''} label="Department Name" onChange={onDepartmentNameChange}>
                {/* <Input onChange={(e) => onValueChange(e)} name="departmentName" />  */}
                <MenuItem value="IT">IT</MenuItem>
                <MenuItem value="Finance">Finance</MenuItem>
                </Select>
            </FormControl>
           
            <FormControl>
                <InputLabel>Department Manager</InputLabel>
                <Select value={user.departmentManager || ''}  name="departmentManager" label="Department Manager" onChange={onDepartmentManagerChange}>
              {/* <Input onChange={(e) => onValueChange(e)} name="departmentManager" /> */}
                <MenuItem value="Srikanth">Srikanth</MenuItem>
                <MenuItem value="Mohammed">Ahmed</MenuItem>
                </Select>
            </FormControl>

            <FormControl>
                <Button onClick={() =>addEmployeeDetails()}variant="contained">Add Employee</Button>
            </FormControl>
            </Container>
            
    )
}

export default AddEmployee;