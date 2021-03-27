function submitForm() {
var name = document.forms["form"]["name"];
var hours = document.forms["form"]["hours"];
var max_students = document.forms["form"]["max_students"];
var description = document.forms["form"]["description"];


	if (name.value == "") {
		window.alert("Please enter the name.");
		return false;
	}if(hours.value == ""){
		window.alert("Please enter the hours.");
		return false;
	}if(max_students.value <= 0){
		window.alert("Please enter the max students greater than 0.");
		return false;
	}if(description.value == ""){
		window.alert("Please enter the description.");
		return false;
	}
}