package ma.miaad.Immatriculationservice.repositories;

import ma.miaad.Immatriculationservice.entites.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // get vehicle by regestration number
    Vehicle findVehicleByRegestrationNumber(String rn);

    // get vehicle by regestration number
    Page<Vehicle> findByRegestrationNumberContaining(String keyword, Pageable pageable);
}
