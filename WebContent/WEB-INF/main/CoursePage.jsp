<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%-- check if there is a session scope variable user --%>
<c:if test="${empty sessionScope.user}">
  <%-- redirect to Login --%>
  <c:redirect url="../auth/Login" />
</c:if>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .center{
            text-align: center;
        }

        .left {
            text-align: left;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<title>Course Page</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">    
        <a class="navbar-brand" href="#">SCOR</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="MainPage">Home<span class="sr-only">(current)</span></a>
                </li>
<%--                 <li class="nav-item">
                    <a class="nav-link" href="SemesterPage?semesterId=${semesterId}">Courses</a>
                </li> --%>
                <li class="nav-item">
                    <a class="nav-link" href="UpcomingAssignmentsPage">Upcoming Assignments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../auth/Logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>	
	<div class="container">
        <c:set var="course" scope="page" value="${user.semesters[semesterId].courses[courseId]}"/>
		<div class="page-header">
			<h1 class="display-4">${course.name}</h1>
			<p class="lead">Percent: <strong><fmt:formatNumber type="number" maxFractionDigits="2" value="${course.percentEarned}"/>%</strong> out of 100.00%</p>
			<p class="lead">Grade: <strong>${course.grade}</strong></p>
		</div>
		<div class="row">
			<div class="col">
				<br>
				<c:set var="assessments" scope="page" value="${course.assessments}"/>
				<c:forEach items="${assessments}" var="assessment" varStatus="status1">
					<form action="../actions/EditAssessment?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}" method="post" class="form-inline">
						<div class="form-group"> 
							<h2><input type="text" class="form-control-plaintext" name="assessmentType" value="${assessment.type}"></h2>
					  	</div>
					  	<div class="form-group">
 					  		<div class="input-group">
								<span><fmt:formatNumber type="number" maxFractionDigits="2" value="${assessment.score}"/>% out of</span>
							</div>
<%-- 							<fmt:formatNumber type="number" maxFractionDigits="2" value="${assessment.score}"/>% out of --%>
							<input type="text" class="form-control form-control-plaintext" name="assessmentWorth" value="${assessment.worth}" size="5">%
					  	</div>
					  	<div class="form-group">					  	
					    	<input type="submit" class="btn btn-link" value="Save">
					    	<a href="../actions/DeleteAssessment?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}">Delete</a>
					  	</div>
					</form>
					<div class="form-row table">
	                    <div class="col-2 center">
	                        <strong class="center">Name of Assignment</strong>
	                    </div>
	                    <div class="col-2 center">
	                        <strong>Score</strong>
	                    </div>
	                    <div class="col-2 center">
	                        <strong>Worth</strong>
	                    </div>
	                    <div class="col-1 center">
	                        <strong>Done?</strong>
	                    </div>
	                    <div class="col-3 center">
	                        <strong>Due date</strong>
	                    </div>
	                    <div class="col-2 center">
	                        <strong>Options</strong>
	                    </div>
                	</div>
                	<!-- start of form -->
                	<c:forEach items="${assessment.assignments}" var="assignment" varStatus="status2">
                		<c:set var="queryString" scope="page" value="?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}&assignmentId=${status2.index}"/> 
						<form action="../actions/EditAssignment${queryString}" method="post">
		                    <div class="form-row table" >
		                        <!-- <input type="hidden" name="assignmentId" value="Assignment ID"> -->
		                        <div class="col-2">
		                            <input type="text" class="form-control" placeholder="Assignment name" name="assignmentName" value="${assignment.name}" required>
		                        </div>
		                        <div class="col-2">
		                            <input type="text" class="form-control" placeholder="Score" name="assignmentScore" value="${assignment.score}">
		                        </div>
		                        <div class="col-2">
		                            <input type="text" class="form-control" placeholder="Worth" name="assignmentWorth" value="${assignment.total}">
		                        </div>
		                        <div class="col-1">
		                            <select class="custom-select" id="isDone" name="isDone" >
							            <option value="true" <c:if test="${assignment.completed}">selected</c:if>>Yes</option>
		                                <option value="false" <c:if test="${not assignment.completed}">selected</c:if>>No</option>
		                            </select>
		                        </div>
		                        <div class="col-3"> 
		                        	<!-- TODO Fix disability when Done? is yes -->
		                            <input type="datetime-local" class="form-control" id="dueDate" name="dueDate" value="${assignment.dueDateString}">
		                        </div>
		                        <div class="col-2 center">
		                            <input type="submit" class="btn btn-secondary" value="Save" required>
		                            <a class="btn btn-primary btn-danger" href="../actions/DeleteAssignment${queryString}">Delete</a>
		                        </div>
		                    </div>
	                	</form>
					</c:forEach>
					<c:set var="queryString1" scope="page" value="?semesterId=${semesterId}&courseId=${courseId}&assessmentId=${status1.index}"/> 
					<form action="../actions/AddAssignment${queryString1}" method="post">
	                    <div class="form-row table" >
	                        <div class="col-2">
	                            <input type="text" class="form-control" placeholder="Assignment name" name="assignmentName" required>
	                        </div>
	                        <div class="col-2">
	                            <input type="text" class="form-control" placeholder="Score" name="assignmentScore">
	                        </div>
	                        <div class="col-2">
	                            <input type="text" class="form-control" placeholder="Worth" name="assignmentWorth">
	                        </div>
	                        <div class="col-1">
	                            <select class="custom-select" id="isDone" name="isDone">
	                                <option value="true">Yes</option>
	                                <option value="false">No</option>
	                            </select>
	                        </div>
	                        <div class="col-3">
	                            <input type="datetime-local" class="form-control" id="dueDate" name="dueDate">
	                        </div>
	                        <div class="col-2 left">
	                            <input type="submit" class="btn btn-primary" value="Add" required>
	                        </div>
	                    </div>
	                </form>
				</c:forEach>
			</div>
		</div>

		<br>
        <div class="row">
            <div class="col">
                <form action="../actions/AddAssessment?semesterId=${semesterId}&courseId=${courseId}" method="post">
                    <div class="form-row table" >
                        <div class="col-4">
                            <input type="text" class="form-control" placeholder="Asessment type" name="assessmentType" required>
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" placeholder="Worth" name="assessmentWorth" required>
                        </div>
                        <div class="col-4">
                            <input type="submit" class="btn btn-primary" value="Add Assessment">
                        </div>
                    </div>
                </form>
            </div>
        </div>
		
	</div>
</body>
</html>