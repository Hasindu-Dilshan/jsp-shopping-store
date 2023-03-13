function formValidation() {
	const email = document.login.email;
	const password = document.login.password;
	
	if(email_validation(email)) {
		return true;
	}
	
	return false;
	
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