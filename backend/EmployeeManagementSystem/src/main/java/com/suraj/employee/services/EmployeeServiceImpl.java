package com.suraj.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.employee.model.Employee;
import com.suraj.employee.model.EmployeeDto;
import com.suraj.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee emp=modelMapper.map(employeeDto, Employee.class);
		Employee newEmployee=employeeRepo.save(emp);
		return modelMapper.map(newEmployee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees=employeeRepo.findAll();
		return employees.stream().map(e->modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(Integer empId) {
		Employee emp=employeeRepo.findById(empId).get();
		return modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public String deleteEmployee(Integer empId) {
		Employee emp=employeeRepo.findById(empId).get();
		employeeRepo.delete(emp);
		return "Employee deleted successfully";
	}

	@Override
	public EmployeeDto updateEmployee(Integer empId, EmployeeDto employeeDto) {
		Employee emp=employeeRepo.findById(empId).get();
		emp.setEmailId(employeeDto.getEmailId());
		emp.setFirstName(employeeDto.getFirstName());
		emp.setLastName(employeeDto.getLastName());
		Employee updatedEmployee=employeeRepo.save(emp);
		return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

}
