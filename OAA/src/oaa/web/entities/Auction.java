package oaa.web.entities;

import java.sql.Date;

public class Auction {

	private int auctionId;
	private int productId;

	private Date startDate;

	private Date endDate;

	private int bidPrice;

	public Auction(int auctionId, int productId, Date startDate, Date endDate, int bidPrice) {

		// TODO Auto-generated constructor stub
		this.auctionId = auctionId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidPrice = bidPrice;

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

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

}
