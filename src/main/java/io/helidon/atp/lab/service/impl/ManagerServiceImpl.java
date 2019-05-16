package io.helidon.atp.lab.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.helidon.atp.lab.entity.Manager;
import io.helidon.atp.lab.entity.ManagerExample;
import io.helidon.atp.lab.mapper.ManagerMapper;
import io.helidon.atp.lab.service.ManagerService;

@RequestScoped
public class ManagerServiceImpl implements ManagerService {

	@Inject
	ManagerMapper managerMapper;

	@Override
	public long countByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Manager record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Manager record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Manager> selectByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Manager record, ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Manager record, ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

}
