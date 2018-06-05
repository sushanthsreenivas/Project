package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.struts.action.ActionForm;

import oaa.web.entities.Auction;
import oaa.web.entities.Bid;

public class BidingBean extends ActionForm {

	Context context = null;
	Connection connection = new ConnectionManager().connection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	private int auctionid;
	private int userid;
	private int bidAmount;
	private int lastBidAmount;
	private int bidAmountIncrement;

	public int getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	public int getLastBidAmount() {
		return lastBidAmount;
	}

	public void setLastBidAmount(int lastBidAmount) {
		this.lastBidAmount = lastBidAmount;
	}

	public int getBidAmountIncrement() {
		return bidAmountIncrement;
	}

	public void setBidAmountIncrement(int bidAmountIncrement) {
		this.bidAmountIncrement = bidAmountIncrement;
	}

	public boolean addBid(int user_id) throws SQLException {

		try {
			ps = connection.prepareStatement("insert into auction_transaction values(null,?,?,?,now())");
			ps.setInt(1, getAuctionid());
			ps.setInt(2, user_id);
			ps.setInt(3, getBidAmount());

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

	public Bid getBidDetails(int auctionid, int userid) {

		Bid bid = null;
		try {

			String sql = "SELECT distinct bid_amount_increment,max(bid_amount) FROM auction_transaction join auction_master "
					+ "on auction_transaction.auction_id=auction_master.auction_id where status=? and auction_master.auction_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "E");
			ps.setInt(2, auctionid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				this.auctionid = auctionid;
				this.userid = userid;
				this.bidAmountIncrement = rs.getInt(1);
				this.lastBidAmount = rs.getInt(2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bid;
	}

}
