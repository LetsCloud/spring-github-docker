package com.example.sgd;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringGithubDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGithubDockerApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Java Spring Boot application is up and running";
	}
	
	@GetMapping("/info")
	public AppInfo status() {
		// obtain a hostname. First try to get the host name from docker container (from the "HOSTNAME" environment variable)
		String hostName = System.getenv("HOSTNAME");

		// get the os name
		String os = System.getProperty("os.name");

		// if the application is not running in a docker container, we can to obtain the hostname using the "java.net.InetAddress" class
		if(hostName == null || hostName.isEmpty()) {
			try {
				InetAddress addr = InetAddress.getLocalHost();
				hostName = addr.getHostName();
			} catch (Exception e) {
				System.err.println(e);
				hostName = "Unknow";
			}
		}
		return new AppInfo("Sample Java Spring Boot app", hostName, os);
	}
}
