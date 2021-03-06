package tn.ConsomiTounsi.Entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name ="Publication")

public class Publication {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="description") 
	private String Description ;
	
	@Column (name ="date") 
	private Date date ;
	
	@Column (name ="nbrrating") 
	private int rate ;
	
	
	
	
	
	

	
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Publication(String description, Date date) {
		super();
		Description = description;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	


	
	

	





//	@OneToMany(cascade = CascadeType.ALL, mappedBy="publications")
//	private Set<Rating> Ratings  ;
	
	
	//@OneToMany(mappedBy="publication")
//	private List<Commentaire> Commentaire ;
	
	public Publication() {
		super();
	}












	@OneToMany(cascade = CascadeType.ALL, mappedBy="pbs")
	private Set<Commentaire> commentaires  ;
    @ManyToOne
    @JsonIgnore
	@JoinColumn(name = "idUser", referencedColumnName = "iduser")
	User us;
//	@ManyToOne
//	User user ;
	
	
	
	
	
}
