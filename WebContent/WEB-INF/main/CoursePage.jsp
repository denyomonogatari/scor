<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Course Page</title>
</head>
<body>
	<div class="container mb-5">
		<ul class="nav justify-content-center">
		  <li class="nav-item">
		    <a class="nav-link" href="MainPage">Back to Main Page</a>
		  </li>
		  <li class="nav-item">
		  	<a class="nav-link" href="SemesterPage?semesterId=${semesterId}">Back to Semester Page</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="../auth/Logout">Logout</a>
		  </li>
		</ul>
		<c:set var="course" scope="page" value="${user.semesters[semesterId].courses[courseId]}"/>
		<div class="row">
			<div class="col-12">
				<h1>${course.name}</h1>
				<h2>Percent: <strong><fmt:formatNumber type="number" maxFractionDigits="2" value="${course.percentEarned}"/>%</strong> out of 100.00%</h2>
				<h2>Grade: <strong>${course.grade}</strong></h2>
				<br>
				<c:set var="assessments" scope="page" value="${course.assessments}"/>
				<c:forEach items="${assessments}" var="assessment" varStatus="status1">
					<h3>
						${assessment.type} <fmt:formatNumber type="number" maxFractionDigits="2" value="${assessment.score}"/>% out of ${assessment.worth}%
						<a href="../actions/EditAssessment?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}">Edit</a>
						<a href="../actions/DeleteAssessment?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}">Delete</a>
					</h3>
					<table class="table table-hover">
						<tr>
							<th>Name</th>
							<th>Score</th>
							<th>Worth</th>
							<th>Options</th>
						</tr>
						<c:forEach items="${assessment.assignments}" var="assignment" varStatus="status2">
							<c:set var="queryString" scope="page" value="?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}&assignmentId=${status2.index}"/> 
							<tr>
								<td>${assignment.name}</td>
								<td>${assignment.score}</td>
								<td>${assignment.total}</td>
								<td>
									<a class="btn btn-primary btn-secondary" href="../actions/EditAssignment${queryString}">Edit</a>
									<a class="btn btn-primary btn-danger" href="../actions/DeleteAssignment${queryString}">Delete</a>
								</td>
							</tr>
						
						</c:forEach>
						<form action="../actions/AddAssignment">
							<input type="hidden" name="semesterId" value="${semesterId}">
							<input type="hidden" name="courseId" value="${courseId}">
							<input type="hidden" name="assessmentId" value="${status1.index}">
							<input type="hidden" name="assignmentId" value="${status2.index}">
							<tr>
								<td><input type="text" class="form-control" name="assignmentName" placeholder="Name of assignment"></td>
								<td><input type="text" class="form-control" name="assignmentScore" placeholder="Your score"></td>
								<td><input type="text" class="form-control" name="assignmentWorth" placeholder="Worth"></td>
								<td><input type="submit" class="btn btn-primary" name="add" value="Add"></td>
							</tr>
						</form>
					</table>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form action="../actions/AddAssessment">
					<input type="hidden" name="semesterId" value="${semesterId}">
					<input type="hidden" name="courseId" value="${courseId}">
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="assessmentType" placeholder="type">
						</div>
						<div class="col">
							<input type="text" class="form-control" name="assessmentWorth" placeholder="worth">
						</div>
						<div class="col">
							<input type="submit" class="btn btn-primary" value="Add Assessment">
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>