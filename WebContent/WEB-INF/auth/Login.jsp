<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Login</title>
</head>
<body>
	
	<div class="container">
		<h1 class="display-1">Login</h1>
		<form action="Login" method="post">
		<!-- <form method="post"> -->
			<div class="form-group">
    				<label for="email">E-mail Address</label>
    				<input class="form-control" type="email" name="email" id="email" placeholder="Enter your e-mail address">
    			</div>
    			<div class="form-group">
    				<label for="password">Password</label>
    				<input class="form-control" type="password" name="password" id="password" placeholder="Enter your password">
    			</div>
    			<div class="form-group">
    				<button type="submit" class="btn btn-primary">Login</button>
    			</div>
    		</form>
    		<p>Don't have an account? <a href="Register">Sign-Up!</a></p>
	</div>
</body>
</html>