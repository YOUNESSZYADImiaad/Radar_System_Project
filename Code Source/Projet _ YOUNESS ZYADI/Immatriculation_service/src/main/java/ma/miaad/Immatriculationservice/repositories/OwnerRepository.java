package ma.miaad.Immatriculationservice.repositories;

import ma.miaad.Immatriculationservice.entites.Owner;
import ma.miaad.Immatriculationservice.entites.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
