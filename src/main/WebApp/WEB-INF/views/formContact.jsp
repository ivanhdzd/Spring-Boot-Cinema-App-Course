<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="" var="urlRoot" />
<!DOCTYPE html>
<html>
<head>
	<title>Contact form</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
	<link rel="stylesheet" href="${ assets }css/classes.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${ message }</div>
		</c:if>
		<form:form action="${ urlRoot }contact" class="card bg-light" modelAttribute="contact" method="post">
			<article class="card-header">
				<h1 class="card-title text-center">Contact</h1>
			</article>
			<article class="card-body">
				<div class="form-row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="name">Name:</label>
							<form:input type="text" path="name" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="email">Email:</label>
							<form:input type="email" path="email" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label for="favorite-genres">Favorite genres:</label>
							<form:select id="favorite-genres" class="form-control" path="genres" multiple="multiple" items="${ genresList }"></form:select>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<label>Your experience in this site is:</label>
						<div class="form-group">
							<div class="form-check form-check-inline pointer">
								<form:radiobutton id="rating-1" path="rating" class="form-check-input pointer" value="1"/>
								<label for="rating-1" class="form-check-label pointer">Very bad</label>
							</div>
							<div class="form-check form-check-inline pointer">
								<form:radiobutton id="rating-2" path="rating" class="form-check-input pointer" value="2"/>
								<label for="rating-2" class="form-check-label pointer">Bad</label>
							</div>
							<div class="form-check form-check-inline pointer">
								<form:radiobutton id="rating-3" path="rating" class="form-check-input pointer" value="3"/>
								<label for="rating-3" class="form-check-label pointer">Regular</label>
							</div>
							<div class="form-check form-check-inline pointer">
								<form:radiobutton id="rating-4" path="rating" class="form-check-input pointer" value="4"/>
								<label for="rating-4" class="form-check-label pointer">Good</label>
							</div>
							<div class="form-check form-check-inline pointer">
								<form:radiobutton id="rating-5" path="rating" class="form-check-input pointer" value="5"/>
								<label for="rating-5" class="form-check-label pointer">Very good</label>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<label>Do you like to get notifications about:</label>
						<div class="form-group">
							<c:forEach items="${ typeNotifications }" var="typeNotification" varStatus="status">
								<div class="form-check form-check-inline pointer">
									<form:checkbox id="notification-${ status.index }" path="notifications" class="form-check-input pointer" value="${ typeNotification }"/>
									<label for="notification-${ status.index }" class="form-check-label pointer">${ typeNotification }</label>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label for="coments">Comments:</label>
							<form:textarea id="coments" rows="4" path="comments" class="form-control"></form:textarea>
						</div>
					</div>
				</div>
			</article>
			<article class="card-footer">
				<button type="submit" class="btn btn-success btn-lg">Send</button>
				<button type="reset" class="btn btn-danger btn-lg">Cancel</button>
			</article>
		</form:form>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>