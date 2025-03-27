package com.example.pac_architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.pac_architecture.LandingPAC.LandingPresentator;

@SpringBootApplication
public class PacArchitectureApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PacArchitectureApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(PacArchitectureApplication.class, args);
		LandingPresentator pres = new LandingPresentator();

        pres.showLoginUser();
	}

}
