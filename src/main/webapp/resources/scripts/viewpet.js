//Parses URL query string into javascript object for AJAX call
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
	
	var url = window.location.search.substring(1);
	var parameters = $.parseParams(url);
	
	$.getJSON("/PetFinder/findpetbyid", parameters, function(data) {
		$("#pet-display").html(Handlebars.templates.petdisplay(data));
	});

});