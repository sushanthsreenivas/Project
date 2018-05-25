<%@ include file="header.jsp"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>

					<li>Buyer</li>
				</ul>

			</div>

			<div class="col-md-3">

				<div class="panel panel-default sidebar-menu">

					<div class="panel-heading">
						<h3 class="panel-title">Buyer section</h3>
					</div>

					<div class="panel-body">

						<ul class="nav nav-pills nav-stacked">
							<li><a href="addbid.do"><i class="fa fa-list"></i>Bid</a></li>

							<li class="active"><a href="updatebid.do"><i
									class="fa fa-list"></i> Manage Bid</a></li>

							<li><a href="index.jsp"><i class="fa fa-sign-out"></i>
									Logout</a></li>
						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-9">

				<ul class="breadcrumb">
					<li><a href="buyer.jsp">Home</a></li>
					<li>My Bidings</li>
				</ul>

			</div>

			<div class="col-md-9" id="customer-order">
				<div class="box">
					<h1>Biding Details</h1>
					<!-- /.container -->
					<div class="table-responsive">
						<table class="table">
							<div id="hot">

								<div class="box">
									<div class="container">
										<div class="col-md-8">
											<h2>Manage your Bidings Here</h2>
										</div>
									</div>
								</div>

								<html:form action="bidupdate.do" enctype="multipart/form-data">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">

												<label for="auction Id">AuctionId</label>

												<html:text styleClass="form-control" styleId="auctionid"
													property="auctionid" />

											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="Bid Price">Bid Price</label>
												<html:text styleClass="form-control" styleId="bidprice"
													property="bidprice" />

											</div>
										</div>
									</div>
									<div class="col-sm-12 text-center">
										<button type="submit" class="btn btn-primary">

											<i class="fa fa-save"></i> Save

										</button>
									</div>
								</html:form>
							</div>
						</table>
					</div>
					<!-- /.table-responsive -->
					<hr>

					<div class="table-responsive">
						<table class="table">
							<div class="hot">

								<div class="box">
									<div class="container">
										<div class="col-md-8">
											<h2>Your Bidings</h2>
										</div>
									</div>
								</div>

								<div class="container">
									<div class="col-md-8">
										<div class="product-slider">
											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product1.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product1.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product1.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Beans</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->
												</div>
												<!-- /.product -->
											</div>


											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product3.jpeg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product3.jpeg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product3.jpeg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Tomato</a>
														</h3>
														<p class="price">
															<!-- <del>&#8377;280</del> -->
															&#8377;143.00
														</p>
													</div>
													<!-- /.text -->

													<div class="ribbon sale">

														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->

													<div class="ribbon new">

														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->

													<div class="ribbon gift">

														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->
												</div>
												<!-- /.product -->
											</div>

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product4.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product4.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product4.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Cherry</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->
												</div>
												<!-- /.product -->
											</div>

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product2.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product2.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product2.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Carrot</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->
												</div>
												<!-- /.product -->
											</div>

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product5.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product5.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product5.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Apple</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->

													<div class="ribbon new">
														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->
												</div>
												<!-- /.product -->
											</div>

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product6.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product6.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product6.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Banana</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->

													<div class="ribbon gift">
														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->

												</div>
												<!-- /.product -->
											</div>
											<!-- /.col-md-4 -->

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product7.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product7.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product7.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Maize</a>
														</h3>
														<p class="price">
															<!-- <del>&#8377;280</del> -->
															&#8377;143.00
														</p>
													</div>
													<!-- /.text -->

													<div class="ribbon sale">
														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->

													<div class="ribbon new">
														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->

													<div class="ribbon gift">
														<div class="ribbon-background"></div>
													</div>
													<!-- /.ribbon -->
												</div>
												<!-- /.product -->
											</div>

											<div class="item">
												<div class="product">
													<div class="flip-container">
														<div class="flipper">
															<div class="front">
																<a href="detail.html"> <img src="img/product8.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
															<div class="back">
																<a href="detail.html"> <img src="img/product8.jpg"
																	alt="" class="img-responsive">
																</a>
															</div>
														</div>
													</div>
													<a href="detail.html" class="invisible"> <img
														src="img/product8.jpg" alt="" class="img-responsive">
													</a>
													<div class="text">
														<h3>
															<a href="detail.html">Red Lentils</a>
														</h3>
														<p class="price">&#8377;143.00</p>
													</div>
													<!-- /.text -->
												</div>
												<!-- /.product -->

											</div>
										</div>

									</div>
									<!-- /.product-slider -->
								</div>
								<!-- /.container -->

							</div>

						</table>
					</div>
					<!-- /.table-responsive -->


				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>