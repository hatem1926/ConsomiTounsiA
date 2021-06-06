package tn.ConsomiTounsi.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="Userr")
public class Userr implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="email") 
	private String email ;
	
	@Column (name ="password") 
	private String password ;
	
	@Column (name ="username") 
	private String username ;
	

	@Column (name ="role") 
	private String role ;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Userr(int id, String email, String password, String username, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	
	
	
	
	

}
