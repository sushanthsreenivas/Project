package oaa.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.ProductBean;

public class ProductRemoveAction extends Action {
	private static final String FALIURE = "failure";
	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof ProductBean) {

			ProductBean pb = (ProductBean) form;
			boolean status = false;
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user_id");
			int user_id = Integer.parseInt(userid);
			try {
				status = pb.RemoveProduct(user_id);

			} catch (SQLException e) {
				e.printStackTrace();
				return mapping.findForward(FALIURE);
			}
			if (status == true) {
				return mapping.findForward(SUCCESS);
			}
		}

		return mapping.findForward(FALIURE);
	}

}
