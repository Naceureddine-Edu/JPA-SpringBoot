package ma.myproject.JPASpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.myproject.JPASpringBoot.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	public List<Patient> findByNameAndScore(String name, int score);
}
