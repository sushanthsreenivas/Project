package oaa.web.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class Product implements Serializable {

	private int productId;
	private String productName;
	private int userId;
	private int categoryId;
	private String description;
	private int minBidPrice;
	private Blob photo;
	private Date Date;

	public Product(int productId, String productName, int categoryId, String description, int minBidPrice, Blob photo,
			Date Date) {
	
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.description = description;
		this.minBidPrice = minBidPrice;
		this.photo = photo;
		this.Date = Date;
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinBidPrice() {
		return minBidPrice;
	}

	public void setMinBidPrice(int minBidPrice) {
		this.minBidPrice = minBidPrice;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

}
