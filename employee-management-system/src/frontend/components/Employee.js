import React from 'react'
import { useNavigate } from 'react-router-dom';

const Employee = ({emp,deleteEmployee}) => {
    const navigate=useNavigate();
    const editEmployee=(e,id)=>{
        e.preventDefault();
        navigate(`/editEmployee/${id}`);
    }
    return (
        <tr key={emp.empId}>
            <td className='text-left px-6 py-4 whitespace-nowrap'>
                <div className="text-sm text-gray-500">{emp.firstName}</div>
            </td>
            <td className='text-left px-6 py-4 whitespace-nowrap'>
                <div className="text-sm text-gray-500">{emp.lastName}</div>
            </td>
            <td className='text-left px-6 py-4 whitespace-nowrap'>
                <div className="text-sm text-gray-500">{emp.emailId}</div>
            </td>
            <td className='text-right px-6 py-4 whitespace-nowrap font-medium text-sm'>
                <a href="#" className='text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer'
                onClick={(e,id)=>editEmployee(e,emp.empId)}
                >Edit</a>
                <a
                onClick={(e,id)=>deleteEmployee(e,emp.empId)}
                href="#" className='text-indigo-600 hover:text-indigo-800 px-2 hover:cursor-pointer'>Delete</a>
            </td>
        </tr>
    )
}

export default Employee
