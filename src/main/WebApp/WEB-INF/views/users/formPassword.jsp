<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/users" var="urlUsers" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Change password</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
</head>
<body onload="addShowHidePassword('old-password', 'show-old-password-toggle'); addShowHidePassword('password', 'show-password-toggle')">
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<article class="row">
			<div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
				<form class="card bg-light" role="form" action="${ urlUsers }/change-password" method="POST" accept-charset="UTF-8">
					<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
					<div class="card-header">
						<h1 class="card-title text-center">Change password</h1>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="old-password">Old password:</label>
							<div class="input-group">
								<input type="password" id="old-password" name="old-password" class="form-control" />
								<div class="input-group-append">
									<div id="show-old-password-toggle" class="input-group-text" style="cursor: pointer">Show</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="password">New password:</label>
							<div class="input-group">
								<input type="password" id="password" name="password" class="form-control" />
								<div class="input-group-append">
									<div id="show-password-toggle" class="input-group-text" style="cursor: pointer">Show</div>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer d-flex justify-content-around">
						<button type="submit" id="submit" name="submit" class="btn btn-dark btn-lg">Save</button>
						<button type="reset" id="reset" name="reset" class="btn btn-danger btn-lg">Cancel</button>
					</div>
				</form>
				<c:if test="${ param.error != null }">
					<div class="alert alert-danger text-center mt-3" role="alert">Access denied!</div>
				</c:if>
			</div>
		</article>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ assets }js/forms/show-hide-password.js"></script>
</body>
</html>