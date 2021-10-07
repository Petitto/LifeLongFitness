package com.lifelongfitness.LifeLongFitness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@SpringBootApplication
public class LifeLongFitnessApplication {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(LifeLongFitnessApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunnerFunction(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO public.UsersTable(first_name, last_name, email_address, user_gender, user_weight, user_password) " +
//				"VALUES (Jose, Altuve, " +
//				"jose.altuve@astro.com, " +
//				"male, 170.80, password);";
//
//		int rows = jdbcTemplate.update(sql);
//		if (rows > 0) {
//			System.out.println("A new row has been inserted.");
//		}
//	}
}
