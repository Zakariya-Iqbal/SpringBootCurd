
import { useEffect, useState } from "react";
import { Button, Table, TableBody, TableCell, TableHead, TableRow, styled } from "@mui/material";
import { getEmployees, deleteEmployee } from "./service/api";
//import { getAllEmployees, getEmployeesWithDepartments, deleteEmployee} from "./service/api";

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


const AllEmployees = () => {


    const [users, setUsers] = useState([]);
    useEffect(() => {
     getEmployeesDetails(); 
    // fetchEmployeesWithDepartments();
    },[])
   
   const getEmployeesDetails = async () => {
    try{
        let response = await getEmployees();
        console.log("Fetched employees:", response.data);
       setUsers(response.data);
    }   
    catch (error) {
        console.error("Error fetching employees data:", error);
      }
    }
// const fetchEmployeesWithDepartments = async () => {
//     try {
//       const employeesData = await getEmployeesWithDepartments();
//       console.log("Fetched employees:", employeesData);
//       setUsers(employeesData);
//     } catch (error) {
//       console.error("Error fetching employees data:", error);
//     }
//   };
   const deleteEmployeeData = async (employeeId) => {
      await deleteEmployee(employeeId);
     getEmployeesDetails();
    }
// const deleteEmployeeData = async (employeeId) => {
//     await deleteEmployee(employeeId);
//     fetchEmployeesWithDepartments(); // Refresh the data after deletion
//   };

console.log("employee");
console.log(users);
    return(
        <StyledTable>
            <TableHead>
                <Thead>
                    <TableCell>Emoloyee Id</TableCell>
                    <TableCell>Employee Name</TableCell>
                    <TableCell>Employee email</TableCell>
                    <TableCell>Department Name</TableCell>
                    <TableCell>Department Manager</TableCell>
                    <TableCell>Action</TableCell>
                </Thead>
            </TableHead>
            <TableBody>
{
    users.map(user => (
        <TBody key={user.employeeId
}>

            <TableCell>{user.employeeId
}</TableCell>
            <TableCell>{user.employeeName}</TableCell>
            <TableCell>{user.employeeEmail}</TableCell>
            <TableCell>{user.departmentName}</TableCell>
            <TableCell>{user.departmentManager}</TableCell>
              <TableCell>
                <Button variant="contained" style={{marginRight: 10}} component={Link} to={`/edite/${user.employeeId
}`}>Edit</Button> 
             <Button variant="contained" onClick={() => deleteEmployeeData(user.employeeId)}>Delete</Button>  
              </TableCell>
    
        </TBody>
    ))
}
            </TableBody>
        </StyledTable>
        
    );
}
export default AllEmployees;