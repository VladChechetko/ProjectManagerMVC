package ru.school.mvc.taskmvc.client;

import java.util.Date;

import org.junit.Test;

import ru.school.mvc.taskmvc.entity.Project;

public class ProjectFeignClientTest {

	@Test
	public void testGet() {
		System.out.println(ProjectFeignClient.client("http://localhost:8080/taskmvc/rest").get());
	}

	@Test
	public void testList() {
		System.out.println(ProjectFeignClient.client("http://localhost:8080/taskmvc/rest").list());
	}
	
	@Test
	public void testPost() {
		Project p = new Project();
		p.setName("Project from FeignClient");
		p.setDateBegin(new Date());
		p.setDateEnd(new Date());
		p.setDescription("Project from FeignClient description");
		System.out.println(ProjectFeignClient.client("http://localhost:8080/taskmvc/rest").post(p));
	}
	
	@Test
	public void testDelete() {
		ProjectFeignClient.client("http://localhost:8080/taskmvc/rest").delete();
	}

}
