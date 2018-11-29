<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="for"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  method="post" modelAttribute="customer" action="depositamount">
<table>
 <tr><td>enter mobile number:<form:input path ="mobNo" /></td></tr>
 <tr><td>enter deposit amount:<form:input path="balance"/>
 <input type="submit" value ="Deposit"></td></tr>
 
 </table>
</form:form>
</body>
</html>