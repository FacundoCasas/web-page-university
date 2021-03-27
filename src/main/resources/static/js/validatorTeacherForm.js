function submitForm() {
var name = document.forms["form"]["name"];
var last_name = document.forms["form"]["last_name"];
var dni = document.forms["form"]["id"];

	if (name.value == "") {
		window.alert("Please enter the name.");
		return false;
	}if(last_name.value == ""){
		window.alert("Please enter the last name.");
		return false;
	}if(dni.value <= 0){
		window.alert("Please enter the dni greater than 0.");
		return false;
	}
	return false;
}