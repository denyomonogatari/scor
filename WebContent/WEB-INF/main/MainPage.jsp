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
	<title>Main Page</title>
</head>
<body>
	<div class="container">
		<p class="text-right"><a href="../auth/Logout">Logout</a></p>
		<h1 class="display-2">Hello, ${user.first}</h1>
		<div class="row">
			<div class="col-6">
				<h2>Semesters</h2>
				<ul>
					<c:forEach items="${user.semesters}" var="semester" varStatus="status">
						<li><a href="SemesterPage?semesterId=${status.index}">${semester.season} ${semester.year} <fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${semester.GPA}" /></a></li>
					</c:forEach>
				</ul>
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="semester" placeholder="Name of Semester">
					</div>
					<div class="col">
						<input type="text" maxlength="4" class="form-control" name="year" placeholder="Year">
					</div>
					<div class="col">
						<a class="btn btn-primary" href="#" role="button">Add Semester</a>
					</div>
				</div>
			</div>
			<div class="col-6">
				<h2>Dates</h2>
				<p>All your upcoming events go here.</p>
				 
				
<body1>

  <head>
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<h1>Student Expenses Manager</h1>
<h2>Add a new item:</h2>

<div id="form-box">
<form>
  <div>
    <span>Type:</span> 
      <select name="type">
          <option value="card">Card</option>
          <option value="cash">Cash</option>
          <option value="cryptocoin">Crypto Currencies</option>
          <option value="other">Other</option>
      </select>
  </div>
  
  <div>
    <span>Name:</span> <input type="text" name="item-name" placeholder="What did you spend on?">
  </div>
  
  <div>
    <span>Date:</span> <input type="date" name="date">
  </div>
  
  <div>
    <span>Amount:</span> <input type="number" name="amount" placeholder="How much?">
  </div>
  
</form>
</div>

<div id="button"><span>Add</span></div>

<table>
  <tr>
    <th id="type" class="center">type</th>
    <th>name</th>
    <th id="date">date</th>
    <th style="text-align: right" id="amount">amount</th>
  </tr>
  <tr id="if-empty">
    <td colspan="4"><span>Your added items will show up here!</span></td>
  </tr>

</table>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  
 <link href="<c:url value="/resources/css/style1.css" />" rel="stylesheet"> 

  <script src="<c:url value="/resources/javascript/app1.js" />"></script>




</body1>
			</div>
			
		</div>
	</div>	
	
</body>
</html>