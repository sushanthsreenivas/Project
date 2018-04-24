package oaa.web.view;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import oaa.web.entities.Product;

@WebServlet("/image")
public class ImageProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ImageProcessing() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "nostore");
		int index = Integer.parseInt(request.getParameter("index"));

		HttpSession session = request.getSession(false);
		if (session != null) {
			ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productList");
			Product product = products.get(index);
			Blob photo = product.getPhoto();
			if (photo != null) {
				ServletOutputStream oImage = null;
				try {
					byte barray[] = photo.getBytes(1, (int) photo.length());
					response.setContentType("image/jpeg");

					oImage = response.getOutputStream();
					oImage.write(barray);
					oImage.flush();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (oImage != null) {
						oImage.close();
					}
				}
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
