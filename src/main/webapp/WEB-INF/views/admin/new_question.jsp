<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
 <div class="container-fluid" style="margin-left:20%">
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" method="POST" action="saveQuestion" modelAttribute="question">
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
                                    <label for="example-email" class="col-md-12">Question Name:</label>
                                    <div class="col-md-12">
                                        <form:input path="q_name" type="text" placeholder="johnathan@admin.com" class="form-control form-control-line" name="example-email" id="example-email"/> </div>
                                </div>
                                
                                <div class="form-group">
                                    <form:label path="op1" class="col-md-12">Option1:</form:label>
                                    <div class="col-md-12">
                                        <form:input path="op1" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label class="col-md-12">Option2:</label>
                                    <div class="col-md-12">
                                        <form:input path="op2" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label class="col-md-12">Option3:</label>
                                    <div class="col-md-12">
                                        <form:input path="op3" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label class="col-md-12">Option4:</label>
                                    <div class="col-md-12">
                                        <form:input path="op4" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label class="col-md-12">Answer:</label>
                                    <div class="col-md-12">
                                        <form:input path="answer" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Description:</label>
                                    <div class="col-md-12">
                                        <form:input path="desc" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">Posted By:</label>
                                    <div class="col-md-12">
                                        <form:input path="postedby" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                               
                               
                                <div class="form-group">
                                    <div class="col-sm-12">
                                    <input type="submit" class="btn btn-success" value="Submit"/>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
             
            <!-- /.container-fluid -->
</body>
</html>