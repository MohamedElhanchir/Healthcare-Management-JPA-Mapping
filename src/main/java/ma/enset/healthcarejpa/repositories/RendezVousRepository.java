package ma.enset.healthcarejpa.repositories;

import ma.enset.healthcarejpa.entities.Medecin;
import ma.enset.healthcarejpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
