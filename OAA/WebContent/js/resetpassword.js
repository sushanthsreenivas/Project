function validateForm() {
	if (document.form.password_old.value == "") {
		alert("enter current password");
		document.form.password_old.focus();
		return false;
	}
}