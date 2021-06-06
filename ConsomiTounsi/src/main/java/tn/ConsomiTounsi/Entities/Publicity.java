package tn.ConsomiTounsi.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name ="Publicity")
public class Publicity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdPublicity")
	private int IdPublicity;
	@Column(name="PublicityName")
	private String PublicityName;
	@Temporal(TemporalType.DATE)
	@Column(name="Start_Date")
	private Date Start_Date;
	@Temporal(TemporalType.DATE)
	@Column(name="End_Date")
	private Date End_Date;
	@Column(name="Price")
	private float Price;
	@Column(name="Canal")
	private String Canal;
	
	
	public Publicity() {
		super();
	}


	public Publicity(int idPublicity) {
		super();
		IdPublicity = idPublicity;
	}


	public Publicity(int idPublicity, String publicityName, Date start_Date, Date end_Date, float price,
			String canal) {
		super();
		IdPublicity = idPublicity;
		PublicityName = publicityName;
		Start_Date = start_Date;
		End_Date = end_Date;
		Price = price;
		Canal = canal;
	}


	public int getIdPublicity() {
		return IdPublicity;
	}


	public void setIdPublicity(int idPublicity) {
		IdPublicity = idPublicity;
	}


	public String getPublicityName() {
		return PublicityName;
	}


	public void setPublicityName(String publicityName) {
		PublicityName = publicityName;
	}


	public Date getStart_Date() {
		return Start_Date;
	}


	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}


	public Date getEnd_Date() {
		return End_Date;
	}


	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}


	public float getPrice() {
		return Price;
	}


	public void setPrice(float price) {
		Price = price;
	}


	public String getCanal() {
		return Canal;
	}


	public void setCanal(String canal) {
		Canal = canal;
	}


	@Override
	public String toString() {
		return "Publicity [IdPublicity=" + IdPublicity + ", PublicityName=" + PublicityName + ", Start_Date="
				+ Start_Date + ", End_Date=" + End_Date + ", Price=" + Price + ", Canal=" + Canal + "]";
	}
	
	
	
	




}
