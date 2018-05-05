<%@ include file="header.jsp"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%><div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>

					<li>Farmer</li>
				</ul>

			</div>

			<div class="col-md-3">
				<!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
				<div class="panel panel-default sidebar-menu">

					<div class="panel-heading">
						<h3 class="panel-title">Farmer section</h3>
					</div>

					<div class="panel-body">

						<ul class="nav nav-pills nav-stacked">
							<li><a href="addproduct.do"><i class="fa fa-list"></i>
									Add Products</a></li>

							<li class="active"><a href="updateproduct.do"><i
									class="fa fa-list"></i> Manage Products</a></li>
							<li><a href="removeproduct.do"><i class="fa fa-list"></i>
									Remove Products</a></li>
							<li><a href="index.jsp"><i class="fa fa-sign-out"></i>
									Logout</a></li>
						</ul>
					</div>

				</div>
				<!-- /.col-md-3 -->
			</div>
			<!-- *** CUSTOMER MENU END *** -->
			<div class="col-md-9">

				<ul class="breadcrumb">
					<li><a href="farmer.jsp">Home</a></li>
					<li>My Products</li>
				</ul>


			</div>

			<div class="col-md-9" id="customer-order">
				<div class="box">
					<h1>Product Details</h1>

					<hr>
					<div class="table-responsive">
						<table class="table">
							<div id="hot">
								<div class="box">
									<div class="container">
										<div class="col-md-8">
											<h2>Manage Your Product Here</h2>
										</div>
									</div>
								</div>
								<html:form action="productupdate.do"
									enctype="multipart/form-data">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">

												<label for="product_name">Product Id</label>
												<html:text styleClass="form-control" styleId="productName"
													property="productId" />
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="category">Category</label>
												<html:select styleClass="form-control" styleId="category"
													property="category">
													<c:forEach items="${sessionScope.CB.categories}"
														var="category">
														<html:option value="${category.categoryId}">${category.categoryName}</html:option>
													</c:forEach>
												</html:select>
												<%-- 												<html:text styleClass="form-control" styleId="category" --%>
												<%-- 													property="category" /> --%>
											</div>
										</div>
									</div>
									<!-- /.row -->
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="description">Description</label>
												<html:text styleClass="form-control" styleId="description"
													property="description" />
											</div>
										</div>
										<div class="col-sm-6 ">
											<div class="form-group">
												<label for="photo">Photo</label>
												<html:file styleClass="form-control" styleId="photo"
													property="image" style="border: none" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="minBidprice">Minimum Bid price</label>
												<html:text styleClass="form-control" styleId="minBidPrice"
													property="minBidPrice" />
											</div>
										</div>
									</div>
									<!-- /.row -->

									<div class="col-sm-12 text-center">
										<button type="submit" class="btn btn-primary">
											<i class="fa fa-save">Update Product</i>
										</button>
									</div>
								</html:form>
							</div>
						</table>
					</div>

					<div class="table-responsive">
						<table class="table">
							<div id="hot">

								<div class="box">
									<div class="container">
										<div class="col-md-8">
											<h2>Your Products</h2>
										</div>
									</div>
								</div>

								<div class="container">
									<div class="col-md-8">
										<div class="product-slider">
											<c:forEach items="${sessionScope.productList}" var="product">
												<div class="item">
													<div class="product">
														<div class="flip-container">
															<div class="flipper">
																<div class="front">
																	<a href="detail.html"> <img src="${product.photo}"
																		alt="" class="img-responsive">
																	</a>
																</div>
																<div class="back">
																	<a href="detail.html"> <img src="${product.photo}"
																		alt="" class="img-responsive">
																	</a>
																</div>
															</div>
														</div>
														<a href="detail.html" class="invisible"> <img
															src="${product.photo}" alt="" class="img-responsive">
														</a>
														<div class="text">
															<h3>
																<a href="detail.html">${product.productName}</a>
															</h3>
															<p class="price">$${product.minBidPrice}</p>
														</div>
														<!-- /.text -->
													</div>
													<!-- /.product -->
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- /.product-slider -->
							</div>
							<!-- /.container -->

						</table>
					</div>
					<!-- /.container -->

				</div>
			</div>
		</div>
	</div>
</div>

<!-- /#content -->
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>
<%@ include file="footer.jsp"%>