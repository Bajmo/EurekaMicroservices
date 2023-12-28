package me.bajmo.services.car.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.bajmo.services.car.entities.Client;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    Long id;
    String brand;
    String model;
    String plate;
    Client client;
}
