package oaa.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.BidingBean;
import oaa.web.model.ProductBean;

public class RetriveAction extends Action {

	private static final String FALIURE = "success";
	private static final String SUCCESS = "failure";

	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (form instanceof BidingBean) {

			ProductBean retrive = (ProductBean) form;
			boolean status = false;
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("user_id"));
			String userid = (String) session.getAttribute("user_id");
			int user_id = Integer.parseInt(userid);

			retrive.listProducts(user_id);
		}

		return null;

	}

}
