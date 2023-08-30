import axios from 'axios';

const API_URL = 'http://localhost:8080';  

 export const addDepartment = async (data) => {
  console.log(data,"deta"); 
  try {
       return  await axios.post(`${API_URL}/departments`, data);
     }
 catch(error){
     console.log('Error while catching addDepartment api', error.message);
 }
 }

export const getDepartments = async () => {
  try {
    return  await axios.get(`${API_URL}/departments`);
  }
catch(error){
  console.log('Error while catching getDepartments api', error.message);
}
}


export const getDepartment = async (id) => {
  try {
    return  await axios.get(`${API_URL}/departments/${id}`);
  }
catch(error){
  console.log('Error while catching getDepartment api', error.message);
}
}

export const editDepartment = async (data, id) => {
  try {
    return  await axios.put(`${API_URL}/departments/${id}`, data);
  }
catch(error){
  console.log('Error while catching editDepartment api', error.message);
}
}

export const deleteDepartment = async (id) => {
  try {
    return  await axios.delete(`${API_URL}/departments/${id}`);
  }
catch(error){
  console.log('Error while catching deleteDepartment api', error.message);
}
}

//for Employee
export const addEmployee = async (data) => {
  try {
    return  await axios.post(`${API_URL}/employees`, data);
  }
catch(error){
  console.log('Error while catching addEmployee api', error.message);
}
}

export const getEmployees = async () => {
  try {
    return  await axios.get(`${API_URL}/combined`);
  }
catch(error){
  console.log('Error while catching getEmployees api', error.message);
}
}

 export const getEmployee = async (id) => {
  try {
   const response = await axios.get(`${API_URL}/employees/${id}`);
   console.log(response);
   return response;
  } 
catch(error){
  console.log('Error while catching getEmployee api', error.message);
}
}

// export const getAllEmployees = async () => {
//   try {
//     const response = await axios.get(`${API_URL}/employees`);
//     return response.data;
//   } catch (error) {
//     throw error;
//   }
// };

// export const getEmployeesWithDepartments = async () => {
//   try {
//     const response = await axios.get(`${API_URL}/combined/employees-with-departments`);
//     return response.data;
//   } catch (error) {
//     throw error;
//   }
// };



export const editEmployee = async (data, id) => {
  try {
    return  await axios.put(`${API_URL}/employees/${id}`, data);
  }
catch(error){
  console.log('Error while catching editEmployee api', error.message);
}
}
console.log("data");
export const deleteEmployee = async (id) => {
  try {
    return  await axios.delete(`${API_URL}/employees/${id}`);
  }
catch(error){
  console.log('Error while catching deleteEmployee api', error.message);
}
}
