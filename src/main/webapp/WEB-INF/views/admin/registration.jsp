<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<script>
function ChangeRole() {
    var role = document.getElementById("roleId").value;
    if(role=="ROLE_STUDENT" || role=="ROLE_ADMIN")
    	document.getElementById("specializationId").disabled = true;
    else
    	document.getElementById("specializationId").disabled = false;
}
</script>



  <div class="container-fluid" style="margin-left:20%">
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" method="POST" action="save" modelAttribute="user">
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">User Id</label>
                                    <div class="col-md-12">
                                        <form:input path="userID" type="email" placeholder="johnathan@admin.com" class="form-control form-control-line" name="example-email" id="example-email"/> </div>
                                </div>
                                <div class="form-group">
                                    <form:label path="fName" class="col-md-12">First Name</form:label>
                                    <div class="col-md-12">
                                        <form:input path="fName" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Middle Name</label>
                                    <div class="col-md-12">
                                        <form:input path="mName" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Last Name</label>
                                    <div class="col-md-12">
                                        <form:input path="lName" type="text" placeholder="Johnathan Doe" class="form-control form-control-line"/> </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <form:input path="email" type="email" placeholder="johnathan@admin.com" class="form-control form-control-line" name="example-email" id="example-email"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password</label>
                                    <div class="col-md-12">
                                        <form:input path="password" type="password" value="password" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">DOB</label>
                                    <div class="col-md-12">
                                        <form:input path="DOB" type="text" placeholder="dd/mm/yyyy" class="form-control form-control-line"/> </div>
                                    </div>
                               
                                <div class="form-group">
                                    <label class="col-md-12">Phone No</label>
                                    <div class="col-md-12">
                                        <form:input path="mobile" type="text" placeholder="123 456 7890" class="form-control form-control-line"/> 
                                     </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Address</label>
                                    <div class="col-md-12">
                                        <form:textarea path="address" rows="5" class="form-control form-control-line"/>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Specialization</label>
                                    <div class="col-md-12">
                                         <form:input path="specialization" type="text" placeholder="java,.net,c++" class="form-control form-control-line" id="specializationId"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-12">Select Role</label>
                                    <div class="col-sm-12">
                                        <form:select path="role" class="form-control form-control-line" id="roleId" onchange="ChangeRole()">
                                            <option>ROLE_ADMIN</option>
                                            <option>ROLE_STUDENT</option>
                                            <option>ROLE_FACULTY</option>
                                        </form:select>
                                    </div>
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