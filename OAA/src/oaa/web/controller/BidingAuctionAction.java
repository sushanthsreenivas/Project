package oaa.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import oaa.web.entities.Auction;
import oaa.web.model.BidingBean;

public class BidingAuctionAction extends Action {

	// private static final String FAILURE = "failure";
	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof BidingBean) {

			BidingBean auction = (BidingBean) form;

			HttpSession session = request.getSession(false);
			//Collection<Auction> auctionList = auction.getListAuction();
			//session.setAttribute("AuctionList", auctionList);

		}
		return mapping.findForward(SUCCESS);

	}

}
