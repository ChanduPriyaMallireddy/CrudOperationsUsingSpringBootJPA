package com.mouri.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouri.bean.EmployeeBean;


public interface EmployeeDAO {
	
	List<EmployeeBean> get();
	
	EmployeeBean get (int id);
	void save(EmployeeBean employeebean);
	void delete(int id);
	Long getCount();
	Long getCountDepartmentwise(String department_name);
	
	

}
