<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>New Category</title>
</head>
<html>
<body>
  <div class="container-fluid" style="margin-left:20%">
                <!-- /.row -->
                <!-- .row -->
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" method="POST" action="savecategory" modelAttribute="category">
                                <div class="form-group">
                                    <label class="col-md-12">Subject Name</label>
                                    <div class="col-md-12">
                                        <form:input path="categoryName" type="text" placeholder="Java" class="form-control form-control-line"/> </div>
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
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
</body>
</html>