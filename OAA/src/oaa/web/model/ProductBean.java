/**
 * 
 */
package oaa.web.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
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
import org.apache.struts.upload.FormFile;

public class ProductBean extends ActionForm {

	private String category;
	private String productName;
	private String description;
	private int minBidPrice;
	private int productId;
	private FormFile image;
	private Date date;

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

	public FormFile getPhoto() {
		return image;
	}

	public void setPhoto(FormFile image) {
		this.image = image;
	}

	/*
	 * @Override public ActionErrors validate(ActionMapping mapping,
	 * HttpServletRequest request) { ActionErrors errors = new ActionErrors();
	 * 
	 * if (this.productName == null) { errors.add("productnamermsg", new
	 * ActionMessage("error.producName.required")); }
	 * 
	 * if (this.category == null) { errors.add("categoryrmsg", new
	 * ActionMessage("error.category.required")); }
	 * 
	 * if (this.description == null) { errors.add("descriptionrrmsg", new
	 * ActionMessage("error.description.required")); } if(this.minBidPrice==0){
	 * errors.add("minBidPricerrmsg", new
	 * ActionMessage("error.description.required")); }
	 * 
	 * return errors; }
	 */
	/*
	 * public Blob getPhoto() { return photo; }
	 * 
	 * public void setPhoto(Blob photo) { this.photo = photo; }
	 */

	/*
	 * public ActionErrors validate(ActionMapping mapping, HttpServletRequest
	 * request) {
	 * 
	 * ActionErrors errors = new ActionErrors();
	 * 
	 * if( getPhoto().getFileSize()== 0){ errors.add("common.file.err", new
	 * ActionMessage("error.common.file.required")); return errors; }
	 * 
	 * //only allow textfile to upload
	 * if(!"text/plain".equals(getPhoto().getContentType())){
	 * errors.add("common.file.err.ext", new
	 * ActionMessage("error.common.file.textfile.only")); return errors; }
	 * 
	 * //file size cant larger than 10kb
	 * System.out.println(getPhoto().getFileSize()); if(getPhoto().getFileSize()
	 * > 10240){ //10kb errors.add("common.file.err.size", new
	 * ActionMessage("error.common.file.size.limit", 10240)); return errors; }
	 * 
	 * return errors; }
	 */

	public boolean addProduct(int user_id) throws SQLException {

		try {

			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();
			ps = connection.prepareStatement("insert into product values(null,?,?,?,?,?,'E',?,null)");

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

	public boolean updateProduct(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			ps = connection.prepareStatement(
					"UPDATE product SET min_bid_price=?, category_id=?,description=?  WHERE product_id=?  and user_id=?");

			ps.setInt(1, getMinBidPrice());
			ps.setString(2, getCategory());
			ps.setString(3, getDescription());
			ps.setInt(4, getProductId());
			ps.setInt(5, user_id);

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

}
