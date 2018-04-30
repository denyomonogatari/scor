<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Main Page</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
		<a class="navbar-brand" href="#">SCOR</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="MainPage">Home<span
						class="sr-only">(current)</span></a></li>
				<%--                 <li class="nav-item">
                    <a class="nav-link" href="SemesterPage?semesterId=${semesterId}">Courses</a>
                </li> --%>
				<li class="nav-item"><a class="nav-link"
					href="UpcomingAssignmentsPage">Upcoming Assignments</a></li>
				<li class="nav-item"><a class="nav-link" href="FlashCardDecks">Flash
						Card Decks</a></li>
				<li class="nav-item"><a class="nav-link" href="../auth/Logout">Logout</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1 class="display-2">Hello, ${user.first}</h1>
		<div class="row">
			<div class="col-6">
				<h2>Semesters</h2>
				<ul>
					<c:forEach items="${user.semesters}" var="semester"
						varStatus="status">
						<li><a href="SemesterPage?semesterId=${status.index}">${semester.season}
								${semester.year} <fmt:formatNumber type="number"
									maxFractionDigits="2" value="${semester.GPA}" />
						</a></li>
					</c:forEach>
				</ul>
				<form action="../actions/AddSemester" method="get">
					<legend>Add Semester</legend>
					<div class="row">
						<div class="col">
							<input type="text" maxlength="6" class="form-control" name="term"
								placeholder="Term">
						</div>
						<div class="col">
							<input type="text" class="form-control" name="year"
								placeholder="Year">
						</div>
						<div class="col">
							<input type="submit" class="btn btn-primary" value="Add Semester">
						</div>
					</div>
				</form>
			</div>
			<div class="col-6">
				<div>
					<form action="../action/GetAnswer" method="get">
						<div class="form-group">
							<label class="col-form-label-lg" for="equation">Ask me a
								math question: </label> <input class="form-control" type="text"
								id="equation" name="mathQuestion">
						</div>
						<div class="form-group">
							<button class="btn btn-primary">Give me an answer!</button>
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>	
	
</body>
</html>