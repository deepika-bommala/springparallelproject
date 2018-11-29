<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="for" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<for:form method="post" action="insertdata" modelAttribute="customer">
<table>
<%-- <tr>
<td>Employee Id</td>
<td><for:input path="empId"/></td>
</tr> --%>

<tr>
<td>Customer Name</td>
<td><for:input path="custName"/></td>
<td><for:errors path="custName" cssStyle="color:red" cssClass="error" /></td>
</tr>

<tr>
<td>Customer Mobile Number</td>
<td><for:input path="mobNo"/></td>
<td><for:errors path="mobNo" cssStyle="color:red" cssClass="error" ></for:errors>
</tr>


<tr>
<td>CustomerWallet Balance</td>
<td><for:input path="balance"/></td>
<td><for:errors path="balance" cssStyle="color:red" cssClass="error" ></for:errors>
</tr>


<tr>
<td><input type="submit" value="CreateAccount"></input></td>
</tr>
</table>

</for:form>

</body>
</html>