// Document is ready
$(document).ready(function() {

	// Validate firstname
	$('#firstnamecheck').hide();
	let firstnameError = true;
	$('#firstname').keyup(function() {
		validatefirstname();
	});

	function validatefirstname() {
		let firstnameValue = $('#firstname').val();
		if (firstnameValue.length == '') {
			$('#firstnamecheck').show();
			firstnameError = false;
			return false;
		} else if ((firstnameValue.length < 3) ||
			(firstnameValue.length > 10)) {
			$('#firstnamecheck').show();
			$('#firstnamecheck').html
				("**length of firstname must be between 3 and 10");
			firstnameError = false;
			return false;
		} else {
			$('#firstnamecheck').hide();
			document.getElementById("#submitbtn").disabled = true; 
		}
	}

	// Validate lastname
	$('#lastnamecheck').hide();
	let lastnameError = true;
	$('#lastname').keyup(function() {
		validatelastname();
	});

	function validatelastname() {
		let lastnameValue = $('#lastname').val();
		if (lastnameValue.length == '') {
			$('#lastnamecheck').show();
			lastnameError = false;
			return false;
		}
		else if ((lastnameValue.length < 3) ||
			(lastnameValue.length > 10)) {
			$('#lastnamecheck').show();
			$('#lastnamecheck').html
				("**length of lastname must be between 3 and 10");
			lastnameError = false;
			return false;
		}
		else {
			$('#lastnamecheck').hide();
		}
	}

	// Validate Email
	// Validate lastname
	$('#emailvalid').hide();
	let emailError = true;
	$('#email').keyup(function() {
		validateEmail();
	});
	function validateEmail() {
		const email =
			document.getElementById('email');
		email.addEventListener('blur', () => {
			let regex =
				/^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-zA-Z]){2,7}$/;
			let s = email.value;
			if (regex.test(s)) {
				email.classList.remove(
					'is-invalid');
				emailError = true;
			}
			else {
				email.classList.add(
					'is-invalid');
				emailError = false;
				$('#emailvalid').show();
			}
		})

	}

	// Validate Password
	$('#passcheck').hide();
	let passwordError = true;
	$('#password').keyup(function() {
		validatePassword();
	});
	function validatePassword() {
		const pass =
			document.getElementById('password');
		pass.addEventListener('blur', () => {
			let regexPass = new RegExp(
				/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/);
			let s = pass.value;
			let passwordValue = $('#password').val();
			if(passwordValue.length < 8){
			if (regexPass.test(s)) {
				pass.classList.remove(
					'is-invalid');
				passError = true;
			}}
			else {
				pass.classList.add(
					'is-invalid');
				passError = false;
				$('#passcheck').show();
				document.getElementById("#submitbtn").disabled = true; 
			}
		})
	}	// Submit button
	$('#submitbtn').click(function() {
		validatefirstname();
		validatelastname();
		validatePassword();
		validateEmail();
		if ((firstnameError == true) &&
			(passwordError == true) &&
			(lastnameError == true) &&
			(emailError == true)){
				return true;
			}else {
				document.getElementById("#submitbtn").disabled = true; 
			}
	});
});
