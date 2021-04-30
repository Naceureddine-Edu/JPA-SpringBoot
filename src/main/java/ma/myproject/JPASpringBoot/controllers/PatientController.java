package ma.myproject.JPASpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ma.myproject.JPASpringBoot.entities.Patient;
import ma.myproject.JPASpringBoot.repositories.PatientRepository;

@Controller
public class PatientController {
	
	@Autowired
	private PatientRepository patientrepository;
	
	
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping(path = "/patients")
	public String listPatient(Model model)
	{
		List<Patient> patient = patientrepository.findAll();
		model.addAttribute("listePatients",patient);
		return "patients";
	}

}
