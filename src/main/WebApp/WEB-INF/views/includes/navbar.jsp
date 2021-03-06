<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="assets" />
<link rel="stylesheet" href="${ assets }css/navbar.css">
<nav id="navbar" class="navbar navbar-expand-sm navbar-dark fixed-top bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="/" onclick="closeDropdown()">Home</a>
		<button id="navbar-toggler-button" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-content"
		 aria-controls="navbar-content" aria-expanded="false" aria-label="Toggle navigation" onclick="showHideNavbarCover()">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar-content">
			<ul class="navbar-nav my-2 my-lg-0">
				<li class="nav-item"><a class="nav-link" href="/timetables/create" onclick="closeDropdown()">Timetables</a></li>
				<li class="nav-item"><a class="nav-link" href="/news/create" onclick="closeDropdown()">News</a></li>
				<li class="nav-item"><a class="nav-link" href="/banners" onclick="closeDropdown()">Banner</a></li>
			</ul>
			<ul class="navbar-nav mr-auto"></ul>
			<ul class="navbar-nav my-2 my-lg-0">
				<li class="nav-item"><a class="nav-link" href="/about" onclick="closeDropdown()">About</a></li>
				<li class="nav-item"><a class="nav-link" href="/contact" onclick="closeDropdown()">Contact</a></li>
				<li class="nav-item"><a class="nav-link" href="/sign-in" onclick="closeDropdown()">Sign in</a></li>
			</ul>
		</div>
	</div>
</nav>
<section id="navbar-cover" class="cover" onclick="closeDropdown()"></section>
<script type="text/javascript" src="${ assets }js/navbar.js"></script>