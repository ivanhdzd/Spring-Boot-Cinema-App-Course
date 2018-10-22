<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/movies" var="urlMovies" />
<!DOCTYPE html>
<html>
<head>
	<title>Movies list</title>
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
		<h1>Movies list</h1>
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${ message }</div>
		</c:if>
		<article class="my-2 my-md-4">
			<a class="btn btn-success btn-lg" href="${ urlMovies }/create">New movie</a>
		</article>
		<article class="card card-body" style="padding: 0">
			<div class="table-responsive height-3-over-4">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Title</th>
							<th scope="col">Genre</th>
							<th scope="col">Classification</th>
							<th scope="col">Duration</th>
							<th scope="col">Premiere date</th>
							<th scope="col">Status</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ movies.content }" var="movie">
							<tr>
								<td>${ movie.title }</td>
								<td>${ movie.genre }</td>
								<td>${ movie.classification }</td>
								<td>${ movie.duration } min.</td>
								<td><fmt:formatDate value="${ movie.premiereDate }" pattern="dd-MM-yyyy"/></td>
								<td>
									<c:choose>
										<c:when test="${ movie.status == 'ACTIVE' }">
											<label class="label label-success">Active</label>
										</c:when>
										<c:otherwise>
											<label class="label label-danger">Inactive</label>
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<a class="btn btn-success" href="${ urlMovies }/edit/${ movie.id }">Edit</a>
									<a class="btn btn-danger" href="${ urlMovies }/delete/${ movie.id }" onclick="return confirm('Do you sure to want to delete this movie?')">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
		<nav aria-label="movies pagination" class="my-3 my-md-5">
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${ movies.number - 1 >= 0 }">
						<li id="pagination-btn-previous" class="page-item">
							<a href="${ urlMovies }?page=${ movies.number - 1 }" class="page-link" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li id="pagination-btn-previous" class="page-item disabled">
							<a href="#" class="page-link" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
							</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ movies.number + 1 < movies.totalPages }">
						<li id="pagination-btn-next" class="page-item">
							<a href="${ urlMovies }?page=${ movies.number + 1 }" class="page-link" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Next</span>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li id="pagination-btn-next" class="page-item disabled">
							<a href="#" class="page-link" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Next</span>
							</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp" />
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>