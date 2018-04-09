package oaa.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oaa.web.model.ProductBean;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.taglib.tiles.GetAttributeTag;

public class ProductAction extends Action {
	private static final String FALIURE = "success";
	private static final String SUCCESS = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// TODO Auto-generated method stub
		if (form instanceof ProductBean) {

			ProductBean pb = (ProductBean) form;
			boolean status = false;
			HttpSession session=request.getSession();
			System.out.println(session.getAttribute("user_id"));
			String userid= (String) session.getAttribute("user_id");
			int user_id = Integer.parseInt(userid);
		
			try {
				
				status = pb.addProduct(user_id);

			} catch (SQLException e) {
				// TODO Auto-generated catch block

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