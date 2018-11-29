<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="for"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>mobNo</th>
			<th>balance</th>

		</tr>

		<for:forEach var="customer" items="${customer}">
<tr>
			<td><for:out value="${customer.custName}"></for:out></td>
			<td><for:out value="${customer.mobNo}"></for:out></td>
			<td><for:out value="${customer.balance}"></for:out></td>
</tr>
		</for:forEach>
		<tr>
		<td colspan="5" align="center"><a href="index.jsp">Click Here To Go to welcome</a></td>
	</tr>
	</table>

</body>
</html>