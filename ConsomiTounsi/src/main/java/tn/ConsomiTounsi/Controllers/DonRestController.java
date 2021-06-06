package tn.ConsomiTounsi.Controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Don;
import tn.ConsomiTounsi.Entities.Rating;
import tn.ConsomiTounsi.Services.DonServiceImpl;


@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/Don")
public class DonRestController {
	
	@Autowired
	DonServiceImpl PS ;
	
	

	@PostMapping("/addpub")
	@ResponseBody
	public Don addPubli(@RequestBody Don p) {

		Don pp = PS.addDon(p);
	return pp;
	}
	
	@PostMapping("/save")
	public Don save(@RequestBody Don Publi)
	{
		PS.updateDon(Publi);
		return Publi;
	}
	
	@GetMapping("/list")
	public List<Don>listPublication(){
		return PS.getAllPub();
	} 
	
/*	@PostMapping("/ajouterpub")
	@ResponseBody
	public int ajouterentreprise(@RequestBody Don p){
	PS.addDon(p);
	return p.getId();
	} */


}
