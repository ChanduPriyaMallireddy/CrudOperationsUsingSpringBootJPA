package com.mouri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouri.bean.EmployeeBean;
import com.mouri.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/getallemployees")
	public List<EmployeeBean> get() {
		return employeeservice.get();
	}

	@PostMapping("/saveemployees")
	public EmployeeBean save(@RequestBody EmployeeBean empObj) {
		employeeservice.save(empObj);
		return empObj;

	}

	@GetMapping("/employeecount")
	public Long getCount() {
		return employeeservice.getCount();
	}

	@PutMapping("/employeecountdeptwise/{department_name}")
	public Long getCountDepartmentwise(@PathVariable String department_name) {
		return employeeservice.getCountDepartmentwise(department_name);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		employeeservice.delete(id);
		return "Employee has been deleted with id:" + id;

	}

	@GetMapping("/getemployees/{id}")
	public EmployeeBean get(@PathVariable int id) {
		return employeeservice.get(id);

	}

	@PutMapping("/update")
	public EmployeeBean update(@RequestBody EmployeeBean empObj) {
		employeeservice.save(empObj);
		return empObj;

	}

}
