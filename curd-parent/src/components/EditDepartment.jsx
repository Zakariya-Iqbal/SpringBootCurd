import { useState, useEffect } from "react";
import { FormControl, FormGroup, InputLabel, Input, Typography, Button, styled} from "@mui/material";
import { getDepartment, editDepartment} from "./service/api";
import { Navigate, useNavigate, useParams } from "react-router-dom";

const Container = styled(FormGroup)`
width: 50%;
margin: 5% auto 0 auto;
& > div {
    margin-top: 20px;
}
`

const initialvalues = {
    //departmentId: '',
    departmentName: '',
    departmentManager: '',
   // employeeName: ''
}


const EditDepartment = ()=> { 

    const [user, setUser] = useState(initialvalues)
   const navigate = useNavigate();
   const { id } = useParams();

   useEffect(() => {
        getDepartmentData();
   },[])

   const getDepartmentData = async () => {
    let response = await getDepartment(id);
    setUser(response.data);
   }

const onValueChange = (e) => {
    console.log(e.target.name,e.target.value);
    setUser({...user,[e.target.name]: e.target.value})
    console.log(user)
}
const addDepartmentDetails = async () => {
  await editDepartment(user, id);
   navigate('/');
}



    return(
        <Container>
            <Typography variant= "h4">Edit Department</Typography>
            {/* <FormControl>
                <InputLabel>Department ID</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmenyId"/>
            </FormControl> */}
            <FormControl>
                <InputLabel>Department Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmentName" value={user.departmentName}/>
            </FormControl>
            
            <FormControl>
                <InputLabel>Department Manager</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="departmentManager" value={user.departmentManager} />
            </FormControl>
            {/* <FormControl>
                <InputLabel>Employee Name</InputLabel>
                <Input onChange={(e) => onValueChange(e)} name="employeeName" value={user.employeeName}/>
            </FormControl> */}
            <FormControl>
                <Button onClick={() =>addDepartmentDetails()}variant="contained">Edit Department</Button>
            </FormControl>
            
            
    
        </Container>
    )
}
export default EditDepartment;