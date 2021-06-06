package tn.ConsomiTounsi.Controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Commentaire;
import tn.ConsomiTounsi.Entities.Publication;
import tn.ConsomiTounsi.Services.PublicationServiceImpl;

@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/Publication")
public class PublicationRestController {

	@Autowired
	PublicationServiceImpl PS ;
	
	
	@PostMapping("/ajouter")
	@ResponseBody
	public Publication save(@RequestBody @ModelAttribute("Description") Publication Publicity)
	{
		PS.saveOrUpdate(Publicity);
		return Publicity;
	}
	
	@GetMapping("/list")
	public List<Publication> listPublicity(){
		return PS.getAllPublicity();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePublicity(@PathVariable  (value="id")int id) {
		PS.deletePublicity(id);
		return "deleted succesfully id = "+id;
	}
	
	@PutMapping("/update/{id}")
	
	public Publication updatePublicity(@PathVariable @RequestParam(value="id",required=true) Integer id, 
			 @ModelAttribute("Description")	Publication Publicity) {
		return PS.updatePublicity(id, Publicity);
	}
	
	@GetMapping("/top5")
	public String listPublicity1(){
		return PS.getCommentaireOfPub();
	}
	
	
	@GetMapping("/top")
	public List<Publication> listPublicity11(){
		return PS.listTopPub();
	}
	
	@PutMapping("/find")
	public List<Publication> listPublicity111(@ModelAttribute("name")String name )
			 {
		return PS.findSujetByName(name);
	}
	


	
}
