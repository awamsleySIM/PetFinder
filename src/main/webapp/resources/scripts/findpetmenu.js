$(document).ready(function() {
	
	//Populates breed list when a species is selected
	$("#animal").change(function() {
		if ($(this).val()) {
			$.ajax({url: "/PetFinder/breedlist", type: "POST", dataType: "json", 
				data: {animal: $("#animal option[value='" + $(this).val() + "']").text()}, success: function(data) {
					var breedlist = data["breed"];
					$("#breed").html("");
					for (var i = 0; i < breedlist.length; i++) {
						$("#breed").append('<option>' + breedlist[i] + '</option>');
					}
				}});
			$("#breed").prop('disabled', false);
		} else {
			$("#breed").html("");
			$("#breed").prop('disabled', 'disabled');
		}
	});
	
	//Handle form submit
	

});
