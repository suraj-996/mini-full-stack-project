import axios from "axios"

const EMPLOYEE_API_BASE_URL="http://localhost:8088/api/v1/employee"

class EmployeeService{
    saveEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE_URL,employee)
    }

    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL+"s")
    }

    deleteEmployee(id){
        return axios.delete(EMPLOYEE_API_BASE_URL+"/"+id)
    }

    getEmployeeById(id){
        return axios.get(EMPLOYEE_API_BASE_URL,+"/"+id)
    }

    updateEmployee(employee,id){
        return axios.put(EMPLOYEE_API_BASE_URL+"/"+id,employee)
    }
}

export default new EmployeeService()