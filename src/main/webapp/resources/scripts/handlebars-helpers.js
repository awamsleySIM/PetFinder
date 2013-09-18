Handlebars.registerHelper("formatPetOption", function(option) {
	switch(option) {
	case "SPECIAL_NEEDS":
		return "Special needs";
	case "NO_DOGS":
		return "No dogs";
	case "NO_CATS":
		return "No cats";
	case "NO_KIDS":
		return "No kids";
	case "NO_CLAWS":
		return "No claws";
	case "HAS_SHOTS":
		return "Has shots";
	case "HOUSEBROKEN":
		return "Housebroken";
	case "ALTERED":
		return "Altered";
	}
});

Handlebars.registerHelper("formatSex", function(sex) {
	switch(sex) {
	case "M":
		return "Male";
	case "F":
		return "Female";
	}
});

Handlebars.registerHelper("formatAge", function(age) {
	switch(age) {
	case "BABY":
		return "Baby";
	case "YOUNG":
		return "Young";
	case "ADULT":
		return "Adult";
	case "SENIOR":
		return "Senior";
	}
});

Handlebars.registerHelper("formatSize", function(size) {
	switch(size) {
	case "S":
		return "Small";
	case "M":
		return "Medium";
	case "L":
		return "Large";
	case "XL":
		return "Extra large";
	}
});