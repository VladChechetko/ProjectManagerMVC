package ru.school.mvc.taskmvc.client;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import feign.Feign;
import ru.school.mvc.taskmvc.entity.Project;

@FeignClient("project")
public interface ProjectFeignClient {

	public static ProjectFeignClient client(final String baseUrl) {
		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		HttpMessageConverters converters = new HttpMessageConverters(converter);
		ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;

		ProjectFeignClient feignClient = Feign.builder()
				.contract(new SpringMvcContract())
				.encoder(new SpringEncoder(objectFactory))
				.decoder(new SpringDecoder(objectFactory))
				.target(ProjectFeignClient.class, baseUrl);
		
		return feignClient;
	}

	@GetMapping("/projects")
	public String list();
	
	@GetMapping("/projects/11")
	public String get();
	
	@PostMapping("/projects")
	public Project post(Project project);
	
	@DeleteMapping("/projects/10")
	public void delete();

}
