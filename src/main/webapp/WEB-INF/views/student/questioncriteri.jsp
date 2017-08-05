<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
</head>
<body>
 <div class="container-fluid" style="margin-left:20%">
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" method="POST" action="takeexam" modelAttribute="questionCriteria">
                                 <div class="form-group">
                                    <label class="col-sm-12">Select Category</label>
                                    <div class="col-sm-12">
                                        <form:select name="category" path="categoryId" class="form-control form-control-line">
										    <c:forEach items="${categories}" var="category">
										        <option value="${category.cid}"><c:out value="${category.cname}" /></option>
										    </c:forEach>
										</form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-12">Number Of Question</label>
                                    <div class="col-sm-12">
                                        <form:select path="numberOfQuestion" class="form-control form-control-line" >
                                            <option>3</option>
                                            <option>5</option>
                                            <option>8</option>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                    <input type="submit" class="btn btn-success" value="Start"/>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
             
            <!-- /.container-fluid -->
</body>
</html>