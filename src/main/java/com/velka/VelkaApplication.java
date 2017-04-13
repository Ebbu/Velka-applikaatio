package com.velka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.velka.domain.Velka;
import com.velka.domain.VelkaRepository;
import com.velka.domain.Kayttaja;
import com.velka.domain.KayttajaRepository;




@SpringBootApplication
public class VelkaApplication {
	private static final Logger log = LoggerFactory.getLogger(VelkaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(VelkaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner velkaLista(VelkaRepository repository, KayttajaRepository urepository) {
		return (args) -> {
			log.info("Lisätään velkoja");
			repository.save(new Velka((long) 1, "100", "Dokattii"));
			repository.save(new Velka((long) 2,"200", "Maksa ruuast"));	
			
		
			log.info("Lisätään käyttäjät in-memory tietokantaan.");
			Kayttaja user1 = new Kayttaja("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Kayttaja user2 = new Kayttaja("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			  
			 
			log.info("haetaan kaikki velat");
			for (Velka value : repository.findAll()) {
				log.info(value.toString());
			}

		};
	}
	
	
	
}
