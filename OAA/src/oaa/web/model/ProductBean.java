/**
 * 
 */
package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ProductBean extends ActionForm {

	private String category;
	private String productName;
	private String description;
	private int minBidPrice;
	// private String Photo;

	Context context = null;
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;



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

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getProductName() == null) {
			errors.add("productnamermsg", new ActionMessage(
					"error.producName.required"));
		}

		if (getCategory() == null) {
			errors.add("categoryrmsg", new ActionMessage(
					"error.category.required"));
		}

		if (getDescription() == null) {
			errors.add("descriptionrrmsg", new ActionMessage(
					"error.description.required"));
		}
		if (getMinBidPrice() == 0) {
			errors.add("minbidpricerrmsg", new ActionMessage(
					"error.minBidprice.required"));

		}
		return errors;
	}

	public boolean addProduct(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			
						ps = connection
					.prepareStatement("insert into product values(null,?,?,?,?,?,'E',null,null)");

			ps.setString(1, getProductName());
			ps.setString(2, getCategory());
			ps.setInt(3, user_id);
			ps.setString(4, getDescription());
			ps.setInt(5, getMinBidPrice());

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
	public boolean UpdateProduct(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			
						ps = connection
					.prepareStatement( "UPDATE product SET product_name=?, category_id=?, =? WHERE product_id=?");

			ps.setString(1, getProductName());
			ps.setString(2, getCategory());
			ps.setInt(3, user_id);
			ps.setString(4, getDescription());
			ps.setInt(5, getMinBidPrice());

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
	public boolean RemoveProduct(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			
						ps = connection
					.prepareStatement("insert into product values(null,?,?,?,?,?,'E',null,null)");

			ps.setString(1, getProductName());
			ps.setString(2, getCategory());
			ps.setInt(3, user_id);
			ps.setString(4, getDescription());
			ps.setInt(5, getMinBidPrice());

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
