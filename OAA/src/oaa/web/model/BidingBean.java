package oaa.web.model;

import java.sql.Connection;
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

	private String bidingPrice;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		productName = productName;
	}

	public String getBidingPrice() {
		return bidingPrice;
	}

	public void setBidingPrice(String bidingPrice) {
		bidingPrice = bidingPrice;
	}

	public boolean addBid(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			
						ps = connection
					.prepareStatement("insert into auction_master values(null,?,?,null,null,?,'E')");

			ps.setString(1, getProductName());
			ps.setInt(2, user_id);
			ps.setString(3, getBidingPrice());
		

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("entered");
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

}
