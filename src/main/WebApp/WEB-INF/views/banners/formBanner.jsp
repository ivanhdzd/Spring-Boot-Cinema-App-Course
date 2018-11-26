<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/banners" var="urlBanners" />
<!DOCTYPE html>
<html>
<head>
	<title>Banner form</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<spring:hasBindErrors name="banner">
			<div class="alert alert-danger" role="alert">
				There are below errors:
				<ul>
					<c:forEach items="${ errors.allErrors }" var="error">
						<li><spring:message message="${ error }"/></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		<form:form action="${ urlBanners }/save" method="post" enctype="multipart/form-data" modelAttribute="banner" class="card bg-light" accept-charset="UTF-8">
			<article class="card-header">
				<h1 class="card-title text-center">New banner</h1>
			</article>
			<article class="card-body">
				<div class="form-row">
					<div class="col-12 col-sm-6 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="title">Title:</label>
							<form:input type="text" id="title" path="title" class="form-control" required="required" />
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
							<label for="image">Image:</label>
							<div class="custom-file">
								<input type="file" id="image" name="imageFile" class="custom-file-input" required="required">
								<label class="custom-file-label">Choose file</label>
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
</body>
</html>