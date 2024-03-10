package ma.enset.healthcarejpa.web;

import ma.enset.healthcarejpa.entities.Patient;
import ma.enset.healthcarejpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientRepository.findAll();
    }
}
