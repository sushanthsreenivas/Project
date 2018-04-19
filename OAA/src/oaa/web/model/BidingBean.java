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
	/*
	 * private String category;
	 * 
	 * private String productName;
	 * 
	 * private int bidingPrice;
	 */

	private int auctionid;

	private int bidprice;

	/*
	 * public String getCategory() { return category; }
	 * 
	 * public void setCategory(String category) { this.category = category; }
	 * 
	 * public String getProductName() { return productName; }
	 * 
	 * public void setProductName(String productName) { this.productName =
	 * productName; }
	 * 
	 * public int getBidingPrice() { return bidingPrice; }
	 * 
	 * public void setBidingPrice(int bidingPrice) { this.bidingPrice =
	 * bidingPrice; }
	 */

	public int getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public int getBidprice() {
		return bidprice;
	}

	public void setBidprice(int bidprice) {
		this.bidprice = bidprice;
	}

	public boolean addBid(int user_id) throws SQLException {

		try {

			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			ps = connection.prepareStatement("insert into auction_transaction values(null,?,?,?,?)");
			ps.setInt(1, getAuctionid());
			ps.setInt(2, user_id);
			ps.setInt(3, getBidprice());
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

	/*
	 * public boolean addBid(int user_id) throws SQLException {
	 * 
	 * try {
	 * 
	 * context = new InitialContext(); DataSource ds = (DataSource)
	 * context.lookup("java:comp/env/jdbc/oaadb");
	 * 
	 * connection = ds.getConnection();
	 * 
	 * ps = connection.
	 * prepareStatement("insert into auction_master values(null,?,?,?,null,?,'E')"
	 * ); ps.setString(1, getProductName()); ps.setInt(2, user_id); ps.setInt(3,
	 * getBidingPrice()); Date sqlDate = new Date(new
	 * java.util.Date().getTime()); System.out.println(sqlDate); ps.setDate(4,
	 * sqlDate); int rowsEffected = ps.executeUpdate(); if (rowsEffected > 0) {
	 * System.out.println("entered");// return true; } } catch (NamingException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } finally {
	 * try { if (context != null) { context.close(); } if (connection != null &&
	 * !connection.isClosed()) { connection.close(); } if (ps != null &&
	 * !ps.isClosed()) { ps.close(); } if (rs != null && !rs.isClosed()) {
	 * rs.close(); } } catch (NamingException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } return false; }
	 */

	/*
	 * public boolean updateProduct(int user_id) {
	 * 
	 * try { context = new InitialContext(); DataSource ds = (DataSource)
	 * context.lookup("java:comp/env/jdbc/oaadb"); byte[] fileData = null;
	 * ByteArrayInputStream fileBA = null;
	 * 
	 * fileData = image.getFileData();
	 * 
	 * fileBA = new ByteArrayInputStream(fileData);
	 * 
	 * connection = ds.getConnection();
	 * 
	 * ps = connection.prepareStatement(
	 * "UPDATE product SET min_bid_price=?, category_id=?,description=?,photo=?,Date=?  WHERE product_id=?  and user_id=?"
	 * );
	 * 
	 * ps.setInt(1, getMinBidPrice()); ps.setString(2, getCategory());
	 * ps.setString(3, getDescription()); ps.setBinaryStream(4, fileBA); Date
	 * sqlDate = new Date(new java.util.Date().getTime()); ps.setDate(5,
	 * sqlDate); ps.setInt(6, getProductId()); ps.setInt(7, user_id);
	 * 
	 * int rowsEffected = ps.executeUpdate(); if (rowsEffected > 0) {
	 * System.out.println("entered"); return true; } } catch (NamingException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } finally {
	 * 
	 * try { if (context != null) { context.close(); } if (connection != null &&
	 * !connection.isClosed()) { connection.close(); } if (ps != null &&
	 * !ps.isClosed()) { ps.close(); } if (rs != null && !rs.isClosed()) {
	 * rs.close(); } } catch (NamingException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } return false; }
	 */
	public boolean updateBid(int user_id) throws SQLException {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");

			connection = ds.getConnection();

			ps = connection.prepareStatement(
					"UPDATE auction_transcation join users users.user_id=auction_transaction.user_id join auction_master on auction_master.auction_id=auction_transaction.auction_id SET bid_prize =? Date=? where userid=? and bid_id=?  ");
			ps.setInt(1, getBidprice());
			Date sqlDate = new Date(new java.util.Date().getTime());
			System.out.println(sqlDate);
			ps.setDate(2, sqlDate);
			ps.setInt(3, user_id);
			ps.setInt(4, getAuctionid());

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
