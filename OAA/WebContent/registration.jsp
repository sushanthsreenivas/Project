<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ include file="header.jsp"%>

<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li>New account / Sign in</li>
				</ul>

			</div>

			<div class="col-md-12">
				<div class="box">
					<h1>New account</h1>

					<p class="lead">Not our registered customer yet?</p>
					<p>With registration with us new world of agriculture, No
						middlewares and much more opens to you! The whole process will not
						take you more than a minute!</p>
					<p class="text-muted">
						If you have any questions, please feel free to <a
							href="contact.html">contact us</a>, our customer service center
						is working for you 24/7.
					</p>

					<hr>

					<form action="processRegistration.do" method="post">
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="role">Role</label><span style="margin-left: 50px;"></span><input
										type="radio" id="role" name="role" value="farmer" required>
									Farmer <span style="margin-left: 90px"></span><input
										type="radio" id="role" name="role" value="buyer">Buyer
									<html:errors property="roleerrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">First name</label> <input type="text"
										class="form-control" id="fname" required name="firstname"
										value="kavya">
									<html:errors property="firstnameerrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">Last name</label> <input type="text"
										class="form-control" id="lname" required name="lastname"
										value="kavya">
									<html:errors property="lastnameerrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="email">Email</label> <input type="email"
										class="form-control" id="email" name="email_id" required
										value="kavya@gmail.com">
									<html:errors property="emailiderrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" id="password" name="passwd" required
										value="kavyapatil">
									<html:errors property="passwderrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="password">Confirm Password</label> <input
										type="password" class="form-control" id="cpassword"
										name="cpasswd" required value="kavyapatil">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="mobile">Mobile</label> <input type="tel"
										class="form-control" size="10" pattern="^\d{10}$" id="Mno"
										name="mobileno" placeholder="10-digits" required
										value="9876543211">
									<html:errors property="mobilenoerrmsg" />
								</div>
							</div>

						</div>


						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">Address</label> <input type="text"
										class="form-control" id="Address" required name="address"
										value="bangalore">
									<html:errors property="addresserrmsg" />
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">City</label> <input type="text"
										class="form-control" id="city" required name="city"
										value="bangalore">
									<html:errors property="cityerrmsg" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">State</label> <input type="text"
										class="form-control" id="state" required name="state"
										value="karnataka">
									<html:errors property="stateerrmsg" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">Pin Code</label> <input type="text"
										class="form-control" id="pin" required name="pincode"
										value="876545">
									<html:errors property="pincodeerrmsg" />
								</div>
							</div>
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-user-md"></i> Register
							</button>
						</div>
					</form>
				</div>
			</div>


			<!-- /.container -->
		</div>

	</div>
</div>
<!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->


<!--  For password and confirm password validation -->
<script type="text/javascript">
	window.onload = function() {
		var password = document.getElementById("password");
		var cpassword = document.getElementById("cpassword");
		password.onchange = ConfirmPassword;
		cpassword.onkeyup = ConfirmPassword;
		function ConfirmPassword() {
			cpassword.setCustomValidity("");
			if (password.value != cpassword.value) {
				cpassword.setCustomValidity("Passwords do not match.");
			}
		}
	}
</script>

<%@ include file="footer.jsp"%>