<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fo:form  method="post" modelAttribute="customer" action="fundAmt">
<table>
 <tr><td>enter source mobile number:<input  type="text" name ="SmobNo" /></td></tr>
 <tr><td>enter amount:<fo:input path="balance"/>
  <tr><td>enter destination mobile number:<input type="text"  name="TmobNo"/>
 <input type="submit" value ="transfer"></td></tr>
 
 </table>
</fo:form>
</body>
</html>