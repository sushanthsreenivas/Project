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

import org.apache.struts.action.ActionForm;

public class BidingBean extends ActionForm {

	Context context = null;
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private String category;

	private String productName;

	private int bidingPrice;
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getBidingPrice() {
		return bidingPrice;
	}

	public void setBidingPrice(int bidingPrice) {
		this.bidingPrice = bidingPrice;
	}

	public boolean addBid(int user_id) throws SQLException {

		try {

			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			ps = connection.prepareStatement("insert into auction_master values(null,?,?,?,null,?,'E')");
			ps.setString(1, getProductName());
			ps.setInt(2, user_id);
			ps.setInt(3, getBidingPrice());
			Date sqlDate = new Date(new java.util.Date().getTime());
			System.out.println(sqlDate);
			ps.setDate(4, sqlDate);
			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("entered");//
				return true;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateBid(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			ps = connection.prepareStatement(
					"UPDATE auction_master SET  min_bid_price=?  WHERE product_id=?  and product_name=?");

			ps.setString(1, getProductName());
			ps.setString(2, getCategory());
			ps.setInt(3, user_id);
			ps.setInt(4, getBidingPrice());

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("entered");
				return true;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
