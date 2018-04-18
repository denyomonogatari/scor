/**
 * 
 */
var deckName = document.getElementById("deckName")
//
var JsonDeck = getJsonData()

function getJsonData() {

	var table = "<html><table border=\"1px\">";

	table = table + "<th>question</th><th>answer</th>";

	$.ajax({

		type : "GET",
		url : "/scor/main/GetFlashCardJSON",
		dataType : 'json',
		success : function(json) {

			var info1 = json.flashCardSet;

			$.each(info1, function(index, element) {
				var info = element;

				table = table + "<tr>";

				$.each(info, function(index, element) {

					table = table + "<td>" + element + "</td>"
				});
				table = table + "</tr>";

			});
			table = table += "</table></html>";

			console.log("worked")
			$("#output").html(table);
//			
			
		},
		async : true,
		global : false,
		error : function() {
			alert("Errr is occured");
		}
	});
}