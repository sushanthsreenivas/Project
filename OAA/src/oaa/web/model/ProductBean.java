/**

 * 
 */
package oaa.web.model;

import java.io.ByteArrayInputStream;


import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ProductBean extends ActionForm {

	private String category;
	private String productName;
	private String description;
	private int minBidPrice;
	private int productId;
	private FormFile image;

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public FormFile getImage() {
		return image;
	}

	public void setImage(FormFile image) {
		this.image = image;
	}

	public boolean addProduct(int user_id) {

		try {

			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			byte[] fileData = null;
			ByteArrayInputStream fileBA = null;

			fileData = image.getFileData();

			fileBA = new ByteArrayInputStream(fileData);

			connection = ds.getConnection();
			ps = connection.prepareStatement("insert into product values(null,?,?,?,?,?,'E',?,now())");

			ps.setString(1, getProductName());

			ps.setString(3, getCategory());
			ps.setInt(2, user_id);

			ps.setString(4, getDescription());
			ps.setInt(5, getMinBidPrice());
			ps.setBinaryStream(6, fileBA);
			/*
			 * Date sqlDate = new Date(new java.util.Date().getTime());
			 * ps.setDate(7, sqlDate);
			 */

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("entered");
				return true;
			}
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

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

	public boolean updateProduct(int user_id) {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");
			byte[] fileData = null;
			ByteArrayInputStream fileBA = null;

			fileData = image.getFileData();

			fileBA = new ByteArrayInputStream(fileData);

			connection = ds.getConnection();

			ps = connection.prepareStatement(
					"UPDATE product SET min_bid_price=?, category_id=?,description=?,photo=?,Date=now()  WHERE product_id=?  and user_id=?");

			ps.setInt(1, getMinBidPrice());
			ps.setString(2, getCategory());
			ps.setString(3, getDescription());
			ps.setBinaryStream(4, fileBA);
			ps.setInt(5, getProductId());
			ps.setInt(6, user_id);

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
		} catch (IOException e) {
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
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();
			ps = connection.prepareStatement("delete from product where user_id=? and product_id=?");
			ps.setInt(1, user_id);
			ps.setInt(2, getProductId());
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

	public void displayImage() {

		try {

			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			String sql = "SELECT photo FROM products";

			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Blob ph = rs.getBlob("photo");
				System.out.println(rs.getBlob("photo"));
				byte data[] = ph.getBytes(1, (int) ph.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
