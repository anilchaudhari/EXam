<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 
 </head>

    <div id="wrapper">
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Admin Control</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                    <li style="padding: 70px 0 0;">
                        <a href="admin" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="profile" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Profile</a>
                    </li>
                    <li>
                        <a href="categories" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Category</a>
                    </li>
                    <li>
                        <a href="questions" class="waves-effect"><i class="fa fa-font fa-fw" aria-hidden="true"></i>Questions</a>
                    </li>
                    <li>
                        <a href="users" class="waves-effect"><i class="fa fa-globe fa-fw" aria-hidden="true"></i>Users</a>
                    </li>
                    <li>
                        <a href="" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>Blank Page</a>
                    </li>
                    <li>
                      <a href="<c:url value="/logout" />" class="waves-effect" ><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>Logout</a>
                    </li>
                </ul>
              
            </div>
        </div>
       
    </div>
   
</html>
