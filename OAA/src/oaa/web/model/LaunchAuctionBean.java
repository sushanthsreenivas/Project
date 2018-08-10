package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.struts.action.ActionForm;

public class LaunchAuctionBean extends ActionForm {

	private int auctionId;
	private int userId;
	private String productName;
	private int productId;
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	private int bidPrice;
	private int bidPriceIncrement;
	private String startDate;
	private String endDate;
	private String description;

	Context context = null;
	Connection connection = new ConnectionManager().connection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	PreparedStatement ss = null;
	ResultSet rs1 = null;

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
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

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getBidPriceIncrement() {
		return bidPriceIncrement;
	}

	public void setBidPriceIncrement(int bidPriceIncrement) {
		this.bidPriceIncrement = bidPriceIncrement;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean launchAuction(int user_id) {

		try {

			ps = connection.prepareStatement("insert into auction_master values(auction_id.NEXTVAL,?,?,?,?,?,?,'E',?) ");
			ps.setInt(1, getProductId());
			ps.setInt(2, user_id);
			ps.setString(3, getStartDate());
			ps.setString(4, getEndDate());
			ps.setInt(5, getBidPrice());
			ps.setInt(6, getBidPriceIncrement());
			ps.setString(7, getDescription());

			int rowsEffected = ps.executeUpdate();

			ss = connection.prepareStatement("select max(auction_id) from auction_master where user_id=?");

			ss.setInt(1, user_id);
			ResultSet rs1 = ss.executeQuery();
			if (rs1.next()) {
				this.auctionId = rs1.getInt(1);
			}

			Statement stat = connection.createStatement();
			
			stat.execute("create event status_disable"+ getAuctionId()+" on schedule at '" + getEndDate()
					+ "' do update auction_master set status='D' where auction_id=" + getAuctionId());

			
			if (rowsEffected > 0) {

				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (context != null) {
					context.close();
				}
				/*
				 * if (connection != null && !connection.isClosed()) {
				 * connection.close(); }
				 */
				if (ps != null && !ps.isClosed()) {
					ps.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (NamingException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

}