<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Register</title>
</head>
<body>
	<div class="container">
		<h1 class="display-1">Register</h1>
		
		<form action="Register" method="post">
		
			<div class="form-group">
				<label for="name">Full Name</label>
				<c:choose>
					<c:when test="${not empty nameError}">
						<input class="form-control is-invalid" name="name" value="${name}" type="text" id="name" placeholder="Enter your first and last names">
						<div class="invalid-feedback">${nameError}</div>
					</c:when>
					<c:otherwise>
						<input class="form-control" type="text" name="name" value="${name}" id="name" placeholder="Enter your first and last names">
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="form-group">
				<label for="email">E-mail Address</label>
					<c:choose>
					<c:when test="${not empty emailError}">
						<input class="form-control is-invalid" name="email" value="${email}" type="email" id="email" placeholder="Enter your e-mail address">
						<div class="invalid-feedback">${emailError }</div>
					</c:when>
					<c:otherwise>
						<input class="form-control" name="email" value="${email}" type="email" id="email" placeholder="Enter your e-mail address">
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<c:choose>
					<c:when test="${not empty passwordError}">
						<input class="form-control is-invalid" name="password1" type="password"  id="password1" placeholder="Enter your password">
						<div class="invalid-feedback">${passwordError}</div>
					</c:when>
					<c:otherwise>
						<input class="form-control" name="password1" type="password"  id="password1" placeholder="Enter your password">
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="form-group">
				<label for="password">Re-Enter Password</label>
				<input class="form-control" value="" type="password" name="password2" id="password2" placeholder="Re-enter your password">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
			
		</form>
		<p>Already have an account? <a href="Login">Login</a></p>
	</div>
</body>
</html>