package tn.ConsomiTounsi.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name ="Evenement ")
public class Evenement implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="StartDate") 
	private Date StartDate ;
	
	@Column (name ="EndDate") 
	private Date EndDate ;
	
	@Column (name ="NbrParticipant") 
	private int NbrParticipant ;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="Evenements")
//	private Set<Don> Dons ;
	
	@Column (name ="Price") 
	private float price ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public int getNbrParticipant() {
		return NbrParticipant;
	}

	public void setNbrParticipant(int nbrParticipant) {
		NbrParticipant = nbrParticipant;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Evenement() {
		super();
	}
	
	
//	@OneToMany( mappedBy="event")
//	private List<Don> don ;
	
	@ManyToOne
	User user ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="events")
	private Set<Evenement> events;

}

