<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>
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
			<th>TranId</th>
			<th>mobileNo</th>
			<th>TranType</th>
			<th>Amount</th>

		</tr>
   <%--    <c:form action="transaction" method="post" modelAttribute="my"> --%>
		<for:forEach var="customer" items="${list}">
			<tr>
			   <td><for:out  value="${customer.tranId}"></for:out></td>
				<td><for:out value="${customer.mobileNo}"></for:out></td>
				<td><for:out value="${customer.tranType}"></for:out></td>
				<td><for:out value="${customer.amount}"></for:out></td>
			</tr>
		</for:forEach>
		<tr>
			<td colspan="5" align="center"><a href="index.jsp">Click
					Here To Go to welcome</a></td>
		</tr>
		<%-- </c:form> --%>
	</table>

</body>
</html>