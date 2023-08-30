import { useState } from "react";
import { FormControl, FormGroup, InputLabel, Input, Typography, Button, styled, Select} from "@mui/material";
import { addDepartment } from "./service/api";
import { useNavigate } from "react-router-dom";

const Container = styled(FormGroup)`
width: 50%;
margin: 5% auto 0 auto;
& > div {
    margin-top: 20px;
}
`
console.log("add department");
const initialvalues = {
    //departmentId: '',
    departmentName: '',
    departmentManager: '',
    // employeeName: ''
}


const AddDepartment = ()=> {

    const [user, setUser] = useState(initialvalues)
   const navigate = useNavigate();

const onValueChange = (e) => {
   // console.log(e.target.name,e.target.value);
    setUser({...user,[e.target.name]: e.target.value})
   //console.log(user)
}
    const addDepartmentDetails = async () => {
    // console.log(user,"user");
    if (!user.departmentName || !user.departmentManager) {
        alert("Please provide both department name and manager.");
        return;
    }
    await addDepartment(user);
    navigate('/');
    }



    return(
        <Container>
            <Typography variant= "h4">Add Department</Typography>
            {/* <FormControl>
                <InputLabel>Department ID</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmenyId"/>
            </FormControl> */}
            <FormControl>
                <InputLabel>Department Name</InputLabel>
                 
                <Input onChange={(e) => onValueChange(e)} name="departmentName" />  
             
            </FormControl>
            
            <FormControl>
                <InputLabel>Department Manager</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmentManager" />
            </FormControl>
            {/* <FormControl>
                <InputLabel>Employee Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeName" />
            </FormControl> */}
            <FormControl>
                <Button onClick={addDepartmentDetails}variant="contained">Add Department</Button>
            </FormControl>
            
            
    
        </Container>
    )
}
export default AddDepartment;