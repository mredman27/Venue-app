package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while (results.next()) {
			Employee myemployee = mapRowToEmployee(results);
			employeeList.add(myemployee);
		}
		
		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE first_name = ? AND last_name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);
		
		while (results.next()) {
			Employee myemployee = mapRowToEmployee(results);
			employeeList.add(myemployee);
		}
		
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		
		while (results.next()) {
			Employee myEmployee = mapRowToEmployee(results);
			employeeList.add(myEmployee);
		}
		
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE employee_id NOT IN (SELECT employee_id FROM project_employee)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while (results.next()) {
			Employee myEmployee = mapRowToEmployee(results);
			employeeList.add(myEmployee);
		}
		
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee JOIN project_employee "
				+ "ON project_employee.employee_id = employee.employee_id" 
				+ "WHERE project_employee.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,projectId);
		
		while (results.next()) {
			Employee myEmployee = mapRowToEmployee(results);
			employeeList.add(myEmployee);
		}
		
		return employeeList;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sql = "UPDATE employee SET department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(sql, departmentId, employeeId);
	}
	
	private Employee mapRowToEmployee (SqlRowSet results) {
		Employee theEmployee = new Employee();
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		theEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
		theEmployee.setGender(results.getString("gender").charAt(0));
		theEmployee.setHireDate(results.getDate("hire_date").toLocalDate());
		
		return theEmployee;
	}

}
