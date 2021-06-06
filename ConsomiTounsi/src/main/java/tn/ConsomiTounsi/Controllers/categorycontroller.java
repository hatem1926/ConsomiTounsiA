package tn.ConsomiTounsi.Controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Category;
import tn.ConsomiTounsi.Services.servicecategory;




@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/category")
public class categorycontroller {
	@Autowired
	servicecategory ser;
	@PostMapping("/save")
	public Category save(@RequestBody Category category)
	{
		ser.saveOrUpdate(category);
			return category;
	 }
	
	@GetMapping("/list")
	public List<Category> listproduct(){
			
		
			
			return ser.getAllcategory();
		}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteproduct(@PathVariable(value = "id")int id){
		
		ser.deletecategory(id);
		return "Deleted succesfully id= "+id;
	}
	
	@PutMapping("/update/{id}")
	public Category updatecategory(@PathVariable (value = "id")int id,@RequestBody Category category)
	{
		
		return ser.updatecategory(id, category);
	}
}
