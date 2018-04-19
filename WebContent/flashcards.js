/**
 * 
 */
var deckName = document.getElementById("deckName").value
//
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

document.getElementById("cardHolder").addEventListener('click', function() {
	var dom = document.getElementById("cardHolder")
	let array = window.state.deck.data

	if (isOnQuestion) {
		dom.innerHTML = array[(index - 1)% (array.length)].answer
		isOnQuestion = false
	} else {
		dom.innerHTML = array[(index - 1)  % (array.length)].question
		isOnQuestion = true
	}

})

function getJsonData() {

	var table = "<html><table border=\"1px\">";

	table = table + "<th>question</th><th>answer</th>";

	$.ajax({

		type : "GET",
		url : "/scor/main/GetFlashCardJSON?name=\"" + deckName + "\"",
		dataType : 'json',
		success : function(json) {

			// var info1 = json.flashCardSet;
			//
			// $.each(info1, function(index, element) {
			// var info = element;
			//
			// table = table + "<tr>";
			//
			// $.each(info, function(index, element) {
			//
			// table = table + "<td>" + element + "</td>"
			// });
			// table = table + "</tr>";
			//
			// });
			// table = table += "</table></html>";
			//
			// console.log("worked")
			// $("#output").html(table);
			//			
			window.state = json
			// console.log(json)
			return json
		},
		async : true,
		global : false,
		error : function() {
			alert("Errr is occured");
		}
	});
}