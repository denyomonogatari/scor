var deckName = document.getElementById("deckName").value

var JsonDeck = getJsonData();

var index = 0
var isOnQuestion = true

function next() {
	if (!isOnQuestion) {
		isOnQuestion = true
	}
	var dom = document.getElementById("cardHolder")
	let array = window.state.deck.data
	dom.innerHTML = array[index++ % (array.length)].question

}

function previous() {
	if (!isOnQuestion) {
		isOnQuestion = true
	}
	var dom = document.getElementById("cardHolder")
	let array = window.state.deck.data
	index = index - 2
	dom.innerHTML = array[index % (array.length)].question
	index++
	
}



document.getElementById("cardHolder").addEventListener('click', function() {
	var dom = document.getElementById("cardHolder")
	let array = window.state.deck.data

	if (isOnQuestion) {
		dom.innerHTML = array[(index - 1) % (array.length)].answer
		isOnQuestion = false
	} else {
		dom.innerHTML = array[(index - 1) % (array.length)].question
		isOnQuestion = true
	}

})

function getJsonData() {
	$.ajax({
		type : "GET",
		url : "/scor/main/GetFlashCardJSON?name=" + deckName + "",
		dataType : 'json',
		success : function(json) {
			window.state = json
			return json
		},
		async : true,
		global : false,
		error : function() {
			alert("Errr is occured");
		}
	});
}
