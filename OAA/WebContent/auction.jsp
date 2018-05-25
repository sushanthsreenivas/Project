<%@ include file="header.jsp"%>
<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>
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
										<div class="product-slider" id="owl-demo">
											<%
												int index = -1;
											%>
											<c:forEach items="${sessionScope.AuctionList}" var="auction">
												<div class="item">
													<div class="product">
														<div class="flip-container">
															<div class="flipper">
																<div class="front">
																	<a href="" data-target="#login-modal"> <img
																		src="image?type=auction&index=<%=(++index)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
																<div class="back">
																	<a href="#"> <img
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
															<h3 id="gologin">
																<a href="">${auction.productName}</a>
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
																	<a href="#"> <img
																		src="image?type=auction&value=<%=(++value)%>" alt=""
																		class="img-responsive">
																	</a>
																</div>
																<div class="back">
																	<a href="#"> <img
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
																<a href="#">${auction.productName}</a>
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

			</div>
		</div>

		<!-- /#container end-->
	</div>
	<!-- end content -->
</div>

<script>
	$(document).ready(function() {
		$("#gologin").click(function() {
			$("#login-modal").modal();
		});
		$(".flipper").click(function() {
			$("#login-modal").modal();
		})
	});
</script>
<%@ include file="footer.jsp"%>