package tn.ConsomiTounsi.Controllers;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
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
import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Services.CommentaireService;
import tn.ConsomiTounsi.Services.CommentaireServiceImpl;



@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/Commentaire")
public class CommentaireRestController {
	
	@Autowired
	CommentaireService PS ;
	
	@PostMapping("/ajouter")
	@ResponseBody
	public Commentaire save(@RequestBody @ModelAttribute("Commentaire") Commentaire Publicity)
	{
		PS.saveOrUpdate(Publicity);
		return Publicity;
	}
	
	@GetMapping("/list")
	public List<Commentaire> listPublicity(){
		return PS.getAllPublicity();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePublicity(@PathVariable  (value="id")int id) {
		PS.deletePublicity(id);
		return "deleted succesfully id = "+id;
	}
	
	@PutMapping("/update/{id}")
	
	public Commentaire updatePublicity(@PathVariable @RequestParam(value="id",required=true) Integer id, 
			 @ModelAttribute("Commentaire")	Commentaire Publicity) {
		return PS.updatePublicity(id, Publicity);
	}
	
	@PutMapping("/upddate/{id}")
	public void updatePublicity1(@PathVariable (value="id",required=true) Integer id,
	//		@RequestParam (value="iduser",required=true) Long idUser,
			@ModelAttribute("idpub") Integer idPub
			) {
		 PS.updatePublicity1(id,idPub);
	}
	@Autowired
	CommentaireService Cs ;
	
	@PutMapping("/afficher/{id}")
  List<Commentaire> listPublicity11(@ModelAttribute("idpub") Integer idpub){
		List<Commentaire> com = new ArrayList<>();
		com= Cs.getCommentaireOfPub(idpub);
	//	String s = PS.getCommentaireOfPub(idpub);
	//	return ResponseEntity.ok().body(com);
		return PS.getCommentaireOfPub(idpub);
	}
	
	@GetMapping("/affichercomment/{id}")
	public List<Commentaire> listPublicityy(@PathVariable(value = "id")Integer id){
		List<Commentaire>coms=new ArrayList<>();
		coms=PS.getCommentaireOfPub(id);
		return coms ;
	}
	
	

}
	

