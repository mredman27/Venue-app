package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class JDBCEmployeeDAOIntegrationtest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void changeEmployeeDepartmentTest() {
		
	}
	
	private static SingleConnectionDataSource dataSource;
    private JDBCEmployeeDAO dao;
	
	@BeforeClass
    public static void setupDataSource() {
    	
    	dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
    	dataSource.setAutoCommit(false);     // prevent accidental saves or updates to the db
 
    }
    @Before
    public void setUp() {
    	
    	// create a new instance of our dao so we can test it later
    	dao = new JDBCEmployeeDAO(dataSource);

    }
    
    @After
    public void rollback() throws SQLException {
    	dataSource.getConnection().rollback();
    
    }
    
    @AfterClass
    public static void closeDataSource() {
    	dataSource.destroy();
    }
    
    
    private Employee getEmployee(String firstName, String lastName, long departmentId, LocalDate birthday, LocalDate hireDate, char gender) {
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setDepartmentId(departmentId);
		e.setBirthDay(birthday);
		e.setHireDate(hireDate);
		e.setGender(gender);
		return e;
	}
    
    private void assertEmployeesAreEqual(Employee e1, Employee e2) {
		Assert.assertEquals(e1.getFirstName(), e2.getFirstName());
		Assert.assertEquals(e1.getLastName(), e2.getLastName());
		Assert.assertEquals(e1.getDepartmentId(), e2.getDepartmentId());
		Assert.assertEquals(e1.getGender(), e2.getGender());
		
	}

}
