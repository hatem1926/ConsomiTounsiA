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
import tn.ConsomiTounsi.Entities.Likes;
import tn.ConsomiTounsi.Entities.Rating;
import tn.ConsomiTounsi.Services.LikesServiceImpl;

@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/Likes")
public class LikesRestController {
	
	@Autowired
	LikesServiceImpl PS ;
	
	@PostMapping("/ajouter")
	@ResponseBody
	public Likes save(@RequestBody @ModelAttribute("NbrLikes") Likes Publicity)
	{
		PS.saveOrUpdate(Publicity);
		return Publicity;
	}
	
	@GetMapping("/list")
	public List<Likes> listPublicity(){
		return PS.getAllPublicity();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePublicity(@PathVariable  (value="id")int id) {
		PS.deletePublicity(id);
		return "deleted succesfully id = "+id;
	}
	
	@PutMapping("/update/{id}")
	
	public Likes updatePublicity(@PathVariable @RequestParam(value="id",required=true) Integer id, 
			 @ModelAttribute("NbrLikes") Likes Publicity) {
		return PS.updatePublicity(id, Publicity);
	}
	
	
	
	
}
