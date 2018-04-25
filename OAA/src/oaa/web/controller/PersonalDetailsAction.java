package oaa.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.MyAccountBean;

public class PersonalDetailsAction extends Action {
	private static final String FALIURE = "failure";
	private static final String SUCCESS = "success";
	

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (form instanceof MyAccountBean) {
			MyAccountBean mab = (MyAccountBean) form;
			boolean status = false;
			try {
				status = mab.updatedetails();

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
