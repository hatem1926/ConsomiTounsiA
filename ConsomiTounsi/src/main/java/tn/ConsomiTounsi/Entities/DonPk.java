package tn.ConsomiTounsi.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class DonPk implements Serializable{
	
	private int idDon ;
	private int idUser;
	private int idEvent ;
	public DonPk(int idDon, int idUser, int idEvent) {
		super();
		this.idDon = idDon;
		this.idUser = idUser;
		this.idEvent = idEvent;
	}
	public int getIdDon() {
		return idDon;
	}
	public void setIdDon(int idDon) {
		this.idDon = idDon;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDon;
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
		DonPk other = (DonPk) obj;
		if (idDon != other.idDon)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	public DonPk() {
		super();
	}
	
	

}

