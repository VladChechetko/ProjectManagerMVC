package ru.school.mvc.taskmvc.client;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ru.school.mvc.taskmvc.entity.Project;

public class ProjectRestClientTest {
	
	private ProjectRestClient restClient;
	
	@Before
	public void init() {
		restClient = new ProjectRestClient();
	}

	@Test
	public void testGetProject() {
		restClient.getProject();
	}

	@Test
	public void testGetProjectList() {
		restClient.getProjectList();
	}
	
	@Test
	public void testPostProject() {
		Project p = new Project();
		p.setName("Project from RestClient");
		p.setDateBegin(new Date());
		p.setDateEnd(new Date());
		p.setDescription("Project from RestClient description");
		
		restClient.postProject(p);
	}

	@Test
	public void testDeleteProject() {
		restClient.deleteProject("10");
	}

}
