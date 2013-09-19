//Parses URL query string into javascript object for initial AJAX call
(function($) {
var re = /([^&=]+)=?([^&]*)/g;
var decodeRE = /\+/g;  // Regex for replacing addition symbol with a space
var decode = function (str) {return decodeURIComponent( str.replace(decodeRE, " ") );};
$.parseParams = function(query) {
    var params = {}, e;
    while ( e = re.exec(query) ) { 
        var k = decode( e[1] ), v = decode( e[2] );
        if (k.substring(k.length - 2) === '[]') {
            k = k.substring(0, k.length - 2);
            (params[k] || (params[k] = [])).push(v);
        }
        else params[k] = v;
    }
    return params;
};
})(jQuery);

$(document).ready(function() {
	
	var nextOffset;
	var url = window.location.search.substring(1);
	var parameters = $.parseParams(url);
	
	//Set count
	$("#results-per-page").val(parameters.count);
	
	//Initial AJAX call
	$.getJSON("/PetFinder/findpetlist", parameters, function(data) {
		if (data.header.status.code == 100) {
			nextOffset = data.lastOffset;
			$("#pet-list").html(Handlebars.templates.petlist(data.pets));
		} else {
			$("#pet-list").text(data.header.status.message);
		}
	});
	
	var count = parameters.count;
	var offset = parameters.offset;
	
	//Previous page
	$("#previous-page").click(function() {
		if (offset > 0) {
			offset -= count;
			if (offset < 0) {
				offset = 0;
			}
			parameters.offset = offset;
			var urlQuery = $.param(parameters);
			window.location.href = "/PetFinder/findpet?" + urlQuery;
		}
	});
	
	//Next page
	$("#next-page").click(function() {
		parameters.offset = nextOffset;
		var urlQuery = $.param(parameters);
		window.location.href = "/PetFinder/findpet?" + urlQuery;
	});
	
	//Change results per page
	$("#results-per-page").change(function() {
		parameters.count = $(this).val()
		var urlQuery = $.param(parameters);
		window.location.href = "/PetFinder/findpet?" + urlQuery;
	});

});