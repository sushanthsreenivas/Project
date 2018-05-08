package oaa.web.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

public class LaunchAuctionBean extends ActionForm {

	private int auctionId;

	private int userId;
	private String productName;
	private int bidPrice;
	private int bidPriceIncrement;
	private Date startDate;
	private Date endDate;
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Connection connection() {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");
			connection = ds.getConnection();
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;

	}

	public boolean launchAuction(int user_id) {

		try {
			connection = connection();

			ps = connection.prepareStatement(
					"insert into auction_master values(null,(select product_id from product where product_name=?),?,?,?,?,?,'E',?) " );
			ps.setString(1, getProductName());
			ps.setInt(2, user_id);
			ps.setDate(3, getStartDate());
			ps.setDate(4, getEndDate());
			ps.setInt(5, getBidPriceIncrement());
			ps.setInt(6, getBidPrice());
			ps.setString(7, getDescription());
			int rowsEffected = ps.executeUpdate();
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
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
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
