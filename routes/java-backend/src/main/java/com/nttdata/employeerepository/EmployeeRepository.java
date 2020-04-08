package com.nttdata.employeerepository;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.employeeTO.EmployeeTO;

public interface EmployeeRepository extends CrudRepository<EmployeeTO, Integer>{

}
