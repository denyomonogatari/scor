<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${name}</title>
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="../flashcards.css">
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
			<li class="nav-item"><a class="nav-link"
				href="../main/FlashCardDecks">Flash Card Decks</a></li>
			<li class="nav-item"><a class="nav-link" href="../auth/Logout">Logout</a>
			</li>
		</ul>
	</div>
	</nav>
	<div class="outer_div">
		<div class="center_div">
			<div class="title">${name}</div>
			<div class="flashcard" id='cardHolder'></div>
			<input id='deckName' type='hidden' value='${name}'>
			<div class="actions">
				<button onclick="previous()">Previous</button>
				<form action="../actions/AddFlashCard" method="get">
					<label for="question">Question:</label> <input type="text"
						name="question" id="question"> <label for="answer">Answer:</label>
					<input type="text" name="answer" id="answer"> <input
						type="hidden" name="name" value="${name}">

					<button>Add</button>
				</form>
				<button onclick="next()">Next</button>
			</div>
		</div>
	</div>

	<script type='text/javascript' src='../flashcards.js'></script>
</body>
</html>