<%@ include file="header.jsp"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>
					<li><a href="#">Bid</a></li>
				</ul>

			</div>
			<div class="col-md-9">

				<div class="row" id="productMain"></div>
				<div class="col-sm-8">
					<div class="box">
						<h1 class="text-center">Bid for ${param.pname}</h1>

						<html:form action="addBid" method="post">
							<html:hidden property="auctionid" />
							<html:hidden property="userid" />
							<p class="price">
								Last Bid Amount :
								<html:text property="lastBidAmount" styleId="last_bid"
									disabled="true" />
							</p>
							<p class="price">
								Minimum Bid increment :
								<html:text property="bidAmountIncrement" styleId="bid_inc"
									disabled="true" />
							</p>

							<p class="input">
								<label>Current Bid Amount:</label>
								<html:text property="bidAmount" styleId="cur_bid" />
							</p>
							<p class="text-center buttons">

								<html:submit styleClass="btn btn-primary" styleId="submit"
									disabled="true"> Bid</html:submit>

								<html:button styleClass="btn btn-default fa  fa-arrow-left"
									property="goBack" onclick="history.go(-1)">								
									Go Back</html:button>

							</p>
						</html:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/bidvalidate.js">
<!--
	
//-->
</script>
<%@ include file="footer.jsp"%>