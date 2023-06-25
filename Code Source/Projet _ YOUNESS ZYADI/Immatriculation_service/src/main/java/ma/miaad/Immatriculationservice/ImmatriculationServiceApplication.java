package ma.miaad.Immatriculationservice;

import ma.miaad.Immatriculationservice.entites.Owner;
import ma.miaad.Immatriculationservice.entites.Vehicle;
import ma.miaad.Immatriculationservice.repositories.OwnerRepository;
import ma.miaad.Immatriculationservice.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class ImmatriculationServiceApplication {

    Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationServiceApplication.class, args);
    }
    // Helper method to generate the registration number
    private String generateRegistrationNumber() {
        String randomNumbers1 = String.format("%05d", random.nextInt(100000)); // Random 5-digit number
        String randomNumbers2 = String.format("%02d", random.nextInt(100)); // Random 2-digit number

        return randomNumbers1 + "- ج -" + randomNumbers2;
    }
    // Add data to H2 database in start of application
    @Bean
    CommandLineRunner start(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {

        return args -> {
            Stream.of("Khalid Al Bakkali", "Omar Ben Hamidi", "Youssef El Haddadi",
                    "Karim Laaroussi", "Jamal El Fakiri","John Smith", "Emma Johnson", "Michael Brown",
                    "Sophia Davis", "William Miller").forEach(o -> {

                        String em = o.replaceAll(" ","");
                Owner owner = Owner.builder()
                        .name(o)
                        .email(em+ "@edu.umi.ac.ma.com")
                        .birthDate(new Date())
                        .build();
                ownerRepository.save(owner);
            });

            List<String> carBrands = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "BMW");
            List<String> carModels = Arrays.asList("Camry", "Civic", "Mustang", "Silverado", "3 Series");

            ownerRepository.findAll().forEach(owner -> {
                for (int i = 0; i < 3; i++) {
                    String randomBrand = carBrands.get(random.nextInt(carBrands.size()));
                    String randomModel = carModels.get(random.nextInt(carModels.size()));
                    String registrationNumber = generateRegistrationNumber();
                    Vehicle vehicle = Vehicle.builder()
                            .regestrationNumber(registrationNumber)
                            .fiscalPower(Double.valueOf(random.nextInt(1000)))
                            .brand(randomBrand)
                            .model(randomModel)
                            .owner(owner)
                            .build();
                    vehicleRepository.save(vehicle);
                }
            });


        };
    }
}
