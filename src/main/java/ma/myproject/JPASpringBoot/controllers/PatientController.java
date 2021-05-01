package ma.myproject.JPASpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String listPatient(Model model,
			@RequestParam(name = "page", defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "7")int size )
	{
		Page<Patient> pagePatient = patientrepository.findAll(PageRequest.of(page, size));
		model.addAttribute("listePatients",pagePatient.getContent());
		model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
		model.addAttribute("currentPage", page);
		return "patients";
	}

}
