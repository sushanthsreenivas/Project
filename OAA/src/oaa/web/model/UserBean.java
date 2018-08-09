package oaa.web.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;

public class UserBean implements Serializable {
	private String email_id;
	private String firstName;
	private String lastName;

	Context context = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] validateLogin(String email_id, String passwd) {

		Connection connection = new ConnectionManager().connection();

		try {

			ps = connection.prepareStatement("select firstname,lastname,user_id,role from users where email_id=? and passwd=?");

			ps.setString(1, email_id);
			ps.setString(2, passwd);

			rs = ps.executeQuery();

			if (rs.next()) {
				this.email_id = email_id;
				firstName = rs.getString(1);
				lastName = rs.getString(2);
				String[] result = new String[2];
				result[0] = rs.getString(3);
				result[1] = rs.getString(4);
				return result;
			}
		} catch (SQLException e) {

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

		return null;
	}

}