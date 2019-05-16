package io.helidon.atp.lab.facade.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.mybatis.cdi.Transactional;

import io.helidon.atp.lab.common.exception.DBOperationException;
import io.helidon.atp.lab.entity.Employee;
import io.helidon.atp.lab.entity.EmployeeExample;
import io.helidon.atp.lab.facade.GreetFacade;
import io.helidon.atp.lab.service.EmployeeService;
import io.helidon.atp.lab.service.ManagerService;

@RequestScoped
@Transactional(rollbackFor = DBOperationException.class)
public class GreetFacadeImpl implements GreetFacade {

	@Inject
	EmployeeService employeeService;

	@Inject
	ManagerService managerService;

	@Override
	public List<Employee> listEmployees() {

		return employeeService.selectByExample(new EmployeeExample());
	}

	@Override
	public Employee selectEmployee(String employeeId) {

		EmployeeExample employeeExample = new EmployeeExample();
		io.helidon.atp.lab.entity.EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
		employeeCriteria.andEmployeeIdEqualTo(employeeId);
		return employeeService.selectByExample(employeeExample).get(0);
	}

	@Override
	public Employee insertEmployee(Employee employee) {

		int i = employeeService.insert(employee);
		if (i == 1) {
			return selectEmployee(employee.getEmployeeId());
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		String employeeId = employee.getEmployeeId();
		Employee oldEmployee = selectEmployee(employeeId);

		if (oldEmployee != null) {

			EmployeeExample employeeExample = new EmployeeExample();
			io.helidon.atp.lab.entity.EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
			employeeCriteria.andEmployeeIdEqualTo(employeeId);
			int i = employeeService.updateByExample(employee, employeeExample);
			if (i == 1) {
				return selectEmployee(employee.getEmployeeId());
			}
		}

		return null;
	}

	@Override
	public int deleteEmployee(String employeeId) {

		int i = -1;
		Employee oldEmployee = selectEmployee(employeeId);

		if (oldEmployee != null) {

			EmployeeExample employeeExample = new EmployeeExample();
			io.helidon.atp.lab.entity.EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
			employeeCriteria.andEmployeeIdEqualTo(employeeId);
			i = employeeService.deleteByExample(employeeExample);
		}

		return i;
	}

}