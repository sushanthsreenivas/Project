<%@page import="java.util.Calendar"%>
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
												<label for="product_name">Product Name</label> <select
													class="form-control" id="productName" name="productName">
													<c:forEach items="${sessionScope.productList}"
														var="product">
														<option value="${product.productId}">${product.productName}</option>
													</c:forEach>
												</select>


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
												<%
													Calendar calendar = Calendar.getInstance();

													// get a date to represent "today"
													java.util.Date start_date = calendar.getTime();
													calendar.add(Calendar.DAY_OF_YEAR, 1);

													// now get "tomorrow"
													java.util.Date end_date = calendar.getTime();
													java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
												%><input class="form-control" id="datepicker" type="text"
													value="<%=df.format(start_date)%>" name="startDate" required>
											</div>

										</div>

										<div class="col-sm-6">
											<div class="form-group">
												<label for="end date">End Date</label> <input type="text"
													class="form-control" id="datepicker" name="endDate"
													value="<%=df.format(end_date)%>" required>

											</div>
										</div>
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
										<button type="submit" id="submit" class="btn btn-primary">
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

<%@ include file="footer.jsp"%>