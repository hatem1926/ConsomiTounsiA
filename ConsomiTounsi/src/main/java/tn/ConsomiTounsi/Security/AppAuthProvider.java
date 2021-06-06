package tn.ConsomiTounsi.Security;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import tn.ConsomiTounsi.Repositories.UserRep;
import tn.ConsomiTounsi.Services.UserService;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UserService userDetailsService;
    
    @Autowired
    HttpSession session;
    
    @Autowired
    UserRep userep;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();

        Long id = userep.findSesson(name);
        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (user == null) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }

        createsession(id);
        Long named=(Long)session.getAttribute("name");  
        
        System.out.print("Hello, "+named+" Welcome to Profile");  
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
    
    public void createsession(Long name){
    	session.setAttribute("name",name);
    	
    }
   
	   //if (!session.isNew()) {
	   //     session.invalidate();
	  //  }
}
