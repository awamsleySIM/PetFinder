<html>

<head>
	<title>Find a random pet</title>
	<script src="/PetFinder/resources/scripts/jquery-1.10.2.js"></script>
	<script src="/PetFinder/resources/scripts/handlebars.runtime.js"></script>
	<script src="/PetFinder/resources/scripts/templates/petdisplay.js"></script>
	<script src="/PetFinder/resources/scripts/handlebars-helpers.js"></script>
	<script src="/PetFinder/resources/scripts/randompet.js"></script>
</head>

<body>
	<div id="controls">
		<form id="random-pet-form">
			<label>Species:</label>
			<select id="species">
				<option value="">Any</option>
				<option value="cat">Cat</option>
				<option value="dog">Dog</option>
			</select>
			<label>Gender:</label>
			<select id="sex">
				<option value="">Either</option>
				<option value="M">Male</option>
				<option value="F">Female</option>
			</select>
			<button type="button" id="submitFindRandom">Find Random Pet</button>
		</form>
	</div>
	
	<div id="pet-display"></div>
</body>

</html>