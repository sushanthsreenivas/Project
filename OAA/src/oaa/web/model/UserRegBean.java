package oaa.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UserRegBean extends ActionForm {

	private String email_id, passwd, role, firstname, lastname;
	private String mobileno;
	private String address, city, state, pincode;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getRole() == null) {
			errors.add("roleerrmsg", new ActionMessage("error.role.required"));
		}

		if (getFirstname() == null || getFirstname().length() < 2) {
			errors.add("firstnameerrmsg", new ActionMessage("error.firstname.required"));
		}

		if (getLastname() == null || getLastname().length() < 2) {
			errors.add("lastnameerrmsg", new ActionMessage("error.lastname.required"));
		}

		if (getEmail_id() == null || getEmail_id().length() < 6) {
			errors.add("emailiderrmsg", new ActionMessage("error.emailid.required"));
		}

		if (getPasswd() == null || getPasswd().length() < 6) {
			errors.add("passwderrmsg", new ActionMessage("error.passwd.required"));
		}

		if (getMobileno() == null || getMobileno().length() < 10) {
			errors.add("mobilenoerrmsg", new ActionMessage("error.mobileno.required"));

		}

		if (getAddress() == null || getAddress().length() < 5) {
			errors.add("addresserrmsg", new ActionMessage("error.address.required"));
		}

		if (getCity() == null || getCity().length() < 5) {
			errors.add("cityerrmsg", new ActionMessage("error.city.required"));
		}

		if (getState() == null || getState().length() < 5) {
			errors.add("stateerrmsg", new ActionMessage("error.state.required"));
		}

		if (getPincode() == null || getPincode().length() < 6) {
			errors.add("pincodeerrmsg", new ActionMessage("error.pincode.required"));
		}

		return errors;
	}

	public boolean registerUser() throws SQLException {

		Context context = null;
		Connection connection = new ConnectionManager().connection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement("insert into users values(user_id.NEXTVAL,?,?,?,?,?,?,'E',?,?,?,?)");

			ps.setString(1, getEmail_id());
			ps.setString(2, getFirstname());
			ps.setString(3, getLastname());
			ps.setString(4, getPasswd());
			ps.setString(5, getRole());
			ps.setString(6, getMobileno());
			ps.setString(7, getAddress());
			ps.setString(8, getCity());
			ps.setString(9, getState());
			ps.setString(10, getPincode());

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

}