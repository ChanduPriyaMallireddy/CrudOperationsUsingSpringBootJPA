package com.mouri.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mouri.bean.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<EmployeeBean> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<EmployeeBean> query=currentSession.createQuery("from EmployeeBean",EmployeeBean.class);
		List<EmployeeBean>list =query.list();
		//List<EmployeeBean>list =query.getResultList();
		return list;
		
	}

	@Override
	public EmployeeBean get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		EmployeeBean empObj=currentSession.get(EmployeeBean.class,id);
		return empObj;
	}

	@Override
	public void save(EmployeeBean employeebean) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employeebean);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		EmployeeBean empObj=currentSession.get(EmployeeBean.class,id);
		currentSession.delete(empObj);;
		
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Long> query=currentSession.createQuery("select count(*) from EmployeeBean",Long.class);
		Long list = query.getSingleResult();
		return list;
	}

	@Override	
	public Long getCountDepartmentwise(String department_name) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Long> query=currentSession.createQuery("select count(*) from EmployeeBean where department_name=:deptname",Long.class).setParameter("deptname", department_name);
		Long list = query.getSingleResult();
		return list;
	}


}
