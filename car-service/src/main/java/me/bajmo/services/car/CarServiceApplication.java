package me.bajmo.services.car;

import me.bajmo.services.car.entities.Car;
import me.bajmo.services.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeMySQLDatabase(CarRepository carRepository){
		return args -> {
			carRepository.save(new Car(Long.parseLong("1"),"Ford", "Fiesta", "12345", Long.parseLong("1")));
			carRepository.save(new Car(Long.parseLong("2"),"Peugeot", "508 GT Allure", "12346", Long.parseLong("2")));
			carRepository.save(new Car(Long.parseLong("3"),"Ford", "Fiesta", "12347", Long.parseLong("3")));

		};
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}

}
