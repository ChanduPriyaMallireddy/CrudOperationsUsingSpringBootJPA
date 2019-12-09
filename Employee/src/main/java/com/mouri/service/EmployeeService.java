package com.mouri.service;

import java.util.List;

import com.mouri.bean.EmployeeBean;

public interface EmployeeService {
	
List<EmployeeBean> get();
	
	EmployeeBean get (int id);
	void save(EmployeeBean employeebean);
	void delete(int id);
	Long getCount();
	Long getCountDepartmentwise(String department_name);

}
