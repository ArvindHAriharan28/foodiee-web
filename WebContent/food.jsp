<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veg</title>
</head>
<body>
	<form action="home.html">
		<button type="submit" value="back">Back</button>
	</form>
	<br>

	<form method="post" action="AddCart">
		<button type="submit" value="nonveg">NonVeg</button>
		<button type="submit" value="snacks">Snacks</button>

		<h3>List of Items</h3>

		<table>
			<thead>
				<tr>

					<th>Name</th>
					<th>Price</th>


				</tr>
			</thead>
			<tbody>

				<c:forEach var="food" items="${FOODS}">
					<tr>

						<td>${food.name}</td>
						<td>${food.price}</td>

						<td><input type="checkbox" name="foodId"
							value="${food.id}"></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<button type="submit" value="cart">Add Cart</button>
	</form>

</body>
</html>