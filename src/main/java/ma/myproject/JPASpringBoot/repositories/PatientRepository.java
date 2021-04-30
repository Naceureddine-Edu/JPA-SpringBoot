package ma.myproject.JPASpringBoot.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.myproject.JPASpringBoot.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {

<<<<<<< HEAD
	public List<Patient> findByNameAndScore(String name, int score);
=======
>>>>>>> main
	public List<Patient> findByScoreGreaterThan(int score);
	
	//public List<Patient> findByNameContainsIgnoreCase(String name);
	
	public Page<Patient> findByNameContainsIgnoreCase(String name, Pageable pageable);
	
	public List<Patient> findByMalade(boolean malade);
<<<<<<< HEAD
=======
	
	//public List<Patient> findbyNameEndingWith(String name);
>>>>>>> main
}
