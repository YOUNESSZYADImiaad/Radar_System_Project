package ma.miaad.radarservice;

import ma.miaad.radarservice.entites.Radar;
import ma.miaad.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadarServiceApplication.class, args);
    }

    Random random = new Random();
    @Bean
    CommandLineRunner start(RadarRepository radarRepository) {
        return args -> {
            Stream.of("Radar-N1", "Radar-X2", "Radar-M3", "Radar-Q4", "Radar-N5", "Radar-X6","Radar-M7", "Radar-Q8").forEach(i -> {
                Radar radar = Radar.builder()
                        .name(i)
                        .status(true)
                        .maxSpeed(120)
                        .latitude(random.nextDouble(10))
                        .longitude(random.nextDouble(10))
                        .build();
                radarRepository.save(radar);
            });
        };
    }
}
