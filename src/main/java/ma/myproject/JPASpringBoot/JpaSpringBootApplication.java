package ma.myproject.JPASpringBoot;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.myproject.JPASpringBoot.entities.Patient;
import ma.myproject.JPASpringBoot.repositories.PatientRepository;


@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringBootApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		patientRepository.save(new Patient(null,"Hassan",new Date(),2300,false));
		patientRepository.save(new Patient(null,"Hamza",new Date(),4444,true));
		patientRepository.save(new Patient(null,"Reda",new Date(),8933,false));
		patientRepository.save(new Patient(null,"Aziz",new Date(),6666,false));
		
		System.out.println("-------------------findAll---------------------(-----------------------");
		
		patientRepository.findAll().forEach(p -> { 
			System.out.println(p.toString()); 
			});
		
			System.out.println("-------------------findById----------------------------------------");
			Patient patient = patientRepository.findById(2L).get();
			System.out.println(patient.getName());
			System.out.println("-------------------findByNameContainsIgnoreCase--------------------");
			
			Page<Patient> patients = patientRepository.findByNameContainsIgnoreCase("h",PageRequest.of(0, 2));
			patients.forEach(p-> { 
				System.out.println(p.toString()); 
				});
			
			System.out.println("--------------------findByMalade-----------------------------------");
			
			List<Patient> patientsMalade = patientRepository.findByMalade(true);
			patientsMalade.forEach(p-> { 
				System.out.println(p.toString()); 
				});
			
			System.out.println("--------------------findByNameAndScore-----------------------------");
			
			List<Patient> patientsScore = patientRepository.findByScoreGreaterThan(5000);
			patientsScore.forEach(p-> { 
				System.out.println(p.toString()); 
				});
			
			System.out.println("--------------------deletteById------------------------------------");
			
			patientRepository.deleteById(3L);
			
			patientRepository.findAll().forEach(p -> { 
				System.out.println(p.toString()); 
				});
			
			System.out.println("--------------------Pagination-------------------------------------");
			
			Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0,2));
			System.out.println("Len nombre de page est : " + pagePatients.getTotalPages());
			List<Patient> listPatients = pagePatients.getContent();
			listPatients.forEach(p -> {
				System.out.println(p.toString());
			});
			
			//System.out.println("--------------------Pagination2------------------------------------");
			
			/*Page<Patient> pg = patientRepository.findbyNameEndingWith("a", PageRequest.of(0, 2));
			pg.getContent().forEach(p -> {
				System.out.println(p.toString());
			});*/
	}

}
