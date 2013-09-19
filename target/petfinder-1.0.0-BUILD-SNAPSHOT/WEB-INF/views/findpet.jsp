<html>

<head>
	<title>Pet search</title>
	<script src="/PetFinder/resources/scripts/jquery-1.10.2.js"></script>
	<script src="/PetFinder/resources/scripts/handlebars.runtime.js"></script>
	<script src="/PetFinder/resources/scripts/handlebars-helpers.js"></script>
	<script src="/PetFinder/resources/scripts/templates/petlist.js"></script>
	<script src="/PetFinder/resources/scripts/findpet.js"></script>
</head>

<body>
	<label>Results per page:</label>
	<select id="results-per-page">
		<option>5</option>
		<option>10</option>
		<option>15</option>
		<option>20</option>
		<option>25</option>
	</select>
	<button type="button" id="previous-page">Previous page</button>
	<button type="button" id="next-page">Next page</button>
	<br/>
	<div id="pet-list"></div>
	
</body>

</html>