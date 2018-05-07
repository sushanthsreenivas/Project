<%@ include file="header.jsp"%>
<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active"><a href="auction.do">Auction</a></li>
				</ul>
				<!--col-md-12 end-->
			</div>
			<div class="col-md-12" id="customer-order">
				<div class="box">
					<h1>Auction Details</h1>
					<hr>
					<div class="table-responsive">
						<table class="table">
							<div id="hot">
								<div class="box">
									<div class="container">
										<div class="col-md-10">
											<h2>Ongoing Auctions</h2>
										</div>
									</div>
								</div>

								<div class="container">
									<div class="col-md-10">
										<div class="product-slider">
											<%
												int index = -1;
											%>
											<c:forEach items="${sessionScope.AuctionList}" var="auction">
												<div class="item">
													<div class="product">
														<div class="flip-container">
															<div class="flipper">
																<div class="front">
																	<a href="detail.html"> <img
																		src="image?type=auction&index=<%=(++index)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
																<div class="back">
																	<a href="detail.html"> <img
																		src="image?type=auction&index=<%=(index)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
															</div>
														</div>
														<a href="initiateBid.do" class="invisible"> <img
															src="img/product1.jpg" alt="" class="img-responsive">
														</a>
														<div class="text">
															<h3>
																<a href="detail.html">${auction.productName}</a>
															</h3>

															<p class="price">&#8377;${auction.minBidPrice}</p>
															<p class="description">${auction.description }</p>
															<p class="date">Start Date - ${auction.startDate }</p>
															<p class="date">End Date - ${auction.endDate }</p>

														</div>
														<!-- /.text -->
													</div>
													<!-- /.product -->
												</div>
											</c:forEach>
										</div>
										<div class="owl-controls clickable">
											<div class="owl-pagination">
												<div class="owl-page active">
													<span class=""></span>
												</div>
												<div class="owl-page">
													<span class=""></span>
												</div>
											</div>
											<div class="owl-buttons">
												<div class="owl-prev">prev</div>
												<div class="owl-next">next</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</table>
					</div>
					<!-- /.container -->
					<div class="table-responsive">
						<table class="table">
							<div id="hot">
								<div class="box">
									<div class="container">
										<div class="col-md-10">
											<h2>Completed Auctions</h2>
										</div>
									</div>
								</div>
								<div class="container">
									<div class="col-md-10">
										<div class="product-slider">
											<%
												int value = -1;
											%>
											<c:forEach items="${sessionScope.CompletedAuctionList}"
												var="auction">
												<div class="item">
													<div class="product">
														<div class="flip-container">
															<div class="flipper">
																<div class="front">
																	<a href="detail.html"> <img
																		src="image?type=auction&index=<%=(++value)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
																<div class="back">
																	<a href="detail.html"> <img
																		src="image?type=auction&value=<%=(value)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
															</div>
														</div>
														<a href="initiateBid.do" class="invisible"> <img
															src="img/product1.jpg" alt="" class="img-responsive">
														</a>
														<div class="text">
															<h3>
																<a href="detail.html">${auction.productName}</a>
															</h3>
															<p class="price">&#8377;${auction.minBidPrice}</p>
															<p class="description">${auction.description }</p>
															<p class="date">Start Date - ${auction.startDate }</p>
															<p class="date">End Date - ${auction.endDate }</p>

														</div>
													</div>

												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</table>

					</div>
				</div>
				<!-- /#hot -->
			</div>

		</div>

		<!-- /#container end-->
	</div>
	<!-- end content -->
</div>

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>

<%@ include file="footer.jsp"%>