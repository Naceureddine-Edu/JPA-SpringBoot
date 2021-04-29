package ma.myproject.JPASpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.myproject.JPASpringBoot.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
