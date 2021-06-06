package tn.ConsomiTounsi.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable , UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private Long idUser;
	@Column(name = "username")
	@NotEmpty(message = "*Please provide a username")
	private String username;
	@NotEmpty(message = "*Please provide a Passowrd")
	@Column(name = "password")
	private String password;
	@Column(name = "emailuser")
	@NotEmpty(message = "*Please provide an email")
	@Email
	private String emaiUser;
	@Column(name = "adresseuser")
	@NotEmpty(message = "*Please provide your home adresse")
	private String adresseUser;
	@Column(name = "phoneuser")
	@NotNull(message = "Please enter id")
	private Long phoneUser;
	@Column(name = "activeuser")
	private int activeUser;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();
	

	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="User")
	private List<Product> product; 
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="User")
	private List<Post> post; */
	
	public User() {
		super();
	}
	
	public User(Long idUser, @NotEmpty(message = "*Please provide a username") String username,
			@NotEmpty(message = "*Please provide a Passowrd") String password,
			@NotEmpty(message = "*Please provide an email") @Email String emaiUser,
			@NotEmpty(message = "*Please provide your home adresse") String adresseUser,
			@NotNull(message = "Please enter id") Long phoneUser,
			int activeUser, Set<Role> roles) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.emaiUser = emaiUser;
		this.adresseUser = adresseUser;
		this.phoneUser = phoneUser;
		this.activeUser = activeUser;
		this.roles = roles;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getEmaiUser() {
		return emaiUser;
	}

	public void setEmaiUser(String emaiUser) {
		this.emaiUser = emaiUser;
	}

	public String getAdresseUser() {
		return adresseUser;
	}

	public void setAdresseUser(String adresseUser) {
		this.adresseUser = adresseUser;
	}

	public Long getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(Long phoneUser) {
		this.phoneUser = phoneUser;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
        Set<Role> roles = getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
         
        return authorities;
	}
	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



/*	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}*/
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
//	private Set<Commentaire> commentaires  ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Evenement> events  ;

	
	
	
	
	
	
}

