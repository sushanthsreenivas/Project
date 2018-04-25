package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;

public class AccountBean extends ActionForm {
	private String password_old, password1, password2;
	private String firstname, lastname, address, city, state, country;
	private String mobileno, email;

	public String getPassword_old() {
		return password_old;
	}

	public void setPassword_old(String password_old) {
		this.password_old = password_old;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean updatepassword() throws SQLException {
		Connection connection = null;
		Context context = null;
		PreparedStatement ps = null;

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");
			connection = ds.getConnection();
			ps = connection.prepareStatement("update users password_old=?,password_1=?,password_2=? where user_id=?");
			ps.setString(1, getPassword_old());
			ps.setString(2, getPassword1());
			ps.setString(3, getPassword2());

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

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

			} catch (NamingException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;

	}

	public boolean updatedetails() throws SQLException {
		Connection connection = null;
		Context context = null;
		PreparedStatement ps = null;

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oaadb");
			connection = ds.getConnection();
			ps = connection.prepareStatement(
					"update users firstname=?,lastname=?,address=?,city=?,state=?,country=?,mobileno=?,email=? where status=? and user_id=?");
			ps.setString(1, getFirstname());
			ps.setString(2, getLastname());
			ps.setString(3, getAddress());
			ps.setString(4, getCity());
			ps.setString(5, getState());
			ps.setString(6, getCountry());
			ps.setString(7, getMobileno());
			ps.setString(8, getEmail());

			int rowsEffected = ps.executeUpdate();
			if (rowsEffected > 0) {

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

			} catch (NamingException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;

	}

}
