package com.nttdata.employeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nttdata.employeeTO.EmployeeTO;
import com.nttdata.employeerepository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
		return employeeRepository.save(employeeTO);
	}
	public List<EmployeeTO> findAllEmployees() {
        return (List<EmployeeTO>) employeeRepository.findAll();
    }
	public Optional<EmployeeTO> getEmployeeDetail(int employeeId) {
		return employeeRepository.findById(employeeId);
	}
	public EmployeeTO updateEmployee(EmployeeTO employeeTO, int employeeId) {
		return employeeRepository.findById(employeeId).map(employee->
		{employee.setEmployeeId(employeeTO.getEmployeeId());
		 employee.setEmployeeName(employeeTO.getEmployeeName());
		 employee.setEmployeeMail(employeeTO.getEmployeeMail());
		 return employeeRepository.save(employee);}).orElseGet(() -> {
	            employeeTO.setEmployeeId(employeeId);
	            return employeeRepository.save(employeeTO);
	        });
		
	}
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

}
