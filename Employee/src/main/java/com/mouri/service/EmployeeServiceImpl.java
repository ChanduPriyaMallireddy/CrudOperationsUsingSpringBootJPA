package com.mouri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mouri.bean.EmployeeBean;
import com.mouri.dao.EmployeeDAO;

@ Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeDAO;
	
	@Transactional
	@Override
	public List<EmployeeBean> get() {
		return employeDAO.get();
	}

	@Transactional
	@Override
	public EmployeeBean get(int id) {
		// TODO Auto-generated method stub
		return employeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(EmployeeBean employeebean) {
		employeDAO.save(employeebean);
		
	}

	
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeDAO.delete(id);
		
	}
	
	@Transactional
	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		
		return employeDAO.getCount();
	}

	@Transactional
	@Override
	public Long getCountDepartmentwise(String departnment_name) {
		// TODO Auto-generated method stub
		return employeDAO.getCountDepartmentwise(departnment_name);
	}

}
