<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>User Signup form</title>
		<!-- Font Icon -->
		<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
		<!-- Main css -->
		<link rel="stylesheet" href="css/style.css">
	</head>

	<body>
		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
						<form action="UserController" method="POST">
							<div class="form-group">
								<label for="firstname">
									<i class="zmdi zmdi-account material-icons-name"></i>
								</label> 
								<input
									type="text" name="firstname" id="firstname"
									pattern="[A-Za-z]{3,8}" title="Firstname must be inbetween 3 to 8 characters"
									placeholder="Your Firstname" autocomplete="off"
									onkeypress="return (event.charCode > 64 && 
									event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" required/>
							</div>
							<div class="form-group">
								<label for="lastname">
									<i class="zmdi zmdi-account material-icons-name"></i>
								</label>
								<input
									type="text" name="lastname" id="lastname"
									pattern="[A-Za-z]{3,8}" title="lastname must be inbetween 3 to 8 characters"
									onkeypress="return (event.charCode > 64 && 
									event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)"
									placeholder="Your lastname" autocomplete="off" required/>
							</div>
							<div class="form-group">
								<label for="email">
									<i class="zmdi zmdi-email"></i>
								</label> 
								<input type="email" name="email" id="email" placeholder="Your Email"
									title = "Enter the vaild email" autocomplete="off" required/>
							</div>
							<div class="form-group">
								<label for="pass">
									<i class="zmdi zmdi-lock"></i>
								</label>
								<input
									type="password" name="password" id="password" placeholder="Password" 
									pattern = "(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									title="Must contain at least one number,one special character and
									 one uppercase and lowercase letter, and at least 8 or more characters"
									autocomplete="off" required/>
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="action" id="submitbtn"
									class="form-submit" value="signup"/>
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="signup.jsp" class="signup-image-link">Join our team</a>
					</div>
				</div>
			</div>
		</section>
		<!-- JS -->
		<script src="vendor/jquery/jquery.min.js"></script>
	</body>

</html>