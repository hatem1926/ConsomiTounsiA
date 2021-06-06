package tn.ConsomiTounsi.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name ="Rating")
public class Rating implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="NbrRating") 
	private int NbrRating;

	public Rating() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrRating() {
		return NbrRating;
	}

	public void setNbrRating(int nbrRating) {
		NbrRating = nbrRating;
	}
	
//	@ManyToOne
//	@JsonIgnore
//	@JoinColumn(name = "idpub", referencedColumnName = "id")
//	Publication p;
	
	
//	@ManyToOne
//	Publication publications ;
	

}
