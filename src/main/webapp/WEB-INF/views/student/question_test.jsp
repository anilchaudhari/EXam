<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	
</head>
<body>
           <!-- table -->
                <!-- ============================================================== -->
                <% int count=0; %> 
                <div class="row" style="margin-left:20%">
                    <div class="col-md-12 col-lg-12 col-sm-12">
                        <div class="white-box">
                        <form:form class="form-horizontal form-material" method="POST"  modelAttribute="question">
                        		 <c:if test = "${counter !=0}">
							   		<div id="remain" style="background-color:#ffe6e6;width:20%;float: right;text-align:center;"></div>
							   	 </c:if>
                            <c:if test = "${counter == 0}">
						         <p style="color: red;">There is no questions available for this category. report to admin<p>
					        </c:if>
                            <div></div>
                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                    <c:forEach items="${questionsList}" var="questions">
									    <tr >
									        <td colspan="2" >
									            <h3 class="bg-warning">Q.<%=++count %>&nbsp;<c:out value="${questions.q_name}" /></h3>
									        </td>
									        
									     </tr>
									     <tr>
									        <td>
									           <input type="radio"  name="<c:out value="${questions.q_id}" />" value=" <c:out value="${questions.q_id}" />:<c:out value="${questions.op1}"/>">&nbsp;<c:out value="${questions.op1}"></c:out>
									        </td>
									        <td >
									            <input type="radio"  name="<c:out value="${questions.q_id}" />" value=" <c:out value="${questions.q_id}" />:<c:out value="${questions.op2}" />">&nbsp;<c:out value="${questions.op2}"></c:out>
									        </td>
									     </tr>
									     <tr>
									        <td >
									            <input type="radio"  name="<c:out value="${questions.q_id}" />" value=" <c:out value="${questions.q_id}" />:<c:out value="${questions.op3}" />">&nbsp;<c:out value="${questions.op3}"></c:out>
									        </td>
									        <td >
									            <input type="radio"  name="<c:out value="${questions.q_id}" />" value=" <c:out value="${questions.q_id}" />:<c:out value="${questions.op4}" />">&nbsp;<c:out value="${questions.op4}"></c:out>
									        </td>
									     </tr>
									    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                <input type="button" id="submittest" class="btn btn-success" value="Submit" "/>
                                </div>
                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
</body>
<script type="text/javascript">
$('document').ready(function(){
	//$('td .h3').css('background-color','gray');
	$('input[type="radio"]').children().css('font-size','40px');
	$('input[type="radio"]').css('height','18px');
	$('input[type="radio"]').css('width','18px');
		var arr = []; 
	    $("#submittest").click(function(){
    	alert("Heloooooooooooo:"+this.value);
    	$('input[type="radio"]:checked').each(function(){
    		   arr.push($(this).val());  //push values in array
    		}); 
    	alert(arr);
    }); 
   
});
var loopbackTime = 1000;

var minutes = 3;
var seconds = 0;
 
function setCountDown ()
{
                if (seconds < 0)
                {
                                minutes--;
                                seconds = 59
                }
                if (minutes < 0)
                {
                                minutes = 59
                }
               
                document.getElementById("remain").innerHTML = "minutes : " + minutes +" | seconds :" + seconds  ;
                SD=window.setTimeout( "setCountDown()", loopbackTime );
                if (minutes == 0 && seconds == 0)
                {
                                                window.clearTimeout(SD);
                                                window.alert("Time is up. Press OK to continue."); // change timeout message as required
                                                //window.location = "http://www.lucknowmail.com" // Add your redirect url
                                                //SubmitForm();
                }
 
                if(minutes ==2 && seconds == 0)
                {
                                document.getElementById("remain").style.backgroundColor  = "yellow";
                               
                }
                seconds--;
}
 
setTimeout( "setCountDown()", loopbackTime );
 
 

</script>
</html>