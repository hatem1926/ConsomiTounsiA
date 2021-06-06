package tn.ConsomiTounsi.Entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="delivery")
public class delivery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddelivery")
	private int iddelivery;
	
	@Column(name="deliverydescription")
	private String deliverydescription;
	
	@Column(name="deliveryprice")
	private float deliveryprice;
	
	@Column(name="deliverydate")
	private Date deliverydate;
	
	@Column(name="deliveryaddress")
	private String deliveryaddress;
	
	@Column(name="deliverycity")
	private String deliverycity;
	
	@JsonIgnore
	@ManyToOne
	private deliveryman deliveryman;

	public delivery() {
		super();
	}

	public delivery(int iddelivery, String deliverydescription, float deliveryprice, Date deliverydate,
			String deliverycity) {
		super();
		this.iddelivery = iddelivery;
		this.deliverydescription = deliverydescription;
		this.deliveryprice = deliveryprice;
		this.deliverydate = deliverydate;
		this.deliverycity = deliverycity;
	}

	public int getIddelivery() {
		return iddelivery;
	}

	public void setIddelivery(int iddelivery) {
		this.iddelivery = iddelivery;
	}

	public String getDeliverydescription() {
		return deliverydescription;
	}

	public void setDeliverydescription(String deliverydescription) {
		this.deliverydescription = deliverydescription;
	}

	public float getDeliveryprice() {
		return deliveryprice;
	}

	public void setDeliveryprice(float deliveryprice) {
		this.deliveryprice = deliveryprice;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getdeliverycity() {
		return deliverycity;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setdeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}


	public deliveryman getdeliveryman() {
		return deliveryman;
	}

	public void setdeliveryman(deliveryman deliveryman) {
		this.deliveryman = deliveryman;
	}

	public void setdeliverycity(String deliverycity) {
		this.deliverycity = deliverycity;
	}
}