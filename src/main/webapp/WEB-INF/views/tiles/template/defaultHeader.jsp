<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <tiles:importAttribute name="cssList"/>
 <tiles:importAttribute name="jsList"/>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/plugins/images/favicon.png" />" >
    <title>Online Examination System</title>
    <c:forEach var="css" items="${cssList}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    
   </head>
    
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part">
                    <!-- Logo -->
                    <a class="logo" href="index.html">
                        <!-- Logo icon image, you can use font-icon also --><b>
                        <!--This is dark logo icon--><img src="<c:url value="/resources/plugins/images/admin-logo.png"/>" alt="home" class="dark-logo" />
                        <!--This is light logo icon--><img src="<c:url value="/resources/plugins/images/admin-logo-dark.png"/>" alt="home" class="light-logo" />
                     </b>
                        <!-- Logo text image you can use text also --><span class="hidden-xs">
                        <!--This is dark logo text--><img src="<c:url value="/resources/plugins/images/admin-text.png"/>" alt="home" class="dark-logo" />
                        <!--This is light logo text--><img src="<c:url value="/resources/plugins/images/admin-text-dark.png"/>" alt="home" class="light-logo" />
                     </span> </a>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i class="fa fa-search"></i></a> </form>
                    </li>
                    <li>
                        <a class="profile-pic" href="#"> <img src="<c:url value="/resources/plugins/images/users/varun.jpg"/>" alt="user-img" width="36" class="img-circle"/>
                       		 <b class="hidden-xs">Steave</b>
                        </a>
                    </li>
                </ul>
            </div>
          
        </nav>
        <c:forEach var="script" items="${jsList}">
        <script src="<c:url value="${script}"/>"></script>
    	</c:forEach>
        <!-- End Top Navigation -->
 
</html>