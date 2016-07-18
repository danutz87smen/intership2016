package com.internship.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.internship.model.Employee;

@Repository("employeeDao")
public class EmployeeDao extends AbstractDao<Employee> {

	public Employee getEntityById(Long id) {
		return getSession().get(Employee.class, id);
	}

	public void deleteEmployeeById(Long id) {
        Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }
}
