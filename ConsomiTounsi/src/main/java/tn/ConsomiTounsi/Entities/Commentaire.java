package tn.ConsomiTounsi.Entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name ="Commentaire")

public class Commentaire implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idComment;
	@Column(name="commentaire")
	private String Commentaire ;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Commentaire == null) ? 0 : Commentaire.hashCode());
		result = prime * result + idComment;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commentaire other = (Commentaire) obj;
		if (Commentaire == null) {
			if (other.Commentaire != null)
				return false;
		} else if (!Commentaire.equals(other.Commentaire))
			return false;
		if (idComment != other.idComment)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Commentaire [Commentaire=" + Commentaire + "]";
	}
	public Commentaire(String commentaire) {
		super();
		Commentaire = commentaire;
	}
	public Commentaire(int idComment, String commentaire) {
		super();
		this.idComment = idComment;
		Commentaire = commentaire;
	}
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public String getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	
	
	
	public Commentaire(int idComment, String commentaire, User uu, Publication pbs) {
		super();
		this.idComment = idComment;
		Commentaire = commentaire;
		this.uu = uu;
		this.pbs = pbs;
	}
	public User getUu() {
		return uu;
	}
	public void setUu(User uu) {
		this.uu = uu;
	}
	public Publication getPbs() {
		return pbs;
	}
	public void setPbs(Publication pbs) {
		this.pbs = pbs;
	}



	public Commentaire() {
		super();
	}
	
	
	



	




	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "iduser", referencedColumnName = "iduser")
	User uu;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idpub", referencedColumnName = "id",insertable=false,updatable=false)
	Publication pbs;
	
	
	
/*	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Publication getPubs() {
		return pubs;
	}
	public void setPubs(Publication pubs) {
		this.pubs = pubs;
	}
	public Commentaire() {
		super();
	}*/
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	User users ;
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	Publication pbs ;
	
	
	
	
	
	

//	@OneToMany(cascade = CascadeType.ALL, mappedBy="Commentaire")
//	private Set<Commentaire> Commentaire ;
	
	//@ManyToOne 
	// Publication publications ;
	
	//@ManyToOne
	 //User users ;
	
//	@ManyToOne
//	@JoinColumn(name="idUser",referencedColumnName="iduser",insertable=false,updatable=false)
//	private User user ;
	
//	@ManyToOne
//	@JoinColumn(name="idPublication",referencedColumnName="id",insertable=false,updatable=false)
//	private Publication publication ;
	
	

}
