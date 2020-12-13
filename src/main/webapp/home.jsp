<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				 Mobile Management App
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Mobiles</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${mobile != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${mobile == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${mobile != null}">
            			Edit Mobile
            		</c:if>
						<c:if test="${mobile == null}">
            			Add New Mobile
            		</c:if>
					</h2>
				</caption>

				<c:if test="${mobile != null}">
					<input type="hidden" name="mobile_id" value="<c:out value='${mobile.mobile_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Reference</label> <input type="text"
						value="<c:out value='${mobile.reference}' />" class="form-control"
						name="reference" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Brand</label> <input type="text"
						value="<c:out value='${mobile.brand}' />" class="form-control"
						name="brand"  required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out value='${mobile.price}' />" class="form-control"
						name="price" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
