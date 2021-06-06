package tn.ConsomiTounsi.Controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Repositories.PasswordTokenRep;
import tn.ConsomiTounsi.Entities.PasswordResetToken;
import tn.ConsomiTounsi.Services.IUserService;
import tn.ConsomiTounsi.Services.UserService;
import tn.ConsomiTounsi.Repositories.UserRep;





@RestController
@EnableAutoConfiguration
@RequestMapping(value="/User")
public class UserRestController implements IUserService {

	@Autowired
	UserService userr;
	
	@Autowired
	private PasswordTokenRep PasswordResetToken;
	
	@Autowired
	private UserRep UserRep;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Override
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		//sendEmail(user.getEmaiUser(), true);
		System.out.println(user);
		System.out.println("password: "+user.getPassword());
		System.out.println("username: "+user.getUsername());
		return userr.addUser(user);
		
	}

	@Override
	@GetMapping("/showuser/{id}")
	public Optional<User> ShowUserByid(@PathVariable("id") Long idUser) {
		// TODO Auto-generated method stub
		return userr.ShowUserByid(idUser);
		
	}

	@Override
	@GetMapping("/showusers")
	public List<User> affiche() {
		// TODO Auto-generated method stub
		return userr.affiche();
	}

	
	@Override
	@DeleteMapping("/deleteuser/{id}")
	public void DeleteUser(@PathVariable("id") Long idUser) {
		// TODO Auto-generated method stub
		userr.DeleteUser(idUser);
	}

	@Override
	@PutMapping("/updateuser/{id}")
	public void UpdateUser(@PathVariable("id") Long id,@RequestBody User user) {
		// TODO Auto-generated method stub
		System.out.println("id: "+id);
		System.out.println("password: "+user.getPassword());
		System.out.println("emaiil: "+user.getEmaiUser());
		userr.UpdateUser(id, user);
	}

	
	  void sendEmail(String email, boolean state) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(email);
	        if(state == true)
	        {
	        msg.setSubject("Account Has Been Activated");
	        msg.setText("Hello, Your account has been activated. "
	        		+ 
	        		"You can log in : http://127.0.0.1:81/login"
	        		+ " \n Best Regards!");
	        }
	        else
	        {
	        	msg.setSubject("Account Has Been disactivated");
	            msg.setText("Hello, Your account has been disactivated.");
	        }
	        javaMailSender.send(msg);

	    }

	  @PostMapping("/resetPassword/{email}")
	  public void resetPassword(@PathVariable("email") String userEmail) {
		  User user = userr.findUserByEmail(userEmail);
	      if (user != null) {
	            // Create token    	  
	    	  PasswordResetToken confirmationToken = new PasswordResetToken(user);

	            // Save it
	    	  PasswordResetToken.save(confirmationToken);

	            // Create the email
	          SimpleMailMessage mailMessage = new SimpleMailMessage();
	            mailMessage.setTo(user.getEmaiUser());
	            mailMessage.setSubject("Complete Password Reset!");
	            mailMessage.setFrom("oussema.jelassi1@esprit.tn");
	            mailMessage.setText("To complete the password reset process, please click here: "
	                    + "http://localhost:8081/confirm-reset?token="+confirmationToken.getToken());

	            // Send the email
	            javaMailSender.send(mailMessage);
	        }
	      else {
	        System.out.println("This email address does not exist!"); 
	            }
	  }
	  
	  @RequestMapping(value="/confirm-reset", method= {RequestMethod.GET, RequestMethod.POST})
	    public void validateResetToken(@RequestParam("token")String confirmationToken) {
		  PasswordResetToken token = PasswordResetToken.findByToken(confirmationToken);
		  String result = userr.validatePasswordResetToken(confirmationToken);
	        if (result != null) {
	        	
	        	System.out.println("The link is invalid or broken!"); ;
	           // modelAndView.addObject("user", user);
	           // modelAndView.addObject("emailId", user.getEmailId());
	           // modelAndView.setViewName("resetPassword");
	        } else {
	            System.out.println("The link is invalid or broken!"); 
	            User user = UserRep.findByemaiUser(token.getUser().getEmaiUser());
	            System.out.println("The link is valid !");
	        }
	    }
	  
	  @RequestMapping(value = "/reset-password/{email}/{password}", method = RequestMethod.POST)
	    public void resetUserPassword(@PathVariable("email") String email,@PathVariable("password") String password) {
	        if (email != null) {
	            // Use email to find user
	            User tokenUser = UserRep.findByemaiUser(email);
	            tokenUser.setpassword(password);
	            UserRep.save(tokenUser);
	        //    modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
	          //  modelAndView.setViewName("successResetPassword");
	            System.out.println("successResetPassword!");
	        } else {
	         //   modelAndView.addObject("message","The link is invalid or broken!");
	        	System.out.println("The link is invalid or broken!");
	        }
	    
	    }


	  
}
