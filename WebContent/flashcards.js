/**
 * 
 */
var deckName = document.getElementById("deckName").value
//
var JsonDeck = getJsonData();

var index = 1

function next() {
	var dom = document.getElementById("cardHolder")
	let array = window.state.deck.data
	dom.innerHTML = array[index++ % (array.length)].question
}

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
			//console.log(json)
			return json
		},
		async : true,
		global : false,
		error : function() {
			alert("Errr is occured");
		}
	});
}