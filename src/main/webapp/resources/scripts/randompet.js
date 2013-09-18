$(document).ready(function() {
	
	//Load random pet on page load
	$.getJSON("/PetFinder/randompet", function(randomPet) {
		$("#pet-display").html(Handlebars.templates.petdisplay(randomPet));
	});
	
	$("#submitFindRandom").click(function() {
		var options = {};
		if ($("#species").val()) {
			options.animal = $("#species").val();
		}
		if ($("#sex").val()) {
			options.sex = $("#sex").val();
		}
		$.ajax({url: "/PetFinder/randompet", data: options, success: function(randomPet) {
			$("#pet-display").html(Handlebars.templates.petdisplay(randomPet));
		}, dataType: "json", type: "POST"});
	});

});