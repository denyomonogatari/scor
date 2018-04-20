<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Edit Assessment</title>
</head>
<body>
	<div class="container">
		<p class="text-right"><a href="../auth/Logout">Logout</a></p>
		<h3>Please edit and save the assessment</h3>
		<div class="row">
			<div class="col-12">
				<c:set var="assessmentToEdit" value="${user.semesters[semesterId].courses[courseId].assessments[assessmentId]}" />
				<form method="post">
					<input type="hidden" name="semesterId" value="${semesterId}">
					<input type="hidden" name="courseId" value="${courseId}">
					<input type="hidden" name="assessmentId" value="${assessmentId}">
					<input type="text" class="form-control" name="assessmentType" value="${assessmentToEdit.type}" placeholder="Name of Assessment">
					<input type="text" class="form-control" name="assessmentWorth" value="${assessmentToEdit.worth}"  placeholder="Worth">
					<input type="submit" class="btn btn-primary" value="Save" >
				</form>
			</div>
		</div>
	</div>
</body>
</html>