package ma.miaad.radarsimulator.models;

import lombok.Data;

@Data
public class Vehicle {
    private Long id;
    private String regestrationNumber;
    private String brand;
    private Double fiscalPower;
    private String model;

}
