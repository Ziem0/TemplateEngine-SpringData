package com.engine.templateengine;

import com.engine.templateengine.liveScore.Match;
import com.engine.templateengine.liveScore.MatchRepo;
import com.engine.templateengine.liveScore.Team;
import com.engine.templateengine.liveScore.TeamRepo;
import com.engine.templateengine.liveScore.controller.AppController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class TemplateEngineApplication {

	@Autowired
	private AppController controller;

	public static void main(String[] args) {
		SpringApplication.run(TemplateEngineApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(TeamRepo teamRepo, MatchRepo matchRepo) {
		return (args) -> {
			log.warn("Save new teams");
			Team team1 = teamRepo.save(new Team("Juventus", "Italy", "Turin"));
			Team team2 = teamRepo.save(new Team("AC Milan", "Italy", "Milan"));
			Team team3 = teamRepo.save(new Team("FC Barcelona", "Catalonia", "Barcelona"));
			Team team4 = teamRepo.save(new Team("Real", "Spain", "Madrid"));
			teamRepo.findAll().forEach(team -> log.warn(team.toString()));
			log.warn("=============");
			log.warn("Save new matches");
			matchRepo.save(new Match(team1, team2, 3,2));
			matchRepo.save(new Match(team3, team4, 4, 0));
			matchRepo.save(new Match(team1, team3, 2, 2));
			matchRepo.save(new Match(team1, team4, 2, 1));
			matchRepo.save(new Match(team2, team3, 2, 5));
			matchRepo.findAll().forEach(match -> log.warn(match.toString()));
			log.warn("=============");

		};
	}



//	@Bean
//	public CommandLineRunner demo(CustomerRepo repository) {
//		return (args) -> {
////			create a couple of customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
////			fetch all customers
//			log.warn("Customers found by method findAll()");
//			log.warn("-----------");
//			for (Customer customer : repository.findAll()) {
//				log.warn(customer.toString());
//			}
//			log.warn("That is all");
//
////			fetch an individual customer by ID
//			repository.findById(1L)
//					.ifPresent(customer -> {
//						log.warn("Customer found by method findById()");
//						log.warn(customer.toString());
//						log.warn("that is all");
//					});
//
////			fetch customers by last name
//			log.warn("Customers found by last name");
//			repository.findByLastName("Bauer").forEach(customer -> log.warn(customer.toString()));
//		};
//
//	}





//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}

}






