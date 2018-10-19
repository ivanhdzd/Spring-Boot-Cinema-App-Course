<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="" var="urlRoot" />
<spring:url value="/" var="assets" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Cinema App</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
	<link rel="stylesheet" href="${ assets }css/label.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<article id="carousel-banners" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<c:forEach items="${ banners }" var="banner" varStatus="status">
					<c:choose>
						<c:when test="${ status.index == 0 }">
							<li data-target="carousel-banners" data-slide-to="${ status.index }" class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="carousel-banners" data-slide-to="${ status.index }"></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ol>
			<div class="carousel-inner">
				<c:forEach items="${ banners }" var="banner" varStatus="status">
					<c:choose>
						<c:when test="${ status.index == 0 }">
							<div class="carousel-item active">
								<img class="d-block w-100" src="${ assets }img/banners/${ banner.image }" title="${ banner.title }" alt="${ banner.title }">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img class="d-block w-100" src="${ assets }img/banners/${ banner.image }" title="${ banner.title }" alt="${ banner.title }">
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#carousel-banners" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carousel-banners" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</article>
		<h1 class="text-center">Movies</h1>
		<article class="row mb-3">
			<form action="${ urlRoot }search" method="post" class="form-inline">
				<div class="form-group">
					<label for="search-date" class="mr-2">Date:</label>
					<select id="search-date" name="searchDate" class="form-control mr-2">
						<c:forEach items="${ nextDays }" var="nextDay">
							<c:choose>
								<c:when test="${ searchDate == nextDay }">
									<option value="${ nextDay }" selected>${ nextDay }</option>
								</c:when>
								<c:otherwise>
									<option value="${ nextDay }">${ nextDay }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Filter</button>
			</form>
		</article>
		<article class="row">
			<c:forEach items="${ movies }" var="movie">
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<img src="${ assets }img/movies/${ movie.image }" alt="${ movie.image }" title="${ movie.title }" class="d-block w-100 rounded">
					<h2 class="text-center">${ movie.title }</h2>
					<h5 class="text-center">
						Premiere: <fmt:formatDate value="${ movie.premiereDate }" pattern="dd-MM-yyyy" />
					</h5>
					<div class="d-flex justify-content-center">
						<label class="label label-default mr-1">${ movie.classification }</label>
						<label class="label label-default mr-1">${ movie.duration } min</label>
						<label class="label label-default mr-1">${ movie.genre }</label>
						<c:choose>
							<c:when test="${ movie.status == 'ACTIVE' }">
								<label class="label label-success">Active</label>
							</c:when>
							<c:otherwise>
								<label class="label label-danger">Inactive</label>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="d-flex justify-content-center">
						<a href="${ urlRoot }details/${ movie.id }?searchDate=${ searchDate }" class="btn btn-info">
							Check schedules
						</a>
					</div>
				</div>
			</c:forEach>
		</article>
		<h1 class="text-center">Movies</h1>
		<article class="row mb-3">
			<c:forEach items="${ newsList }" var="news" varStatus="status">
				<p>${ news }</p>
			</c:forEach>
		</article>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>