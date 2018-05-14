package oaa.web.view;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oaa.web.entities.Auction;
import oaa.web.entities.Product;

@WebServlet("/image")
public class ImageProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ImageProcessing() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "nostore");

		HttpSession session = request.getSession(false);
		if (session != null) {

			String strIndex = request.getParameter("index");
			if (strIndex != null) {
				int index = Integer.parseInt(strIndex);
				String type = request.getParameter("type");
				if (type != null) {
					if (type.equals("product")) {
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

								e.printStackTrace();
							} finally {
								if (oImage != null) {
									oImage.close();
								}
							}
						}
					} else if (type.equals("auction")) {
						ArrayList<Auction> auctions = (ArrayList<Auction>)session.getAttribute("AuctionList");
						Auction auction = auctions.get(index);
						Blob photo = auction.getPhoto();
						if (photo != null) {
							ServletOutputStream oImage = null;
							try {
								byte barray[] = photo.getBytes(1, (int) photo.length());
								response.setContentType("image/jpeg");

								oImage = response.getOutputStream();
								oImage.write(barray);
								oImage.flush();
							} catch (SQLException e) {

								e.printStackTrace();
							} finally {
								if (oImage != null) {
									oImage.close();
								}
							}
						}

					}
				}

			}

			String strval = request.getParameter("value");
			if (strval != null) {
				int value = Integer.parseInt(strval);
				String type = request.getParameter("type");
				if (type != null) {
					if (type.equals("auction")) {
						ArrayList<Auction> completedAuction = (ArrayList<Auction>) session
								.getAttribute("CompletedAuctionList");
						Auction completedauction = completedAuction.get(value);

						Blob cphoto = completedauction.getPhoto();
						if (cphoto != null) {
							ServletOutputStream oImage = null;
							try {
								byte barray[] = cphoto.getBytes(1, (int) cphoto.length());
								response.setContentType("image/jpeg");

								oImage = response.getOutputStream();
								oImage.write(barray);
								oImage.flush();
							} catch (SQLException e) {

								e.printStackTrace();
							} finally {
								if (oImage != null) {
									oImage.close();
								}
							}
						}
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

	}

}
