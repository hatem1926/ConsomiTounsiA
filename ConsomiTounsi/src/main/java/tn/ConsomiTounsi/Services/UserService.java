package tn.ConsomiTounsi.Services;



import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Repositories.PasswordTokenRep;
import tn.ConsomiTounsi.Repositories.UserRep;
import tn.ConsomiTounsi.Entities.PasswordResetToken;
import tn.ConsomiTounsi.Entities.User;


@Service
@Transactional
public class UserService implements IUserService,UserDetailsService,IPasswordTokenService {
	
	private final UserRep userRepository;
	
	@Autowired
	UserRep uu ;
	
	@Autowired
	private  PasswordTokenRep passwordTokenRepository;
	
	@Autowired
    public UserService(UserRep userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public User addUser(User user) {
		Long res = userRepository.findid() ;
		System.out.println("res : "+res);
		res = res + 1;
		userRepository.addrole(res,2);
		return userRepository.save(user);

	}

	@Override
	public Optional<User> ShowUserByid(Long idUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(idUser);
	}

	@Override
	public List<User> affiche() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll() ;
	}



	@Override
	public void DeleteUser(Long idUser) {
		// TODO Auto-generated method stub
		userRepository.deleteById(idUser);
	}

	@Override
	public void UpdateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User userr = userRepository.findById(id).get();
				
		userr.setusername(user.getUsername());
		userr.setAdresseUser(user.getAdresseUser());
		userr.setEmaiUser(user.getEmaiUser());
		userr.setPhoneUser(user.getPhoneUser());
		userr.setActiveUser(user.getActiveUser());
		userr.setpassword(user.getPassword());
		
		userRepository.save(userr);
		
	}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

		
		public User findUserByEmail(String email) {
			// TODO Auto-generated method stub
			return userRepository.findByemaiUser(email);
		}

		@Override
		public PasswordResetToken create(PasswordResetToken PasswordResetToken) {
			// TODO Auto-generated method stub
			return passwordTokenRepository.save(PasswordResetToken);
		}
		
		public String validatePasswordResetToken(String token) {
		    final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

		    return !isTokenFound(passToken) ? "invalidToken"
		            : isTokenExpired(passToken) ? "expired"
		            : null;
		}

		private boolean isTokenFound(PasswordResetToken passToken) {
		    return passToken != null;
		}

		private boolean isTokenExpired(PasswordResetToken passToken) {
		    final Calendar cal = Calendar.getInstance();
		    return passToken.getExpiryDate().before(cal.getTime());
		}

		



}
