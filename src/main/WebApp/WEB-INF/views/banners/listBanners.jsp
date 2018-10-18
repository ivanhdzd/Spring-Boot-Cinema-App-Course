<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/banners" var="urlBanners" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Banners list</title>
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
		<h1>Banners list</h1>
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${ message }</div>
		</c:if>
		<article class="my-2 my-md-4">
			<a class="btn btn-success btn-lg" href="${ urlBanners }/create">New banner</a>
		</article>
		<article class="card card-body" style="padding: 0">
			<div class="table-responsive height-3-over-4">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Title</th>
							<th scope="col">Status</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ banners }" var="banner">
							<tr>
								<td>${ banner.title }</td>
								<td>
									<c:choose>
										<c:when test="${ banner.status == 'ACTIVE' }">
											<label class="label label-success">Active</label>
										</c:when>
										<c:otherwise>
											<label class="label label-danger">Inactive</label>
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<a class="btn btn-success" href="${ urlBanners }">Edit</a>
									<a class="btn btn-danger" href="${ urlBanners }">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>