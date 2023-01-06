package com.suraj.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.employee.model.EmployeeDto;
import com.suraj.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> createEmployeeController(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeesController(){
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeByIdController(@PathVariable Integer empId){
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(empId),HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeController(@PathVariable Integer empId){
		return new ResponseEntity<String>(employeeService.deleteEmployee(empId),HttpStatus.OK);
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<EmployeeDto> updateEmployeeController(@PathVariable Integer empId,@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(empId, employeeDto),HttpStatus.OK);
	}
}
