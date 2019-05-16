package io.helidon.atp.lab.facade;

import java.util.List;

import io.helidon.atp.lab.entity.Employee;

public interface GreetFacade {

	List<Employee> listEmployees();

	Employee selectEmployee(String employeeId);

	Employee insertEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	int deleteEmployee(String employeeId);
}
