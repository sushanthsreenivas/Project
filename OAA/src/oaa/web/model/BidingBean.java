package oaa.web.model;

import java.io.OutputStream;

import java.sql.Connection;
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

public class BidingBean extends ActionForm {

	Context context = null;
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private int bidprice;

	private int auctionid;

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

	public boolean addBid(int user_id) throws SQLException {

		try {

			connection = connection();
			ps = connection.prepareStatement("insert into auction_transaction values(null,?,?,?,now())");
			ps.setInt(1, getAuctionid());
			ps.setInt(2, user_id);
			ps.setInt(3, getBidprice());

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
			connection = connection();
			ps = connection.prepareStatement(
					"UPDATE auction_transaction join users on users.user_id=auction_transaction.user_id join "
							+ "auction_master on auction_master.auction_id=auction_transaction.auction_id"
							+ " SET auction_transaction.bid_prize =?, Date=now() where auction_transaction.user_id=? and auction_transaction.auction_id=?");
			ps.setInt(1, getBidprice());
			ps.setInt(2, user_id);
			ps.setInt(3, getAuctionid());

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

				return true;
			}
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

	public Collection<Auction> getListAuction(int user_id) {
		// TODO Auto-generated method stub

		Collection<Auction> auctionList = new ArrayList<Auction>();
		try {

			OutputStream oImage;
			Auction auction = null;
			connection = connection();
			String sql = "SELECT auction_id,product_id,user_id,start_date,end_date,bid_prize FROM auction_master  where status=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "E");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				auction = new Auction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6));
				// add each employee to the list
				auctionList.add(auction);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}
}
