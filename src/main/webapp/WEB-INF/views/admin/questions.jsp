<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>List Of Questions</title>
</head>
<body>
           <!-- table -->
                <!-- ============================================================== -->
                <div class="row" style="margin-left:20%">
                <a href="newQuestion" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>New Question</a>
                    <div class="col-md-12 col-lg-12 col-sm-12">
                        <div class="white-box">
                           <h3 class="box-title">Questions</h3>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Question</th>
                                            <th>Posted by</th>
                                            <th>ACTION</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${questionList}" var="questions">
									    <tr>
									        <td class="txt-oflo">
									            <c:out value="${questions.q_id}" />
									        </td>
									        <td class="txt-oflo">
									            <c:out value="${questions.q_name}" />
									        </td>
									         <td class="txt-oflo">
									            <c:out value="${questions.postedby}" />
									        </td>
									        <td class="txt-oflo">
									        	<a href="deletecategory/<c:out value='${questions.q_id}'/>" >Delete</a>
									        	<a href="deletecategory/<c:out value='${questions.q_id}'/>" >Update</a>
									        </td>
									    </tr>
									    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
</body>
</html>