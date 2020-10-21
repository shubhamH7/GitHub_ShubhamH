<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
background-color: powderblue;
font-family:sans-serif;
}
out.println{
background color:#f1f1c1;
}
</style>
<body>
<%
session=request.getSession();
out.println("Name:"+session.getAttribute("al"));
out.println();
out.println("Email:"+session.getAttribute("al1"));
out.println();
out.println("Number:"+session.getAttribute("al2"));

%>
</body>
</html>