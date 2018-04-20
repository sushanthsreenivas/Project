/**
 * 
 */
package oaa.web.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.UserRegBean;

public class RegistrationAction extends Action {

	private static final String SUCCESS = "success";
	private static final String FALIURE = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (form instanceof UserRegBean) {
			UserRegBean urb = (UserRegBean) form;
			boolean status = false;
			try {
				status = urb.registerUser();

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
