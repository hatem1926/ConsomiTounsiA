package tn.ConsomiTounsi.Entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name ="Likes")
public class Likes implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="NbrLikes") 
	private int NbrLikes;

	public Likes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrLikes() {
		return NbrLikes;
	}

	public void setNbrLikes(int nbrLikes) {
		NbrLikes = nbrLikes;
	}
	
	@ManyToOne
	Commentaire commentaire ;
	
//	@ManyToOne
//	User user ;
	
}

