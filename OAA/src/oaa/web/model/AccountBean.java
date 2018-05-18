package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.struts.action.ActionForm;

public class AccountBean extends ActionForm {
	private String password_old, password_new, password_new1;
	private String firstname, lastname, address, city, state, country;
	private String telNo, email;
	Connection connection = new ConnectionManager().connection();
	Context context = null;
	PreparedStatement ps = null;

	public String getPassword_old() {
		return password_old;
	}

	public void setPassword_old(String password_old) {
		this.password_old = password_old;
	}

	public String getPassword_new() {
		return password_new;
	}

	public void setPassword_new(String password_new) {
		this.password_new = password_new;
	}

	public String getPassword_new1() {
		return password_new1;
	}

	public void setPassword_new1(String password_new1) {
		this.password_new1 = password_new1;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean updatepassword(int user_id) throws SQLException {

		try {

			ps = connection.prepareStatement("update users set passwd=? where user_id=? ");

			ps.setInt(2, user_id);
			ps.setString(1, getPassword_new());

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

				return true;
			}
		}  finally {
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

			} catch (NamingException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;

	}

	public boolean updatedetails(int user_id) throws SQLException {

		try {

			ps = connection.prepareStatement(
					"update users set firstname=?,lastname=?,address=?,city=?,state=?,mobileno=?,email_id=? where  user_id=?");
			ps.setString(1, getFirstname());
			ps.setString(2, getLastname());
			ps.setString(3, getAddress());
			ps.setString(4, getCity());
			ps.setString(5, getState());
			ps.setString(6, getTelNo());
			ps.setString(7, getEmail());
			ps.setInt(8, user_id);

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

				return true;
			}
		}  finally {
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

			} catch (NamingException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;

	}

}
