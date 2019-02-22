<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-image: url("image/veg1.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1000px 640px;
	background-position: right;
	padding-left: 20px;
	font-size: 21px;
	padding-top: 90px;
}

table {
	border-collapse: separate;
	border-spacing: 50px 0;
}

th, td {
	padding: 10px 0;
}

h3 {
	padding-left: 80px;
}

.button {
	padding: 20px 90px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food</title>
</head>

<body>


	<form action="home.html">
		<button type="submit" value="back">Back</button>
	</form>

	<form method="post" action="AddCart">

		<h3>List of Items</h3>

		<table>
			<thead>
				<tr align="left">

					<th>Name</th>
					<th>Price</th>


				</tr>
			</thead>
			<tbody>

				<c:forEach var="food" items="${FOODS}">
					<tr>

						<td>${food.name}</td>
						<td>${food.price}</td>

						<td><input type="checkbox" name="foodId" value="${food.id}"></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br>
		<div class="button">
			<button type="submit" value="cart" style="font-size: 21px">BOOK</button>
		</div>
	</form>
	<%
		if (session.getAttribute("ERROR") != null) {
			out.println(session.getAttribute("ERROR"));
		}
	%>

</body>
</html>