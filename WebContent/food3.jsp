<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body  {
  background-image: url("image/veg1.jpg");
 background-repeat: no-repeat;
 background-attachment: fixed;
 background-size: 1100px 600px;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>snacks</title>
</head>

<body>
	<form action="home.html">
		<button type="submit" value="back">Back</button>
	</form>
	<br>
		<form action="food.jsp">
		<button type="submit" value="veg">Veg</button>
		</form>
		<form action ="food1.jsp">
		<button type="submit" value="nonveg">NonVeg</button>
		</form>
		
		
<form method="post" action="AddCart">
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
		
		<h2>price=${FOOD}</h2>
		<button type="submit" value="cart">Add Cart</button>
	</form>

</body>
</html>