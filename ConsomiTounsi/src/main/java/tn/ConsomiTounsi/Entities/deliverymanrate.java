package tn.ConsomiTounsi.Entities;

import javax.persistence.*;

@Entity
@Table(name="deliverymanrate")
public class deliverymanrate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddeliverymanrate")
	private int iddeliverymanrate;
	
	@Column(name="ClientFirstName")
    private String ClientFirstName;
	
	@Column(name="ClientLastName")
    private String ClientLastName;
	
	@Column(name="notice")
    private String notice;
	
	@Column(name="rate")
    private float rate;

	public deliverymanrate() {
		super();
	}

	public deliverymanrate(int iddeliverymanrate, String clientFirstName, String clientLastName, String notice,
			float rate) {
		super();
		this.iddeliverymanrate = iddeliverymanrate;
		ClientFirstName = clientFirstName;
		ClientLastName = clientLastName;
		this.notice = notice;
		this.rate = rate;
	}

	public int getIddeliverymanrate() {
		return iddeliverymanrate;
	}

	public void setIddeliverymanrate(int iddeliverymanrate) {
		this.iddeliverymanrate = iddeliverymanrate;
	}

	public String getClientFirstName() {
		return ClientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		ClientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return ClientLastName;
	}

	public void setClientLastName(String clientLastName) {
		ClientLastName = clientLastName;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
}