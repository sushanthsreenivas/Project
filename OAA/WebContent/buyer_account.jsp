<%@ include file="header.jsp"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li>My account</li>
				</ul>

			</div>

			<div class="col-md-3">
				<!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
				<div class="panel panel-default sidebar-menu">

					<div class="panel-heading">
						<h3 class="panel-title">Buyer section</h3>
					</div>

					<div class="panel-body">

						<ul class="nav nav-pills nav-stacked">
							<li><a href="mybiding.jsp"><i class="fa fa-list"></i> My
									Bidings</a></li>

							<li class="active"><a href="buyer_account.jsp"><i
									class="fa fa-user"></i> My account</a></li>
							<li><a href="index.jsp"><i class="fa fa-sign-out"></i>
									Logout</a></li>
						</ul>
					</div>

				</div>
				<!-- /.col-md-3 -->
			</div>
			<!-- *** CUSTOMER MENU END *** -->
			<div class="col-md-9">
				<div class="box">
					<h1>My account</h1>
					<p class="lead">Change your personal details or your password
						here.</p>


					<h3>Change password</h3>

					<form >
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_old">Old password</label> <input
										type="password" class="form-control" id="password_old"
										name="password_old">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_1">New password</label> <input
										type="password" class="form-control" id="password_new"
										name="password_new">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_2">Retype new password</label> <input
										type="password" class="form-control" id="password_new1"
										name="password_new1">
								</div>
							</div>
						</div>
						<!-- /.row -->

						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-save"></i> Save new password
							</button>
						</div>
					</form>

					<hr>

					<h3>Personal details</h3>
					<form>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="firstname">Firstname</label> <input type="text"
										class="form-control" id="firstname" name="firstname">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="lastname">Lastname</label> <input type="text"
										class="form-control" id="lastname" name="lastname">
								</div>
							</div>
						</div>
						<!-- /.row -->

						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="Address">Address</label> <input type="text"
										class="form-control" id="address" name="address">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="city">City</label> <input type="text"
										class="form-control" id="city" name="city">
								</div>
							</div>
						</div>
						<!-- /.row -->
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="form-group">
									<label for="state">State</label> <select class="form-control"
										id="state" name="state"></select>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="form-group">
									<label for="country">Country</label> <select
										class="form-control" id="country" name="country"></select>
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group">
									<label for="mobile">Mobile no</label> <input type="number"
										class="form-control" id="mobile" name="mobile">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" id="email" name="email">
								</div>
							</div>
							<div class="col-sm-12 text-center">
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-save"></i> Save changes
								</button>

							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->
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