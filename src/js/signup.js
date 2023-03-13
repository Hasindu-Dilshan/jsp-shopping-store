function formValidation() {
	const name = document.signup.name;
	const email = document.signup.email;
	const year = document.signup.birthYear;
	const password = document.signup.password;
	const passwordConfirmation = document.signup.passwordConfirmation;
	
	const minNameLength = 5;
	
	if(name_validation(name, minNameLength)) {
		if(email_validation(email)){
			if(dob_validation(year)) {
				if(password_validation(password, passwordConfirmation)){
					if(password_validation(password, passwordConfirmation)) {
						return true;
					}
				}
			}
		}
	}
	
	return false;
	
}

function name_validation(name, minNameLength) {
	var letters = /^[A-Za-z]+$/;
	
	
	if(name.value.match(letters)) {
		if(name.value.length >= minNameLength){
			return true;
		}
			
		else {
			alert('Username must have at least ' + minNameLength + " characters");
			name.focus();
			return false;
		}
		
	}
	else {
		alert('Username must have alphabet characters only');
		name.focus();
		return false;
	}
}

function email_validation(email) {
  	var truncatedEmail = email.value.split("@");
  	truncatedEmail = truncatedEmail[1].split(".");
  	
  	var emailProvider = truncatedEmail[0];
  	
  	if(emailProvider == "gmail" || emailProvider == "ymail" ) {
		return true;
	}
  	else {
		alert("Only Google or Yahoo mails are allowed");
		email.focus();
		return false;
	}
  	
  	
}

function dob_validation(year) {
	var birthYear = year.value;
	
	console.log("birthYear :"+birthYear);
	
	
	if(birthYear >= 1900 && birthYear <= 2015) {
		return true;
	}
	else {
		alert("Birth Year must be between 1900 - 2015");
		year.focus();
		return false;
	}
	
}

function password_validation(password, passwordConfirmation) {
	if(password.value == passwordConfirmation.value) {
		return true;
	}
	else {
		alert("Password's does not match");
		password.focus();
		return false;
	}
}