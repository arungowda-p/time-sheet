package com.nttdata.employeeController;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.employeeService.EmployeeService;
import com.nttdata.employeeTO.EmployeeTO;
@RestController
public class LandingController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeTO setEmployeeRecord(@RequestBody EmployeeTO employeeTO) {
		return employeeService.saveEmployee(employeeTO);
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<EmployeeTO> getEmployeeRecord(@PathVariable int employeeId) {
		return employeeService.getEmployeeDetail(employeeId);
	}
	
	@GetMapping("/getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeTO> getAllEmployeesRecord() {
		return (List<EmployeeTO>) employeeService.findAllEmployees();
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public EmployeeTO updateEmployeeRecord(@RequestBody EmployeeTO employeeTO,@PathVariable int employeeId) {
		employeeService.updateEmployee(employeeTO,employeeId);
		return employeeTO;
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public void deleteEmployeeRecord(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}
