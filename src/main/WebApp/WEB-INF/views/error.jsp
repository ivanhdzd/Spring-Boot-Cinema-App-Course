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
	<section id="container" class="container">
		<h1>Error</h1>
		<h2>Code: ${ statusCode }</h2>
		<c:choose>
			<c:when test="${ exception != null }">
				<p>Exception: ${ exception }</p>
			</c:when>
			<c:otherwise>
				<p>Exception: N/A</p>
			</c:otherwise>
		</c:choose>
		<button class="btn btn-info btn-lg" onclick="window.history.back()">Go back</button>
	</section>
	<script type="text/javascript" src="${ assets }lib/jquery/js/jquery-slim.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/popper.js/js/popper.umd.min.js"></script>
	<script type="text/javascript" src="${ assets }lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>