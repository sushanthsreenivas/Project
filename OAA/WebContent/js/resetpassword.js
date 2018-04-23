function validateForm() {
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lasttname").value;
	var address = document.getElementById("address").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var country = document.getElementById("country").value;
	var city = document.getElementById("city").value;
	var mobile = document.getElementById("mobile").value;
	var email = document.getElementById("email").value;

	if (firstname.value == "") {
		alert("Please enter your firstname.");
		firstname.focus();
		return false;
	}
	if (lastname.value == "") {
		alert("Please enter your lastname.");
		lastname.focus();
		return false;
	}
	if (address.value == "") {
		alert("Please enter your address.");
		address.focus();
		return false;
	}
	if (city.value == "") {
		alert("Please enter your city.");
		city.focus();
		return false;
	}
	if (state.value == "") {
		alert("Please enter your state.");
		state.focus();
		return false;
	}
	if (country.value == "") {
		alert("Please enter your country.");
		countrys.focus();
		return false;
	}
	if ((mobile.checked == false) && (mobile.value == "")) {
		alert("Please enter your telephone number.");
		mobile.focus();
		return false;
	}
	if (email.value == "") {
		alert("Please enter your email address.");
		email.focus();
		return false;
	}
	if (email.value.indexOf("@", 0) < 0) {
		alert("Please enter a valid e-mail address.");
		email.focus();
		return false;
	}
	if (email.value.indexOf(".", 0) < 0) {
		alert("Please enter a valid e-mail address.");
		email.focus();
		return false;
	}

}
