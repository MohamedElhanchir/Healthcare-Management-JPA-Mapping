package ma.enset.healthcarejpa.repositories;

import ma.enset.healthcarejpa.entities.Consultation;
import ma.enset.healthcarejpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNomContains(String nom);
}
