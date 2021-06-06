package tn.ConsomiTounsi.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name ="Don ")
public class Don implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="id") 
	private int id ;
	
	@Column (name ="idUser") 
	private int idUser ;
	
	@Column (name ="idEvent") 
	private int idEvent ;
	
	@ManyToOne
	User userss ;
	
	@ManyToOne
	Evenement events ;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(Don);
		result = prime * result + id;
		result = prime * result + idEvent;
		result = prime * result + idUser;
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
		Don other = (Don) obj;
		if (Float.floatToIntBits(Don) != Float.floatToIntBits(other.Don))
			return false;
		if (id != other.id)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}





	public Don(int idUser, int idEvent, float don) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
		Don = don;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getIdUser() {
		return idUser;
	}





	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}





	public int getIdEvent() {
		return idEvent;
	}





	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}





	public float getDon() {
		return Don;
	}





	public void setDon(float don) {
		Don = don;
	}





	@Column (name ="Don")
	private float Don;
	
	
	
	
	
	

//	@ManyToOne
//	@JoinColumn(name="idUser",referencedColumnName="iduser",insertable=false,updatable=false)
//	private User user ;
	
//	@ManyToOne
//	@JoinColumn(name="idEvent",referencedColumnName="id",insertable=false,updatable=false)
//	private Evenement event  ;
	
	
	
	

}


