package com.cbnits.springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	/*
	@Configuration -> Do configuring all files. creating beans
	@Component -> Treat any class which allow you to treat as a bean
	@Service -> Treat any class which allow you to treat as a bean
	@RestController -> Rest api developement
	@Controller -> Web projectd
	@Repository -> For Dao classes. for database comminucation

	Three layers
	1. Controller/RestController class -> for take input from user or for user intraction
	2. Service class -> deal with the business logic
	3. Repository class -> only communicating with database.
	 */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
