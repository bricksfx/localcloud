package com.brickstar.localcloud;

import java.util.Arrays;

import com.brickstar.localcloud.cusServlet.UpServlet;
import com.brickstar.localcloud.util.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.brickstar.localcloud.util.StorageService;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class  LocalcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalcloudApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet){

		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//		registration.getUrlMappings().clear();
//		registration.addUrlMappings("/bigupload");
		return registration;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new UpServlet(), "/bigupload");// ServletName默认值为首字母小写，即myServlet
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
