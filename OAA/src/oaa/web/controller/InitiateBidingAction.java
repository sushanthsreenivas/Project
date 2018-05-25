package oaa.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.model.BidingBean;

public class InitiateBidingAction extends Action {
	private static final String FAILURE = "failure";
	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof BidingBean) {

			BidingBean bidBean = (BidingBean) form;
			HttpSession session = request.getSession(false);
			String sUserId = (String) session.getAttribute("user_id");
			if (sUserId != null) {
				int userid = Integer.parseInt(sUserId);
				String pAuctionId = (String) request.getParameter("aid");
				int auctionid = Integer.parseInt(pAuctionId);

				bidBean.getBidDetails(auctionid, userid);

				return mapping.findForward(SUCCESS);
			}
			return mapping.findForward(FAILURE);
		}
		return mapping.findForward(FAILURE);
	}

}
