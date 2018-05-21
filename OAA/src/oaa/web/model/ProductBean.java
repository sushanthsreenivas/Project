
package oaa.web.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import oaa.web.entities.Product;

public class ProductBean extends ActionForm {

	private String category;
	private String productName;
	private String description;
	private int minBidPrice;
	private int productId;
	private FormFile image;

	Context context = null;
	Connection connection = new ConnectionManager().connection();
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

			byte[] fileData = null;
			ByteArrayInputStream fileBA = null;

			fileData = image.getFileData();
			fileBA = new ByteArrayInputStream(fileData);

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

				return true;
			}
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

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateProduct(int user_id) {

		try {
			byte[] fileData = null;
			ByteArrayInputStream fileBA = null;

			fileData = image.getFileData();

			fileBA = new ByteArrayInputStream(fileData);

			ps = connection.prepareStatement(
					"UPDATE product SET min_bid_price=?, category_id=?,description=?,photo=?,Date=now()  WHERE product_id=?  and user_id=?");

			ps.setInt(1, getMinBidPrice());
			ps.setString(2, getCategory());
			ps.setString(3, getDescription());
			ps.setBinaryStream(4, fileBA);
			ps.setString(5, getProductName());
			ps.setInt(6, user_id);

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

				return true;
			}
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

				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean RemoveProduct(int user_id) throws SQLException {

		try {
			ps = connection.prepareStatement("update product set status=? where user_id=? and product_id=?");
			ps.setString(1, "D");
			ps.setInt(2, user_id);
			ps.setString(3, getProductName());
			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {
				return true;
			}
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

	public List<Product> getListProducts(int user_id) {

		List<Product> productList = new ArrayList<Product>();
		try {

			Product product = null;
			String sql = "SELECT product_id,product_name,category_id,description,min_bid_price,photo,Date FROM product where user_id=? and status=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, "E");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getBlob(6), rs.getDate(7));
				// add each employee to the list
				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

}
