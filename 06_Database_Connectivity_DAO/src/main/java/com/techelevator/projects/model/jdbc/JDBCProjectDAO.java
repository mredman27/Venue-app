package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> projectList = new ArrayList<>();
		String sql = "SELECT * FROM project " + 
				"WHERE to_date IS NULL AND NOW() > from_date OR NOW() BETWEEN from_date AND to_date;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Project p = mapRowToProject(results);
			projectList.add(p);
		}
		return projectList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee(project_id, employee_id) " +
					"VALUES(?,?)";
		jdbcTemplate.update(sql,projectId,employeeId);
	}
	private Project mapRowToProject(SqlRowSet results) {
		Project p = new Project();
		p.setId(results.getLong("project_id"));
		p.setName(results.getString("name"));
		p.setStartDate(results.getDate("from_date").toLocalDate());
		if (results.getDate("to_date") == null) {
			p.setEndDate(null);
		} else {
			p.setEndDate(results.getDate("to_date").toLocalDate());
		}
		return p;
	}
}
