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
			@RequestParam(name = "size", defaultValue = "7")int size,
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
	
	//Premiere Facon De Faire Est La Meilleure
	@GetMapping("/supprimerPatient")
	public String supprimerPatient(Long id,String keyword,int page,int size)
	{
		patientrepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}
	
	/*
	//Deuxieme Facon De Faire
		@GetMapping("/supprimerPatient2")
		public String supprimerPatient2(Long id,String keyword,int page,int size,Model model)
		{
			patientrepository.deleteById(id);
			return listPatient(model, page, size, keyword);
		}
	*/
	
	
}
