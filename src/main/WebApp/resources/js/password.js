/** Password type flag */
var showPassword = false;
/** Get password input reference */
var passwordInput = document.getElementById('password');
/** Get password type toggle button reference */
var btnShowPasswordToggle = document.getElementById('show-password-toggle');
/** Add on click event to toggle input password type */
btnShowPasswordToggle.onclick = function () {
	showPassword = !showPassword;
	btnShowPasswordToggle.innerHTML = showPassword ? 'Hide' : 'Show';
	passwordInput.setAttribute('type', showPassword ? 'text' : 'password');
};