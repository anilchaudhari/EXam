<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />
	<!-- Menu Page -->
		
		<tiles:insertAttribute name="menu" />
		
	<!-- Body Page -->
	
		<tiles:insertAttribute name="body" />
		
	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>
</html>