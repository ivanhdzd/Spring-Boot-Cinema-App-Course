/** Dropdown state flag */
var dropdownIsOpen = false;
/** Navbar cover DOM object instance */
var navbarCover = document.getElementById('navbar-cover');
/** Navbar toggle button DOM object instance */
var navbarToggleBtn = document.getElementById('navbar-toggler-button');

/**
 * Show/hide navbar cover.
 * @returns void
 */
function showHideNavbarCover() {
	dropdownIsOpen = !dropdownIsOpen;
	if (dropdownIsOpen) navbarCover.className = 'cover cover-dark';
	else navbarCover.className = 'cover';
}

/**
 * Close navbar dropdown menu.
 * @returns void
 */
function closeDropdown() {
	if (navbarToggleBtn.getAttribute('aria-expanded') === 'false') return;
	if (window.innerWidth < 634) navbarToggleBtn.click();
	dropdownIsOpen = false;
}