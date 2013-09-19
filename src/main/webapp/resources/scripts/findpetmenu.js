$(document).ready(function() {
	
	//Populates breed list when a species is selected
	$("#animal").change(function() {
		if ($(this).val()) {
			$.ajax({url: "/PetFinder/breedlist", type: "GET", dataType: "json", 
				data: {animal: $("#animal option[value='" + $(this).val() + "']").text()}, success: function(data) {
					var breedlist = data["breed"];
					$("#breed").html("");
					$("#breed").append('<option value="">Any</option>');
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
	$("#find-pet").submit(function(event) {
		event.preventDefault();
		if (!$("#location").val()) {
			alert("Must provide a location");
			return false;
		}
		
		var queryObject = {};
		$(":input.query").each(function() {
			if ($(this).val()) {
				queryObject[$(this).attr("name")] = $(this).val(); 
			}
		});
		var urlQuery = $.param(queryObject);
		window.location.href = '/PetFinder/findpet?' + urlQuery;
	});

});
