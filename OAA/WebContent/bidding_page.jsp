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
				<div class="col-sm-6">
					<div class="box">
						<h1 class="text-center">Bid for ${param.pname}</h1>

						<html:form action="addBid">
							<html:hidden property="auctionid" />
							<html:hidden property="userid" />
							<p class="price">
								Current Bid Amount :
								<html:text property="lastBidAmount" disabled="true" />
							</p>
							<p class="price">
								Minimum Bid increment :
								<html:text property="bidAmountIncrement" disabled="true" />
							</p>

							<p class="input">
								<label>Bid Amount:</label>
								<html:text property="bidAmount" />
							</p>
							<p class="text-center buttons">

								<html:submit styleClass="btn btn-primary"> Bid</html:submit>
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

<script src="js/bidvalidate"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>
<%@ include file="footer.jsp"%>