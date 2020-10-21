package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectsDAOIntegrationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addEmployeeToProject() {
		dao.addEmployeeToProject(Long.parseLong("3"),Long.parseLong("10"));
		String sql = "SELECT * FROM project_employee WHERE project_id = ? AND employee_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, 3, 10);
		while (results.next()) {
		assertEquals(results.getLong("project_id"), Long.parseLong("3"));
		
		}
		
	}

	
	private static SingleConnectionDataSource dataSource;
    private JDBCProjectDAO dao;
    private JdbcTemplate jdbc;
	
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
    	dao = new JDBCProjectDAO(dataSource);
    	jdbc = new JdbcTemplate(dataSource);
    }
    
    @After
    public void rollback() throws SQLException {
    	dataSource.getConnection().rollback();
    
    }
    
    @AfterClass
    public static void closeDataSource() {
    	dataSource.destroy();
    }
    
    
    
}
