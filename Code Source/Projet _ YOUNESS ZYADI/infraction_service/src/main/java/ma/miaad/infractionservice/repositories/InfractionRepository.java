package ma.miaad.infractionservice.repositories;

import ma.miaad.infractionservice.entites.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {
}
