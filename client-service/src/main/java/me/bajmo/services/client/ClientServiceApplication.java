package me.bajmo.services.client;

import me.bajmo.services.client.entities.Client;
import me.bajmo.services.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeMySQLDatabase(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client(Long.parseLong("1"),"Imad", "Maailil", Float.parseFloat("22")));
			clientRepository.save(new Client(Long.parseLong("2"),"Anas", "Mourad", Float.parseFloat("22")));
			clientRepository.save(new Client(Long.parseLong("3"),"Hamza", "Lghali", Float.parseFloat("23")));

		};
	}
}