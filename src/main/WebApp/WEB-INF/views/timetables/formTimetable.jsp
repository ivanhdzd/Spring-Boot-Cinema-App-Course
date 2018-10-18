<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/timetables" var="urlTimetables" />
<!DOCTYPE html>
<html>
<head>
	<title>Timetable form</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }lib/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<spring:hasBindErrors name="timetable">
			<div class="alert alert-danger" role="alert">
				There are below errors:
				<ul>
					<c:forEach items="${ errors.allErrors }" var="error">
						<li><spring:message message="${ error }"/></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${ message }</div>
		</c:if>
		<form:form action="${ urlTimetables }/save" method="post" modelAttribute="timetable" class="card bg-light">
			<article class="card-header">
				<h1 class="card-title text-center">New timetable</h1>
			</article>
			<article class="card-body">
				<div class="form-row">
					<div class="col-12 col-md-6 col-lg-4">
						<div class="form-group">
							<label for="movie">Movie:</label>
							<form:select id="movie" path="movie.id" class="form-control" items="${ movies }" itemValue="id" itemLabel="title" required="required"/>
						</div>
					</div>
					<div class="col-12 col-md-6 col-lg-4">
						<div class="form-group">
							<label for="date">Date:</label>
							<form:input id="date" path="date" class="form-control" required="required"/>
						</div>
					</div>
					<div class="col-12 col-md-6 col-lg-4">
						<div class="form-group">
							<label for="time">Time:</label>
							<form:input type="time" id="time" path="time" class="form-control" required="required"/>
						</div>
					</div>
					<div class="col-12 col-md-6 col-lg-4">
						<div class="form-group">
							<label for="room">Room:</label>
							<form:select id="room" path="room" class="form-control" required="required">
								<form:option value="Room premium">Room premium</form:option>
								<form:option value="Room 1">Room 1</form:option>
								<form:option value="Room 2">Room 2</form:option>
								<form:option value="Room 3">Room 3</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-12 col-md-6 col-lg-4">
						<div class="form-group">
							<label for="price">Price:</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">$</div>
								</div>
								<form:input type="number" id="price" path="price" class="form-control" required="required"/>
							</div>
						</div>
					</div>
				</div>
			</article>
			<article class="card-footer">
				<button type="submit" class="btn btn-success btn-lg">Save</button>
				&nbsp;
				<button type="reset" class="btn btn-danger btn-lg">Cancel</button>
			</article>
		</form:form>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#date").datepicker({ dateFormat: 'dd-mm-yy' });
		});
	</script>
</body>
</html>