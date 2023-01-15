package com.suraj.employee.services;

import java.util.List;

import com.suraj.employee.model.EmployeeDto;


public interface EmployeeService {
	
	public EmployeeDto createEmployee(EmployeeDto employee);
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto getEmployeeById(Integer empId);
	
	public String deleteEmployee(Integer empId);
	
	public EmployeeDto updateEmployee(Integer empId,EmployeeDto employeeDto);
	
}
