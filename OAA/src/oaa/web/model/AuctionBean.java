package oaa.web.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;

import oaa.web.entities.Auction;

public class AuctionBean extends ActionForm{
	
	private int auctionId;
	private int productId;
	private int userId;
	private Date startDate;
	private Date endDate;
	private int bidPrice;
	private String productName;
	private String description;
	private Blob photo;
	private Boolean status;
	
	Context context = null;
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

	
	public Connection connection() {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");
			connection = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	
	public Collection<Auction> getListAuction() {

		Collection<Auction> auctionList = new ArrayList<Auction>();
		try {

			Auction auction = null;
			connection = connection();
			String sql = "SELECT m.auction_id,m.product_id,m.user_id,m.start_date,m.end_date,m.bid_prize,p.product_name,p.photo,p.description  FROM auction_master m join product p on m.product_id=p.product_id  where  m.status=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "E");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				auction = new Auction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getBlob(8), rs.getString(9));
				// add each employee to the list
				auctionList.add(auction);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}

	
	

}
