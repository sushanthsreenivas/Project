<%@ include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li>Registered</li>
				</ul>

			</div>
			<div class="col-md-12">


				<div class="box" id="contact">
					<h3>
						Thank you
						<bean:write name="URB" property="firstname" />
						for registering.... Please Login
					</h3>

					<p class="lead">

						<!-- Are you curious about something? Do you have
						some kind of problem with our products?</p>
					<p>Please feel free to contact us, our customer service center
						is working for you 24/7.

					<hr>  -->
					</p>
					<div class="row">
						<div class="col-sm-4">
							<h3>
								<i class="fa fa-map-marker"></i> Address
							</h3>
							<p>
								13/25 New Avenue <br>New Heaven <br>45Y 73J <br>karnataka
								<br> <strong>India</strong>
							</p>
						</div>
						<!-- /.col-sm-4 -->
						<div class="col-sm-4">
							<h3>
								<i class="fa fa-phone"></i> Call center
							</h3>
							<p class="text-muted">This number is toll free if calling
								from India otherwise we advise you to use the electronic form of
								communication.</p>
							<p>
								<strong>+91 555 444 333</strong>
							</p>
						</div>
						<!-- /.col-sm-4 -->
						<div class="col-sm-4">
							<h3>
								<i class="fa fa-envelope"></i> Electronic support
							</h3>
							<p class="text-muted">Please feel free to write an email to
								us</p>
							<ul>
								<li><strong><a href="mailto:">oaa@gmail.com</a></strong></li>
							</ul>
						</div>
						<!-- /.col-sm-4 -->
					</div>
					<!-- /.row -->

					<hr>

					<div id="map">
						<img src="img/rvce1.png" alt="rvce">
					</div>

					<hr>
				</div>
			</div>
			<!-- /.container -->
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