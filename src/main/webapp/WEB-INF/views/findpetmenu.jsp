<html>

<head>
	<title>Find a pet</title>
	<script src="/PetFinder/resources/scripts/jquery-1.10.2.js"></script>
	<script src="/PetFinder/resources/scripts/findpetmenu.js"></script>
</head>

<body>
	<form id="find-pet" action="/PetFinder/findpet" method="get">
		<label>Species:</label>
			<select name="animal" id="animal" class="query">
				<option value="">Any</option>
				<option value="cat">Cat</option>
				<option value="dog">Dog</option>
			</select><br/>
		<label>Breed:</label>
			<select name="breed" id="breed" class="query" disabled>
			</select><br/>
		<label>Size:</label>
			<select name="size" id="size" class="query">
				<option value="">Any</option>
				<option value="S">Small</option>
				<option value="M">Medium</option>
				<option value="L">Large</option>
				<option value="XL">Extra large</option>
			</select><br/>
		<label>Gender:</label>
			<select name="sex" id="sex" class="query">
				<option value="">Any</option>
				<option value="M">Male</option>
				<option value="F">Female</option>
			</select><br/>
		<label>Age:</label>
			<select name="age" id="age" class="query">
				<option value="">Any</option>
				<option>Baby</option>
				<option>Young</option>
				<option>Adult</option>
				<option>Senior</option>
			</select><br/>
		<label>Location (ZIP or city and state):</label>
			<input name="location" id="location" type="text" class="query"><br/>
		<button id="submit" type="submit">Submit</button>
	</form>
</body>

</html>