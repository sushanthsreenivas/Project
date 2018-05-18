<%@ include file="header.jsp"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="home.do">Home</a></li>
					<li>Farmer</li>
					<li>My account</li>
				</ul>

			</div>

			<div class="col-md-3">
				<div class="panel panel-default sidebar-menu">

					<div class="panel-heading">
						<h3 class="panel-title">Farmer section</h3>
					</div>

					<div class="panel-body">

						<ul class="nav nav-pills nav-stacked">
							<li><a href="myproducts.do"><i class="fa fa-list"></i>
									My Products</a></li>

							<li class="active"><a href="farmeracc.do"><i
									class="fa fa-user"></i> My Account</a></li>
							<li><a href="index.jsp"><i class="fa fa-sign-out"></i>
									Logout</a></li>
						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-9">
				<div class="box">
					<h1>My account</h1>
					<p class="lead">Change your personal details or your password
						here.</p>


					<h3>Change password</h3>

					<form action="Account.do" method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_old">Old password</label> <input
										type="password" class="form-control" id="password_old"
										required name="password_old" value="kavya">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_1">New password</label> <input
										type="password" class="form-control" id="password_new"
										required name="password_new" value="kavyapatil">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="password_2">Retype new password</label> <input
										type="password" class="form-control" id="password_new1"
										required name="password_new1" value="kavyapatil">
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
					<form action="Account.do" method="post" name="validate"
						onsubmit="return validateForm()">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="firstname">Firstname</label> <input type="text"
										class="form-control" id="firstname" required name="firstname"
										value="kavya">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="lastname">Lastname</label> <input type="text"
										class="form-control" id="lastname" required name="lastname"
										value="patil">
								</div>
							</div>
						</div>
						<!-- /.row -->

						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="Address">Address</label> <input type="text"
										class="form-control" id="address" required name="address"
										value="rajajinagar">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="city">City</label> <input type="text"
										class="form-control" id="city" required name="city"
										value="bangalore">
								</div>
							</div>
						</div>
						<!-- /.row -->
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="form-group">
									<label for="state">State</label> <select class="form-control"
										id="state" name="state">
										<option value=""></option>
										<option value="Andaman and Nicobar Islands">Andaman
											and Nicobar Islands</option>
										<option value="Andhra Pradesh">Andhra Pradesh</option>
										<option value="Arunachal Pradesh">Arunachal Pradesh</option>
										<option value="Assam">Assam</option>
										<option value="Bihar">Bihar</option>
										<option value="Chandigarh">Chandigarh</option>
										<option value="Chhattisgarh">Chhattisgarh</option>
										<option value="Dadra and Nagar Haveli">Dadra and
											Nagar Haveli</option>
										<option value="Daman and Diu">Daman and Diu</option>
										<option value="Delhi">Delhi</option>
										<option value="Goa">Goa</option>
										<option value="Gujarat">Gujarat</option>
										<option value="Haryana">Haryana</option>
										<option value="Himachal Pradesh">Himachal Pradesh</option>
										<option value="Jammu and Kashmir">Jammu and Kashmir</option>
										<option value="Jharkhand">Jharkhand</option>
										<option selected="selected" value="Karnataka">Karnataka</option>
										<option value="Kerala">Kerala</option>
										<option value="Lakshadweep">Lakshadweep</option>
										<option value="Madhya Pradesh">Madhya Pradesh</option>
										<option value="Maharashtra">Maharashtra</option>
										<option value="Manipur">Manipur</option>
										<option value="Meghalaya">Meghalaya</option>
										<option value="Mizoram">Mizoram</option>
										<option value="Nagaland">Nagaland</option>
										<option value="Orissa">Orissa</option>
										<option value="Pondicherry">Pondicherry</option>
										<option value="Punjab">Punjab</option>
										<option value="Rajasthan">Rajasthan</option>
										<option value="Sikkim">Sikkim</option>
										<option value="Tamil Nadu">Tamil Nadu</option>
										<option value="Tripura">Tripura</option>
										<option value="Uttaranchal">Uttaranchal</option>
										<option value="Uttar Pradesh">Uttar Pradesh</option>
										<option value="West Bengal">West Bengal</option>
									</select>
								</div>
							</div>


							<div class="col-sm-6">
								<div class="form-group">
									<label for="mobile">Mobile no</label> <input type="tel"
										class="form-control" id="telNo" required name="telNo"
										maxlength="10" value="9632324115">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" id="email" required name="email"
										value="kavyapatil@gmail.com">
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
</div>
<!-- /#content -->



<%@ include file="footer.jsp"%>