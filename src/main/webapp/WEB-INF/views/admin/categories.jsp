<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>List Of Category</title>
</head>
<body>
           <!-- table -->
                <!-- ============================================================== -->
                <div class="row" style="margin-left:20%">
                <a href="category" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>New Category</a>
                    <div class="col-md-12 col-lg-12 col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Categories</h3>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>NAME</th>
                                            <th>ACTION</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${categories}" var="category">
									    <tr>
									        <td class="txt-oflo">
									            <c:out value="${category.cid}" />
									        </td>
									        <td class="txt-oflo">
									            <c:out value="${category.cname}" />
									        </td>
									        <td class="txt-oflo">
									        	<a href="deletecategory/<c:out value='${category.cid}'/>" >Delete</a>
									        </td>
									    </tr>
									    </c:forEach>
                                        <!-- <tr>
                                            <td>1</td>
                                            <td class="txt-oflo">C</td>
                                            <td><a href="category" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Update</a></td>
                                        </tr> -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
</body>
</html>