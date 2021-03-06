package ma.myproject.JPASpringBoot.controllers;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;


import ma.myproject.JPASpringBoot.entities.Patient;
import ma.myproject.JPASpringBoot.repositories.PatientRepository;

@Controller
public class PatientController {
	
	@Autowired
	private PatientRepository patientrepository;
	
	
	@GetMapping(path="/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping(path = "/patients")
	public String listPatient(Model model,
			@RequestParam(name = "page", defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "5")int size,
			@RequestParam(name = "keyword", defaultValue = "")String mc)
	{
		Page<Patient> pagePatient = patientrepository.findByNameContainsIgnoreCase(mc, PageRequest.of(page, size));
		model.addAttribute("listePatients",pagePatient.getContent());
		model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keywordModel", mc);
		model.addAttribute("sizeModel", size);
		return "patients";
	}
	
	/*
	//Deuxieme Facon De Faire Fowerd
		@GetMapping("/supprimerPatient2")
		public String supprimerPatient2(Long id,String keyword,int page,int size,Model model)
		{
			patientrepository.deleteById(id);
			return listPatient(model, page, size, keyword);
		}
	*/
	
	//Premiere Facon De Faire Est La Meilleure
	@GetMapping(path="/supprimerPatient")
	public String supprimerPatient(Long id,String keyword,int page,int size)
	{
		patientrepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}
		
	
	@GetMapping(path="/formPatient")
	public String formPatient(Model model)
	{
		model.addAttribute("patient", new Patient());
		return "formPatient";
	}
	
	@PostMapping(path="/ajouterPatient")
	public String ajouterPatient(Model model, @Valid Patient patient, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) 
			return "formPatient";
		
		patientrepository.save(patient);
		model.addAttribute("patient", patient);
			return "pageConfirmationAjout";
	}
	
	@GetMapping(path="/modifierPatient")
	public String modifierPatient(Model model, Long id)
	{
		Patient p = patientrepository.findById(id).get();
		model.addAttribute("patient", p);
		return "formPatient";
	}
	
	@GetMapping(path="/nonAuthoriser")
	public String nonAuthoriser()
	{
		return "nonAuthoriser";
	}
}
