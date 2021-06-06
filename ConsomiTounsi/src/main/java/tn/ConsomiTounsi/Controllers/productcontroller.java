package tn.ConsomiTounsi.Controllers;


import java.util.List;


import javax.transaction.Transactional;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Product;
import tn.ConsomiTounsi.Repositories.productrepository;
import tn.ConsomiTounsi.Services.serviceproduct;








@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/product")
public class productcontroller {
	@Autowired
	serviceproduct ser;
	@Autowired
	productrepository pr;

	@PostMapping("/save")
	public Product save(@RequestBody Product product)
	{
		ser.saveOrUpdate(product);
			return product;
	 }
	/*
	@PostMapping("/save")
	@ResponseBody
	public void save(@RequestBody Product product) throws WriterException, IOException  {


		  Calendar currentDate = Calendar.getInstance();
		  Date d =currentDate.getTime();

		// for (int i = 0; i <ServiceProduct.getAllProducts().size(); i++){
		// String name= pr.getClass().getName();
		// long id=product.getUser().getIdUser();
		String nom = product.getNameproduct();
		 product.setDateProduct(d);


		ser.saveOrUpdate(product);

		//QRCodeGenerator.generateQRCodeImage(nom, QR_CODE_IMAGE_PATH + product.getIdproduct() + ".png");

	}
	
	@GetMapping("/list")
	public List<Product> listproduct(){
			
		
			
			return ser.getAllproduct();
		}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteproduct(@PathVariable(value = "id")int id){
		
		ser.deleteproduct(id);
		return "Deleted succesfully id= "+id;
	}
	
	@PutMapping("/update/{id}")
	public Product updateproduct(@PathVariable (value = "id")int id,@RequestBody Product product)
	{
		
		return ser.updateproduct(id, product);
	}
	
	@GetMapping("/recherche/{name}")
	public List<Product> recherche(@PathVariable String name)
	{	
			return (List<Product>)pr.recherche(name);
		}
	
	/*
	@PostMapping("/file")

	public Product uploddImage(@RequestParam("file") @Nullable MultipartFile file,@RequestParam("id") int id) {
		Product product = pr.findById(id).get();
		if (file == null) {
			product.setImageProduct("defaultPic.jpg");
			pr.save(product);
		} else {
			try {
				File f = new File("C:\\wamp64\\www\\ImageProducts\\" + file.getOriginalFilename());
				file.transferTo(f);
				product.setImageProduct(file.getOriginalFilename());
				pr.save(product);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return (product);
	}


	 @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        //String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        String headerValue = "attachment; filename=DisabledDM_.xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Product> list = pr.findAll();
	   
	        serviceproduct excelExporter = new serviceproduct(list);
	         
	        excelExporter.export(response);    
	    }  
  */
}
