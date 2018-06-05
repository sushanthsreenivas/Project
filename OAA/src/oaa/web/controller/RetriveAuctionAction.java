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

import oaa.web.entities.Auction;
import oaa.web.model.AuctionBean;

public class RetriveAuctionAction extends Action implements Serializable {

	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (form instanceof AuctionBean) {

			AuctionBean auction = (AuctionBean) form;
			HttpSession session = request.getSession(false);

			Collection<Auction> auctionList = auction.getListAuction();
			session.setAttribute("AuctionList", auctionList);
			Collection<Auction> completedAuctionList = auction.getListCompletedAuction();
			session.setAttribute("CompletedAuctionList", completedAuctionList);
		}

		return mapping.findForward(SUCCESS);

	}
}
