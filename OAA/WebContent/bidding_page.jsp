<%@ include file="header.jsp"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Login</a></li>
					<li><a href="#">Buyer</a></li>
					<li>Bid</li>
				</ul>

			</div>
			<div class="col-md-9">

				<div class="row" id="productMain">
					<!-- <div class="col-sm-6">
						<div id="mainImage">
							<img src="img/product9.jpg" alt="" class="img-responsive">
						</div>
					</div> -->
				</div>
				<div class="col-sm-6">
					<div class="box">
						<h1 class="text-center">Bid for ${param.pname}</h1>


						<p class="price">Current Bid Amount :
							$${requestScope.BB.lastBidAmount}/p>
						<p class="price">Minimum Bid increment :
							$${requestScope.BB.bidAmountIncrement}</p>

						<p class="input">
							<label>Bid Amount:</label> <input type="text" value="bid amount"
								name="bidAmount" id="bidAmount">
						</p>
						<p class="text-center buttons">

							<a href="addBid.do" class="btn btn-primary"><i
								class="fa  fa-rupee-sign"></i> Bid</a> <a
								href="javascript:history.go(-1)" class="btn btn-default"><i
								class="fa  fa-arrow-left"></i> Go Back</a>
						</p>

				</div>
				</div>

				<div class="col-sm-7" id="details">
					<p>
					<h4>Details</h4>
					<hr>

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