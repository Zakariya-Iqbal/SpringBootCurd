
import { useEffect, useState } from "react";
import { Button, Table, TableBody, TableCell, TableHead, TableRow, styled } from "@mui/material";
import { getDepartments, deleteDepartment } from "./service/api";
import { Link } from "react-router-dom";


const StyledTable = styled(Table)`
width: 90%;
margin: 50px auto 0 auto;
`;
const Thead = styled(TableRow)`
background: #000;
& > th {
    color: #fff;
    font-size: 20 px
} 
`

const TBody = styled(TableRow)`
& > td {
    font-size: 20 px
} 
`


const AllDepartments = ()=> { 

const [users, setUsers] = useState([]);
 useEffect(() => {
  getDepartmentsDetails();
 },[])

 const getDepartmentsDetails = async () => {
   console.log("department");
    try{
        let response = await getDepartments();
        console.log(response);
      setUsers(response.data);
    }catch (error) {
        console.error("Error fetching department data:", error);
    }
}
 
const deleteDepartmentData = async (id) => {
    console.log(users.departmentId);
    await deleteDepartment(id);
    getDepartmentsDetails();
}
console.log(users.departmentId);
    return(
        <StyledTable>
            <TableHead>
                <Thead>
                    <TableCell>Department Id</TableCell>
                    <TableCell>Department Name </TableCell>
                    <TableCell>Department Manager</TableCell>
                     <TableCell>Action</TableCell> 
                </Thead>
            </TableHead>
            <TableBody>
{
    users.map(user => (
        <TBody key={user.id}>
            <TableCell>{user.departmentId}</TableCell>
            <TableCell>{user.departmentName}</TableCell>
            <TableCell>{user.departmentManager}</TableCell>
         <TableCell>{user.Action}
         <TableCell>
                <Button variant="contained" style={{marginRight: 10}} component={Link} to={`/edit/${user.departmentId}`}>Edit</Button>
                <Button variant="contained" onClick={() => deleteDepartmentData(user.departmentId)}>Delete</Button>
              </TableCell>
         
         </TableCell>  
             
    
        </TBody>

    ))
}
            </TableBody>
        </StyledTable>
    )
}
export default AllDepartments;