package tn.ConsomiTounsi.Entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name ="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproduct")
	private int idproduct;
	
	@Column(name="nameproduct")
	private String nameproduct;
	
	@Column(name="priceproduct")
	private float priceproduct;
	
	
	@Column(name="quantityproduct")
	private float quantityproduct;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="weightproduct")
	private float weightproduct;
	
	@Column(name="imageproduct")
	private String imageProduct;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateproduct")
	private Date dateProduct;
	
	@ManyToOne
	private Category Category;





	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public float getPriceproduct() {
		return priceproduct;
	}

	public void setPriceproduct(float priceproduct) {
		this.priceproduct = priceproduct;
	}



	public float getQuantityproduct() {
		return quantityproduct;
	}

	public void setQuantityproduct(float quantityproduct) {
		this.quantityproduct = quantityproduct;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public float getWeightproduct() {
		return weightproduct;
	}

	public void setWeightproduct(float weightproduct) {
		this.weightproduct = weightproduct;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	
	
	public String getImageProduct() {
		return imageProduct;
	}



	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}


	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}



	public Product() {
		super();
	}

	public Date getDateProduct() {
		return dateProduct;
	}

	public void setDateProduct(Date dateProduct) {
		this.dateProduct = dateProduct;
	}

	public Product(int idproduct) {
		super();
		this.idproduct = idproduct;
	}

	public Product(int idproduct, String nameproduct, float priceproduct, float quantityproduct,
			String barcode, float weightproduct, String imageProduct, Date dateProduct,
			Category category) {
		super();
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.priceproduct = priceproduct;
		this.quantityproduct = quantityproduct;
		this.barcode = barcode;
		this.weightproduct = weightproduct;
		this.imageProduct = imageProduct;
		this.dateProduct = dateProduct;
		Category = category;
	}

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", nameproduct=" + nameproduct + ", priceproduct=" + priceproduct
				 + ", quantityproduct=" + quantityproduct + ", barcode=" + barcode
				+ ", weightproduct=" + weightproduct + ", imageProduct=" + imageProduct + ", dateProduct=" + dateProduct
				+ ", Category=" + Category + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
