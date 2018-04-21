package oaa.web.model;

import java.util.Date;
import java.sql.Blob;

public class Product {

	public int productId;
	public String productName;
	public int userId;
	public int categoryId;
	public String description;
	public int minBidPrice;
	public Blob photo;
	public boolean status;
	public Date Date;

	public Product(int productId, String productName, int userId, String description, int minBidPrice, int categoryId,
			Blob photo, boolean status, Date Date) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.categoryId = categoryId;
		this.description = description;
		this.minBidPrice = minBidPrice;
		this.photo = photo;
		this.status = status;
		this.Date = Date;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

}
