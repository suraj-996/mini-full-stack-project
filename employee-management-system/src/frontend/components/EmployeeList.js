import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Employee from './Employee';
import EmployeeService from './EmployeeService';

const EmployeeList = () => {
    const navigate=useNavigate();
    const [loading,setLoading]=useState(true)
    const [employee,setEmployee]=useState(null);

    useEffect(()=>{
        const fetchData= async()=>{
            setLoading(true);
            try{
                const response=await EmployeeService.getEmployees();
                setEmployee(response.data);
            }catch(error){
                console.log(error)
            }
            setLoading(false)
        };
        fetchData();
    },[])
   
    const deleteEmployee=(e,id)=>{
        e.preventDefault();
        EmployeeService.deleteEmployee(id)
        .then((res)=>{
            if(employee){
                setEmployee((prev)=>{
                    return prev.filter((emp)=>emp.empId!==id)
                });
            }
        })
    }
    return (
        <>
            <div className='container  my-8 mx-5'>
                <div className="h-12">
                    <button className='rounded bg-slate-600 text-white px-6 py-2 font-semibold' onClick={
                        ()=>navigate("/addEmployee")
                    }>Add Employee</button>
                </div>
                <div className="flex shadow border-b">
                    <table className='min-w-full'>
                        <thead className='bg-gray-50'>
                            <tr>
                                <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>First Name</th>
                                <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Last Name</th>
                                <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Email ID</th>
                                <th className='text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-8'>Actions</th>
                            </tr>
                        </thead>
                        {!loading && (
                            <tbody className='bg-white'>
                                {employee.map((emp)=>(
                                   <Employee
                                   deleteEmployee={deleteEmployee}
                                    emp={emp} key={emp.empId}></Employee>
                                ))}
                            </tbody>
                        )}
                    </table>
                </div>
            </div>
        </>
    )
}

export default EmployeeList