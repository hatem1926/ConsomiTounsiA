package tn.ConsomiTounsi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Services.PublicityService;





@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value="/publicity")

public class PublicityController {

	@Autowired
	PublicityService pus;
	
	@PostMapping("/save")
	public Publicity save(@RequestBody Publicity Publicity)
	{
		pus.saveOrUpdate(Publicity);
		return Publicity;
	}
	
	@GetMapping("/list")
	public List<Publicity> listPublicity(){
		return pus.getAllPublicity();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePublicity(@PathVariable (value="id")int id) {
		pus.deletePublicity(id);
		return "deleted succesfully id = "+id;
	}
	
	@PutMapping("/update/{id}")
	public Publicity updatePublicity(@PathVariable (value="id")int id, @RequestBody Publicity Publicity) {
		return pus.updatePublicity(id, Publicity);
	}
}
