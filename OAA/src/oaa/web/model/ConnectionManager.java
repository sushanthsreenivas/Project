package oaa.web.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager  {
	Context context = null;
	Connection con= null;

	public Connection connection() {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/TeamDB");
			con = ds.getConnection();
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return con;

	}

}
