package tn.ConsomiTounsi.Entities;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name ="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcategory")
	private int idcategory;
	
	@Column(name="namecategory")
	private String namecategory;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Category")
	private Set<Product> Product;

	public Category() {
		super();
	}

	public Category(int idcateory, String namecategory, Set<Product> product) {
		super();
		this.idcategory = idcateory;
		this.namecategory = namecategory;
		Product = product;
	}

	public int getIdcateory() {
		return idcategory;
	}

	public void setIdcateory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getNamecategory() {
		return namecategory;
	}

	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}

	public Set<Product> getProduct() {
		return Product;
	}

	public void setProduct(Set<Product> product) {
		Product = product;
	}
	
	
}
