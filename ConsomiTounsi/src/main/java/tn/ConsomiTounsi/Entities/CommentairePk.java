package tn.ConsomiTounsi.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class CommentairePk implements Serializable{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + idPublication;
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
		CommentairePk other = (CommentairePk) obj;
		
		if (idPublication != other.idPublication)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	
	public CommentairePk(int idUser, int idPublication, int idComment) {
		super();
		this.idUser = idUser;
		this.idPublication = idPublication;
		
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}
	
	private int idUser ;
	private int idPublication ;
	
	
	
	

}
