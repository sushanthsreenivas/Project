package oaa.web.controller;

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

	private static final String FALIURE = "failure";
	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (form instanceof BidingBean) {

			ProductBean retrive = (ProductBean) form;
			boolean status = false;
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user_id");
			int user_id = Integer.parseInt(userid);

			retrive.getListProducts(user_id);
		}

		return null;

	}

}
