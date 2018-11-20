<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="" var="urlRoot" />
<spring:url value="/" var="assets" />
<!DOCTYPE html>
<html>
<head>
	<title>About</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
	<link rel="stylesheet" href="${ assets }css/label.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container p-1 p-sm-2 p-md-3 p-lg-4 p-xl-5">
		<article class="card bg-light">
			<div class="card-header">
				<h1 class="card-title text-center">Acerca de esta aplicaci&oacute;n</h1>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-12 col-md-6 col-lg-4 col-xl-3">
						<img src="${ assets }img/about.png" alt="About" class="d-block w-100">
					</div>
					<div class="col-12 col-md-6 col-lg-8 col-xl-9">
						<div class="card bg-light">
							<div class="card-header">
								<h2 class="card-title">Details</h2>
							</div>
							<div class="card-body">
								Here goes application details.
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>