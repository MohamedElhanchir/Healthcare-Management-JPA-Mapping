package ma.enset.healthcarejpa.repositories;

import ma.enset.healthcarejpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNomContains(String nom);
}
