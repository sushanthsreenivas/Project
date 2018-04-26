package oaa.web.entities;

import java.sql.Blob;
import java.sql.Date;

public class Auction {

	private int auctionId;
	private int productId;
	private int userId;
	private Date startDate;
	private Date endDate;
	private int minBidPrice;
	private String productName;
	private String description;
	private Blob photo;
	private Boolean status;

	public Auction(int auctionId, int productId, int userId, Date startDate, Date endDate, int minBidPrice,
			String productName, Blob photo, String description) {

		// TODO Auto-generated constructor stub
		this.auctionId = auctionId;
		this.productId = productId;
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minBidPrice = minBidPrice;
		this.productName = productName;
		this.photo = photo;
		this.description = description;

	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getMinBidPrice() {
		return minBidPrice;
	}

	public void setMinBidPrice(int minBidPrice) {
		this.minBidPrice = minBidPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
