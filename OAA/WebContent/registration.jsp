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

			<!--               <div class="col-md-6">
                    <div class="box">
                        <h1>Login</h1>

                        <p class="lead">Already our customer?</p>
                        <p class="text-muted">Please have your valuable time in utilising the time in some useful process </p>

                        <hr>

                        <form action="navig?pg=logn" method="get">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </div>
                        </form>
                    </div>
                </div>


            </div> -->
			<!-- /.container -->
		</div>
		<!-- /#content -->


		<!-- *** FOOTER ***
 _________________________________________________________ -->
		<!--       <div id="footer" data-animate="fadeInUp">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <h4>Pages</h4>

                        <ul>
                            <li><a href="text.html">About us</a>
                            </li>
                            <li><a href="text.html">Terms and conditions</a>
                            </li>
                            <li><a href="faq.html">FAQ</a>
                            </li>
                            <li><a href="contact.html">Contact us</a>
                            </li>
                        </ul>

                        <hr>

                        <h4>User section</h4>

                        <ul>
                            <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register.html">Regiter</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg hidden-sm">

                    </div>
                    <!-- /.col-md-3 -->

		<!--                    <div class="col-md-3 col-sm-6">

                        <h4>Top categories</h4>

                        <h5>Men</h5>

                        <ul>
                            <li><a href="category.html">T-shirts</a>
                            </li>
                            <li><a href="category.html">Shirts</a>
                            </li>
                            <li><a href="category.html">Accessories</a>
                            </li>
                        </ul>

                        <h5>Ladies</h5>
                        <ul>
                            <li><a href="category.html">T-shirts</a>
                            </li>
                            <li><a href="category.html">Skirts</a>
                            </li>
                            <li><a href="category.html">Pants</a>
                            </li>
                            <li><a href="category.html">Accessories</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->

		<!--                    <div class="col-md-3 col-sm-6">

                        <h4>Where to find us</h4>

                        <p><strong>Obaju Ltd.</strong>
                            <br>13/25 New Avenue
                            <br>New Heaven
                            <br>45Y 73J
                            <br>England
                            <br>
                            <strong>Great Britain</strong>
                        </p>

                        <a href="contact.html">Go to contact page</a>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->



		<!--                    <div class="col-md-3 col-sm-6">

                        <h4>Get the news</h4>

                        <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>

                        <form>
                            <div class="input-group">

                                <input type="text" class="form-control">

                                <span class="input-group-btn">

			    <button class="btn btn-default" type="button">Subscribe!</button>

			</span>

                            </div>
                            <!-- /input-group -->
		<!--                        </form>

                        <hr>

                        <h4>Stay in touch</h4>

                        <p class="social">
                            <a href="#" class="facebook external" data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
                            <a href="#" class="twitter external" data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
                            <a href="#" class="instagram external" data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
                            <a href="#" class="gplus external" data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
                            <a href="#" class="email external" data-animate-hover="shake"><i class="fa fa-envelope"></i></a>
                        </p>


                    </div>
                    <!-- /.col-md-3 -->

		<!--                </div> 
                <!-- /.row -->

		<!--          -->
	</div>
	<!-- /.container -->
	<!--      -->
</div>
<!-- /#footer -->

<!-- *** FOOTER END *** -->




<!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>

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

