package oaa.web.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.entities.Product;
import oaa.web.model.ProductBean;

@SuppressWarnings("serial")
public class MyProductAction extends Action implements Serializable {
	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof ProductBean) {

			ProductBean myproduct = (ProductBean) form;
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user_id");
			if (userid != null) {
				int user_id = Integer.parseInt(userid);

				Collection<Product> productList = myproduct.getListProducts(user_id);
				session.setAttribute("productList", productList);

			}
		}
		return mapping.findForward(SUCCESS);

	}

}
