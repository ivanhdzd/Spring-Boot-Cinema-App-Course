/** Object that works as HashMap (based in ES5) */
var elements = {};

/**
 * Initialize new show/hide password functionality to an input and it toggle button.
 * @param {string} input element ID value.
 * @param {string} button element ID value.
 */
function addShowHidePassword(input, button) {
	/** Initialize references and flags */
	elements[input] = {
		showPassword: false,
		input: document.getElementById(input),
		button: document.getElementById(button)
	};
	/** Verify that input reference was found */
	if (!elements[input].input) return console.warn('\'' + input + '\' DOM object not found.');
	/** Verify that button reference was found */
	if (!elements[input].button) return console.warn('\'' + button + '\' DOM object not found.');
	/** Adds event on click to show/hide toggle functionality works */
	elements[input].button.onclick = function () {
		/** Invert show password flag */
		elements[input].showPassword = !elements[input].showPassword;
		/** Change button value */
		elements[input].button.innerHTML = elements[input].showPassword ? 'Hide' : 'Show';
		/** Change input type */
		elements[input].input.setAttribute('type', elements[input].showPassword ? 'text' : 'password');
	};
}