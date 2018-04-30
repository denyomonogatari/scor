<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<%-- check if there is a session scope variable user --%>
<c:if test="${empty sessionScope.user}">
  <%-- redirect to Login --%>
  <c:redirect url="../auth/Login" />
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Semester Page</title>
</head>
<body>
	<div class="container">
		<p class="text-right"><a href="../auth/Logout">Logout</a></p>
		<div class="row">
			<div class="col-6">
				<h2>Courses</h2>
				<ul>
					<c:forEach items="${user.semesters[semesterId].courses}" var="course" varStatus="status">
						<li><a href="CoursePage?semesterId=${semesterId}&courseId=${status.index}">${course.name} ${course.grade}</a></li>
					</c:forEach>
				</ul>
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="course" placeholder="Name of Course">
					</div>
					<div class="col">
						<input type="text" maxlength="2" class="form-control" name="grade" placeholder="Grade">
					</div>
					<div class="col">
						<a class="btn btn-primary" href="#" role="button">Add Course</a>
					</div>
				</div>
			</div> 
			<div class="col-6">
				<h2>Dates</h2>
				<p>All your upcoming events go here.</p>
			</div>
		</div>
	</div>	
</body>




</html>