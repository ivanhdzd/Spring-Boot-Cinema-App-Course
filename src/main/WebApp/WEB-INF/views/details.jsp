<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="" var="urlRoot" />
<spring:url value="/" var="assets" />
<!DOCTYPE html>
<html>
<head>
	<title>
		Movie:
		<c:choose>
			<c:when test="${ movie != null }">
				${ movie.title }
			</c:when>
			<c:otherwise>
				Not found :(
			</c:otherwise>
		</c:choose>
	</title>
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
		<c:choose>
			<c:when test="${ movie != null }">
				<h1 class="text-center">${ movie.title }</h1>
				<hr>
				<article class="row">
					<div class="col-12 col-md-3 text-center">
						<img src="${ assets }img/movies/${ movie.image }" alt="${ movie.image }" class="d-block w-100 rounded">
					</div>
					<div class="col-12 col-md-9">
						<div class="card">
							<div class="card-header">
								<h3>Details</h3>
							</div>
							<div class="card-body">
								<strong>Director:</strong> ${ movie.detail.director}
								<br>
								<strong>Actors:</strong> ${ movie.detail.actors }
								<br>
								<strong>Classification:</strong> ${ movie.classification }
								<br>
								<strong>Duration:</strong> ${ movie.duration } minutes
								<br>
								<strong>Genre:</strong> ${ movie.genre}
								<br>
								<strong>Premiere date:</strong>
								<fmt:formatDate value="${ movie.premiereDate }" pattern="dd-MM-yyyy" />
							</div>
						</div>
					</div>
				</article>
				<hr>
				<article class="row">
					<div class="col-12 col-md-7">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Trailer</h3>
							</div>
							<div class="card-body">
								<iframe class="d-block w-100" height="400" src="${ movie.detail.trailer }"></iframe>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-5">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Synopsis</h3>
							</div>
							<div class="card-body">
								${ movie.detail.synopsis }
							</div>
						</div>
					</div>
				</article>
			</c:when>
			<c:otherwise>
				<h1>Oops! movie not found :(</h1>
			</c:otherwise>
		</c:choose>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>