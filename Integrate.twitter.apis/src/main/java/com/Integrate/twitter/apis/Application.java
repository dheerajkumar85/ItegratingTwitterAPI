package com.Integrate.twitter.apis;


import com.Integrate.twitter.apis.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(Application.class, args);
		UserService userService = new UserService();

		String bearerToken = System.getenv("BEARER_TOKEN");
		if (null != bearerToken) {
			//Replace comma separated usernames with usernames of your choice
			String response = userService.getUsers("TwitterDev,TwitterEng", bearerToken);
			System.out.println(response);
		} else {
			System.out.println("There was a problem getting you bearer token. Please make sure you set the BEARER_TOKEN environment variable");
		}
	}
}
