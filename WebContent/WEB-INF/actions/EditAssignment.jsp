<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Edit Assignment</title>
</head>
<body>
	<div class="container">
		<p class="text-right"><a href="../auth/Logout">Logout</a></p>
		<h3>Please edit and save the assignment</h3>
		<div class="row">
			<div class="col-12">
				<table class="table">
					<tr>
						<th>Name</th>
						<th>Score</th>
						<th>Worth</th>
						<th>Due Date</th>
						<th>Options</th>
					</tr>
					
					<c:set var="assignmentToEdit" value="${user.semesters[semesterId].courses[courseId].assessments[assessmentId].assignments[assignmentId]}" />
					<form method="post">
						<input type="hidden" name="semesterId" value="${semesterId}">
						<input type="hidden" name="courseId" value="${courseId}">
						<input type="hidden" name="assessmentId" value="${assessmentId}">
						<input type="hidden" name="assignmentId" value="${assignmentId}">
						
						<tr>
							<td><input type="text" class="form-control" name="assignmentName" value="${assignmentToEdit.name}" placeholder="Name of Assignment"></td>
							<td><input type="text" class="form-control" name="assignmentScore" value="${assignmentToEdit.score}"  placeholder="Score"></td>
							<td><input type="text" class="form-control" name="assignmentWorth" value="${assignmentToEdit.total}"  placeholder="Worth"></td>
							<td><input type="datetime-local" class="form-control" name="dueDate" value="${assignmentToEdit.dueDateString}"></td>
							<td><input type="submit" class="btn btn-primary" value="Save" ></td>
						</tr>
					</form>
				</table>
				
			</div>
		</div>
	</div>
</body>
</html>