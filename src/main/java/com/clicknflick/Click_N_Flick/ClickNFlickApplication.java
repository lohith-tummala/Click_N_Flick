package com.clicknflick.Click_N_Flick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.clicknflick.Controller","com.clicknflick.Click_N_Flick"})
@EnableJpaRepositories({"com.clicknflick.Repository"})
@EntityScan({"com.clicknflick.Model"})
public class ClickNFlickApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickNFlickApplication.class, args);
	}

}
