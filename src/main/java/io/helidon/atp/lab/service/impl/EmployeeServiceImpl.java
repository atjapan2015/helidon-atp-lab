package io.helidon.atp.lab.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.helidon.atp.lab.common.exception.DBOperationException;
import io.helidon.atp.lab.entity.Employee;
import io.helidon.atp.lab.entity.EmployeeExample;
import io.helidon.atp.lab.mapper.EmployeeMapper;
import io.helidon.atp.lab.service.EmployeeService;

@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	EmployeeMapper employeeMapper;

	@Override
	public long countByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(EmployeeExample example) {

		try {
			return employeeMapper.deleteByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBOperationException(e.getMessage());
		}
	}

	@Override
	public int insert(Employee record) {

		try {
			return employeeMapper.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBOperationException(e.getMessage());
		}
	}

	@Override
	public int insertSelective(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> selectByExample(EmployeeExample example) {

		try {
			return employeeMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBOperationException(e.getMessage());
		}
	}

	@Override
	public int updateByExampleSelective(Employee record, EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Employee record, EmployeeExample example) {

		try {
			return employeeMapper.updateByExample(record, example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBOperationException(e.getMessage());
		}
	}

}
