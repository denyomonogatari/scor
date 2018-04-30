<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.user}">
	<%-- redirect to Login --%>
	<c:redirect url="../auth/Login" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Flash Card Decks</title>
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
			<li class="nav-item"><a class="nav-link" href="../main/MainPage">Home<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="../auth/Logout">Logout</a>
			</li>
		</ul>
	</div>
	</nav>
	<h1>Flash Card HomePage</h1>
	<c:set var="decks" scope="page" value="${user.getFlashCardDecks()}" />
	<table class="table table-hover">
		<tr>
			<th>#</th>
			<th>Name:</th>
			<th>Action:</th>
		</tr>
		<c:forEach items='${decks}' var='deck' varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${deck.getDeckName()}</td>
				<td><a href="FlashCards?name=${deck.getDeckName()}">view</a> 
				<a href="../actions/DeleteFlashCardDeck?name=${deck.getDeckName()}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<form action="../actions/AddFlashCardDeck" method="get">
		<label for="add">Name:</label> <input type="text" id="add"
			name="deckName">
		<button>Add Deck</button>
	</form>
</body>
</html>