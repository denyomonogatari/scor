<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%-- check if there is a session scope variable user --%>
<c:if test="${empty sessionScope.user}">
  <%-- redirect to Login --%>
  <c:redirect url="../auth/Login" />
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> -->
   	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
    
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$( function() {
		  $( "#sortable" ).sortable();
		  $( "#sortable" ).disableSelection();
		} );
	</script>
    
    <title>Upcoming Assignments</title>
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
                <li class="nav-item"><a class="nav-link" href="FlashCardDecks">Flash
						Card Decks</a></li>
				 <li class="nav-item"><a class="nav-link" href="ExpensesManagerPage">Expenses
				Manager</a></li>	
                <li class="nav-item">
                    <a class="nav-link" href="../auth/Logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>	
    <div class="container">
        <div class="row">
            <div class="col">
				<div class="d-flex">
				<!-- <span class="display-5">Upcoming Assignments</span> -->
					<div class="mr-auto p-2"><h1 class="display-4">Upcoming Assignments</h1></div>
					<!-- <div class="p-2">
						<div class="btn-group">
							<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								Options
							</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">Sort by due date</a>
							</div>	
						</div>
					</div> -->
				</div>
                 <ul class="list-group" id="sortable">
                	<c:forEach items="${upcomingAssignments}" var="upcomingAssignment" varStatus="status">
	                   <li class="list-group-item d-flex justify-content-between align-items-center">
	                       <div class="mr-auto p-2">${upcomingAssignment.name} <small>Due <fmt:formatDate pattern="MM-dd-yyyy, hh:mm a" value="${upcomingAssignment.dueDate}" /></small></div>
	                       <div class="p-2"><span class="badge badge-primary badge-pill">${upcomingAssignment.courseName}</span></div>
	                       <div class="p-2"><span class="badge badge-secondary badge-pill">${upcomingAssignment.assessmentType}</span></div>
	                   </li>
	                 </c:forEach>  
                </ul>
                
            </div>
        </div>
    </div>
</body>
</html>