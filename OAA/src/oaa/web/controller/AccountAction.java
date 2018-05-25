package oaa.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.AccountBean;

public class AccountAction extends Action {
	private static final String FALIURE = "failure";
	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (form instanceof AccountBean) {

			AccountBean account = (AccountBean) form;
			boolean status = false;

			HttpSession session = request.getSession(false);

			String userid = (String) session.getAttribute("user_id");
			String role = (String) session.getAttribute("role");
			int user_id = Integer.parseInt(userid);
			String passwd =request.getParameter("password_old");
			String firstname =request.getParameter("firstname");

			if (role.equals("farmer")) {
				status = check(account, passwd, firstname, user_id);
			} else if (role.equals("buyer")) {
				status = check(account, passwd, firstname, user_id);
			}

			if (status == true) {
				return mapping.findForward(SUCCESS);
			}
		}
		return mapping.findForward(FALIURE);

	}

	boolean check(AccountBean account, String passwd, String firstname, int user_id) {

		try {
			boolean status = false;

			if (passwd != null) {

				status = account.updatepassword(user_id);

			}

			else if (firstname != null) {
				status = account.updatedetails(user_id);

			}
			if (status = true) {
				return true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
