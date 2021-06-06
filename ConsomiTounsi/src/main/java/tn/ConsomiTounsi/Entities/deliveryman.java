package tn.ConsomiTounsi.Entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name ="deliveryman")
public class deliveryman {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddeliveryman")
	private int iddeliveryman;
	
	@Column(name="firstnameD")
	private String firstname;
	
	@Column(name="lastnameD")
	private String lastname;
	
	@Column(name="emaildeliveryman")
	private String emaildeliveryman;
	
	@Column(name="passwordD")
	private String passwordD;
	
	@Column(name="phonenumberD")
	private String phonenumber;
	
	@Column(name="deliverymancity")
	private String deliverymancity;
	
	@Column(name="salary")
	private float salary;
	
	@Column(name="rate")
	private int rate;
	
	@Column(name="state")
	private int state;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryman")
	private Set<delivery> delivery;

	public deliveryman() {
		super();
	}

	public deliveryman(int iddeliveryman, String firstname, String lastname, String emaildeliveryman, String passwordD,
			String phonenumber, String deliverymancity, float salary, int rate, int state) {
		super();
		this.iddeliveryman = iddeliveryman;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emaildeliveryman = emaildeliveryman;
		this.passwordD = passwordD;
		this.phonenumber = phonenumber;
		this.deliverymancity = deliverymancity;
		this.salary = salary;
		this.rate = rate;
		this.state = state;
	}

	public int getIddeliveryman() {
		return iddeliveryman;
	}

	public void setIddeliveryman(int iddeliveryman) {
		this.iddeliveryman = iddeliveryman;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmaildeliveryman() {
		return emaildeliveryman;
	}

	public void setEmaildeliveryman(String emaildeliveryman) {
		this.emaildeliveryman = emaildeliveryman;
	}

	public String getPasswordD() {
		return passwordD;
	}

	public void setPasswordD(String passwordD) {
		this.passwordD = passwordD;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getdeliverymancity() {
		return deliverymancity;
	}

	public void setdeliverymancity(String deliverymancity) {
		this.deliverymancity = deliverymancity;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
