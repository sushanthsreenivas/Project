<%@ include file="header.jsp"%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<div id="all">
	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>
					<li>Launch Auction</li>
				</ul>
			</div>
			<div class="col-md-12" id="customer-order">
				<div class="box">
					<h1>Create Auction</h1>
					<hr>

					<div class="table-responsive">
						<table class="table">
							<div id="hot">
								<div class="box">
									<div class="container">
										<div class="col-md-8">
											<h2>create new auction</h2>
										</div>
									</div>
								</div>
								<form action="createauction.do" enctype="multipart/form-data">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="product_name">Product Id</label> <input
													class="form-control" id="productId" name="productId"
													required />

											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="product_name">Description</label> <input
													class="form-control" id="description" name="description" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="start date">Start Date</label>
												<%-- <html:text styleClass="form-control" styleId="datepicker"
													property="startDate" /> --%>
												<input class="form-control" id="datepicker" type="date"
													name="startDate" required>
											</div>

										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="end date">End Date</label> <input type="date"
													class="form-control" id="datepicker" name="endDate"
													required>

											</div>
										</div>
										<script>
											$('input[type=date]').datepicker({
												// Consistent format with the HTML5 picker
												dateFormat : 'yy-mm-dd'
											});
										</script>
									</div>
									<!-- /.row -->
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="Bid_Amount_increment"> Bid Amount
													Increment</label> <input class="form-control"
													id=" bidPriceIncrement" name="bidPriceIncrement" required />
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="minBidprice">Minimum Bid Price</label> <input
													class="form-control" id="bidPrice" name="bidPrice" required />
											</div>
										</div>
									</div>
									<!-- /.row -->

									<div class="col-sm-12 text-center">
										<button type="submit" class="btn btn-primary">
											<i class="fa fa-save"></i> Add Product
										</button>
									</div>
								</form>
							</div>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
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