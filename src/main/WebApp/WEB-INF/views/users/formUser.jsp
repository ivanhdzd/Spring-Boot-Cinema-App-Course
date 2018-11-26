<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="assets" />
<spring:url value="../" var="urlRoot" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>User form</title>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${ assets }lib/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ assets }css/container.css">
</head>
<body>
	<c:if test="${ user.id == 0 }">
		<script type="text/javascript" src="${ assets }js/forms/show-hide-password.js"></script>
	</c:if>
	<jsp:include page="${ urlRoot }includes/navbar.jsp" />
	<section id="container" class="container">
		<article class="row">
			<div class="col-12 col-lg-10 offset-lg-1 col-xl-8 offset-xl-2">
				<form:form class="card bg-light" role="form" action="${ formActionPostUrl }" method="POST" modelAttribute="user" accept-charset="UTF-8">
					<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
					<form:hidden id="id" path="id" />
					<c:if test="${ user.id != 0 }">
						<form:hidden id="password" path="password" />
					</c:if>
					<div class="card-header">
						<h1 class="card-title text-center">User form</h1>
					</div>
					<div class="card-body">
						<div class="form-row">
							<div class="col-12 col-sm-6 pr-sm-3">
								<div class="form-group">
									<label for="name">Name:</label>
									<form:input type="text" id="name" name="name" path="name" class="form-control" />
								</div>
							</div>
							<div class="col-12 col-sm-6 pl-sm-3">
								<div class="form-group">
									<label for="last-name">Last name:</label>
									<form:input type="text" id="last-name" name="lastName" path="lastName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-12 col-sm-6 pr-sm-3">
								<div class="form-group">
									<label for="username">Username:</label>
									<form:input type="text" id="username" name="username" path="username" class="form-control" />
								</div>
							</div>
							<div class="col-12 col-sm-6 pl-sm-3">
								<div class="form-group">
									<label for="email">Email:</label>
									<form:input type="email" id="email" name="email" path="email" class="form-control" />
								</div>
							</div>
						</div>
						<c:if test="${ user.id == 0 }">
							<div class="form-group">
								<label for="password">Password:</label>
								<div class="input-group">
									<form:input type="password" id="password" name="password" path="password" class="form-control"
										onload="addShowHidePassword('password', 'show-password-toggle')" />
									<div class="input-group-append">
										<div id="show-password-toggle" class="input-group-text" style="cursor: pointer">Show</div>
									</div>
								</div>
							</div>
						</c:if>
						<div class="form-row">
							<c:choose>
								<c:when test="${ isAdmin == true }">
									<div class="col-12 col-sm-6 pr-sm-3">
										<label for="active">Status:</label>
										<input type="text" value="Active" class="form-control" disabled>
										<form:input type="hidden" id="active" name="active" path="active" />
									</div>
									<div class="col-12 col-sm-6 pl-sm-3">
										<div class="form-group">
											<label for="roles">Roles:</label>
											<form:input type="hidden" id="roles" name="roles" path="roles" value="${ roles }" />
											<c:forEach items="${ user.roles }" var="role">
												<input type="text" id="role" value="${ role.role }" class="form-control" disabled>
											</c:forEach>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="col-12 col-sm-6 pr-sm-3">
										<label for="active">Status:</label>
										<div class="form-check">
											<form:radiobutton id="active" name="active" path="active" value="1" class="form-check-input" select="select" />
											<label for="active" class="form-check-label">Active</label>
										</div>
										<div class="form-check">
											<form:radiobutton id="inactive" name="active" path="active" value="0" class="form-check-input" />
											<label for="inactive" class="form-check-label">Inactive</label>
										</div>
									</div>
									<div class="col-12 col-sm-6 pl-sm-3">
										<div class="form-group">
											<label for="roles">Roles:</label>
											<form:select id="roles" name="roles" class="form-control" path="roles">
												<form:options items="${ rolesList }" itemValue="id" itemLabel="role" />
											</form:select>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="card-footer d-flex justify-content-around">
						<button type="submit" id="submit" name="submit" class="btn btn-dark btn-lg">Save</button>
						<button type="reset" id="reset" name="reset" class="btn btn-danger btn-lg">Cancel</button>
					</div>
				</form:form>
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
</body>
</html>