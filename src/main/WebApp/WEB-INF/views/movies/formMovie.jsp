<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/movies" var="urlMovies" />
<!DOCTYPE html>
<html>
<head>
	<title>Movie form</title>
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
		<spring:hasBindErrors name="movie">
			<div class="alert alert-danger" role="alert">
				There are below errors:
				<ul>
					<c:forEach items="${ errors.allErrors }" var="error">
						<li><spring:message message="${ error }"/></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		<form:form action="${ urlMovies }/save" method="post" enctype="multipart/form-data" modelAttribute="movie" class="card bg-light">
			<form:hidden path="id"/>
			<form:hidden path="detail.id"/>
			<article class="card-header">
				<h1 class="card-title text-center">Movie form</h1>
			</article>
			<article class="card-body">
				<div class="form-row">
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<img src="${ assets }img/movies/${ movie.image }" alt="${ movie.image }" title="${ movie.title }" class="d-block w-100 rounded">
					</div>
				</div>
				<div class="form-row">
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="title">Title:</label>
							<form:input type="text" id="title" path="title" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="duration">Duration:</label>
							<div class="input-group">
								<form:input type="number" id="duration" path="duration" class="form-control" required="required" />
								<div class="input-group-append">
									<span class="input-group-text">min</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="classification">Classification:</label>
							<form:select id="classification" path="classification" class="form-control" required="required">
								<form:option value="A" selected="selected">Classification A</form:option>
								<form:option value="B">Classification B</form:option>
								<form:option value="C">Classification C</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="genre">Genre:</label>
							<form:select id="genre" path="genre" class="form-control" items="${ genres }" required="required"></form:select>
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="title">Status:</label>
							<form:select id="status" path="status" class="form-control" required="required">
								<form:option value="ACTIVE" selected="selected">Active</form:option>
								<form:option value="INACTIVE">Inactive</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="premiere-date">Premiere date:</label>
							<form:input type="text" id="premiere-date" path="premiereDate" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="image">Image:</label>
							<form:hidden path="image"/>
							<div class="custom-file">
								<input type="file" id="image" name="imageFile" class="custom-file-input" />
								<label class="custom-file-label">Choose file</label>
							</div>
						</div>
					</div>
					<hr class="col-12">
					<h2 class="col-12">Details:</h2>
					<div class="col-12 col-sm-6 col-md-4">
						<div class="form-group">
							<label for="director">Director:</label>
							<form:input type="text" id="director" path="detail.director" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-8">
						<div class="form-group">
							<label for="actors">Actors:</label>
							<form:input type="text" id="actors" path="detail.actors" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label for="trailer">Trailer:</label>
							<form:input type="text" id="trailer" path="detail.trailer" class="form-control" required="required" />
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label for="synopsis">Synopsis:</label>
							<form:textarea id="synopsis" rows="4" path="detail.synopsis" class="form-control" required=""></form:textarea>
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
			$("#premiere-date").datepicker({ dateFormat: 'dd-mm-yy' });
		});
	</script>
</body>
</html>