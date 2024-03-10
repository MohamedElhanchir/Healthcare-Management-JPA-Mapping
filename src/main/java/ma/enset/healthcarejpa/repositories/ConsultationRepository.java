package ma.enset.healthcarejpa.repositories;

import ma.enset.healthcarejpa.entities.Consultation;
import ma.enset.healthcarejpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
