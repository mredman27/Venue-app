package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOIntegrationTest {
	
    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO dao;
	
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
    	dao = new JDBCDepartmentDAO(dataSource);

    }
    
    @After
    public void rollback() throws SQLException {
    	dataSource.getConnection().rollback();
    
    }
    
    @AfterClass
    public static void closeDataSource() {
    	dataSource.destroy();
    }

//    @Test 
//    public void getDepartmentByID() {
//    	Department savedDepartment = getDepartment("Test Department");
//    	dao.createDepartment(savedDepartment);
//    	
//    	Department givenDepartment = dao.getDepartmentById(savedDepartment.getId());
//    	assertDepartmentsAreEqual(savedDepartment, givenDepartment);
//    }
	@Test
	public void saveNewDepartmentAndReadItBack() throws SQLException {
		Department savedDepartment = getDepartment("Department");
		savedDepartment = dao.createDepartment(savedDepartment); // This is the method we are testing
	
		Department givenDepartment = dao.getDepartmentById(savedDepartment.getId());
		assertNotEquals(savedDepartment.getId(), null);
		assertDepartmentsAreEqual(savedDepartment, givenDepartment);
	}
	
	private Department getDepartment(String name) {
		Department d = new Department();
		d.setName(name);
		return d;
	}
	
	private void assertDepartmentsAreEqual(Department d1, Department d2) {
		Assert.assertEquals(d1.getName(), d2.getName());
		Assert.assertEquals(d1.getId(), d2.getId());
	}
}
