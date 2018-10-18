<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<spring:url value="/news" var="urlNews" />
<!DOCTYPE html>
<html>
<head>
	<title>Movies</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
</head>
<body>
	<jsp:include page="${ urlRoot }includes/navbar.jsp"/>
	<section id="container" class="container">
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${ message }</div>
		</c:if>
		<form:form action="${ urlNews }/save" method="post" modelAttribute="news" class="card bg-light">
			<article class="card-header">
				<h1 class="card-title text-center">New news</h1>
			</article>
			<article class="card-body">
				<div class="form-row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="title">Title:</label>
							<form:input type="text" id="title" path="title" class="form-control" />
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
						<div class="form-group">
							<label for="title">Status:</label>
							<form:select id="status" path="status" class="form-control">
								<form:option value="ACTIVE" selected="selected">Active</form:option>
								<form:option value="INACTIVE">Inactive</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="details">Details:</label>
					<form:textarea id="details" path="details"></form:textarea>
				</div>
			</article>
			<article class="card-footer">
				<button type="submit" class="btn btn-success btn-lg">Save</button>
				&nbsp;
				<button type="reset" class="btn btn-danger btn-lg">Cancel</button>
			</article>
		</form:form>
	</section>
	<jsp:include page="${ urlRoot }includes/footer.jsp"/>
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/tinymce/tinymce.min.js"></script>
	<script type="text/javascript">
		tinymce.init({
			selector: '#details',
			plugins: "textcolor, table lists code",
			toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
				| bullist numlist outdent indent | forecolor backcolor table code"
		});
	</script>
</body>
</html>