package oaa.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oaa.web.model.UserBean;

/**
 * Servlet implementation class ProcessRequestServlet
 */
@WebServlet("/process")
public class ProcessRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email_id = request.getParameter("email");
		String passwd = request.getParameter("passwd");

		if (email_id != null & passwd != null) {
			UserBean userBean = new UserBean();
			String[] result = userBean.validateLogin(email_id, passwd);

			if (result != null) {
				request.setAttribute("ub", userBean);
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(60 * 60 * 24 * 7);
				String user_id = result[0];
				session.setAttribute("user_id", user_id);

				String role = result[1];
				if (role.equals("Farmer")) {
					request.getRequestDispatcher("/farmer.jsp").forward(request, response);
				} else if (role.equals("Customer")) {
					request.getRequestDispatcher("/buyer.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/InvaidUser.jsp").forward(request, response);
				}

			} else {
				request.getRequestDispatcher("?flag=true").forward(request, response);
			}
		}
	}
}