import { useState, useEffect } from "react";
import { FormControl,InputLabel,Input, FormGroup,styled, Button, Typography} from "@mui/material";
import { getEmployee, editEmployee} from "./service/api";
import { useNavigate, useParams } from "react-router-dom";
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

const EditEmployee = ()=> {

    const [user, setUser] = useState(initialvalues)
    const navigate = useNavigate();
    const{ id } = useParams();

    useEffect(() => {
    getEmployeeData();
    },[])

    const getEmployeeData = async () => {
        try{
            let response = await getEmployee(id);
            console.log("Fetched employee:", response.data);
            setUser(response.data);
    
        } catch (error) {
            console.log('Error while fetching employee data', error);
        }
       
    }
    

    const onValueChange = (e) => {
        console.log(e.target.name,e.target.value);
        setUser({...user,[e.target.name]: e.target.value})
        console.log(user)
    }
    const addEmployeeDetails = async () => {
         await editEmployee(user, id);
       navigate('/allemp');
      }


    return(
        <Container>
            <Typography variant="h4">Edit Employee</Typography>
        <FormControl>
                <InputLabel>Employee Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeName" value={user.employeeName}/>
            </FormControl>
            
            <FormControl>
                <InputLabel>Employee email</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeEmail" value={user.employeeEmail} />
            </FormControl>
            <FormControl>
                <InputLabel> Department Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmentName" value={user.departmentName} />
            </FormControl>
            <FormControl>
                <InputLabel>Department Manager</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmentManager" value={user.departmentManager} />
            </FormControl>
            <FormControl>
                <Button onClick={() =>addEmployeeDetails()}variant="contained">Edit Employee</Button>
            </FormControl>
            </Container>
            
    )
}

export default EditEmployee;