package oaa.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.LaunchAuctionBean;

public class LaunchAuctionAction extends Action {

	private static final String FALIURE = "failure";
	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof LaunchAuctionBean) {

			LaunchAuctionBean launch = (LaunchAuctionBean) form;

			boolean status = false;

			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user_id");
			if (userid != null) {
				int user_id = Integer.parseInt(userid);

				status = launch.launchAuction(user_id);
				if (status == true) {
					return mapping.findForward(SUCCESS);
				}
			}
		}
		return mapping.findForward(FALIURE);
	}
}
