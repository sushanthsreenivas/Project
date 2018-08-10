<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<%-- 									<html:errors property="roleerrmsg" /> --%>
									<form:errors path="roleerrmsg" cssClass="error"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">First name</label> <input type="text"
										class="form-control" id="fname" required name="firstname"
										value="kavya">
									<%-- <html:errors property="" />--%>
									<form:errors path="firstnameerrmsg" cssClass="error"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">Last name</label> <input type="text"
										class="form-control" id="lname" required name="lastname"
										value="kavya">
<%-- 									<html:errors property="lastnameerrmsg" /> --%>
									<form:errors path="lastnameerrmsg" cssClass="error"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="email">Email</label> <input type="email"
										class="form-control" id="email" name="email_id" required
										value="kavya@gmail.com">
<%-- 									<html:errors property="emailiderrmsg" /> --%>
									<form:errors path="emailiderrmsg" cssClass="error"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" id="password" name="passwd" required
										value="kavyapatil">
<%-- 									<html:errors property="passwderrmsg" /> --%>
										<form:errors path="passwderrmsg" cssClass="error"/>
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
<%-- 									<html:errors property="mobilenoerrmsg" /> --%>
									<form:errors path="mobilenoerrmsg" cssClass="error"/>
								</div>
							</div>

						</div>


						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">Address</label> <input type="text"
										class="form-control" id="Address" required name="address"
										value="bangalore">
<%-- 									<html:errors property="addresserrmsg" /> --%>
									<form:errors path="addresserrmsg" cssClass="error"/>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">City</label> <input type="text"
										class="form-control" id="city" required name="city"
										value="bangalore">
<%-- 									<html:errors property="cityerrmsg" /> --%>
									<form:errors path="cityerrmsg" cssClass="error"/>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="name">State</label> <select class="form-control"
										name="state">
										<option value="">------------Select State------------</option>
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
										<option value="Karnataka">Karnataka</option>
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
<%-- 									<html:errors property="pincodeerrmsg" /> --%>
									<form:errors path="pincodeerrmsg" cssClass="error"/>
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
		</div>

	</div>
</div>

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