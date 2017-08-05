<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
 <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <meta Http-Equiv="Cache-Control" Content="no-cache, no-store, must-revalidate">
        <meta Http-Equiv="Expires" Content="0"> 
        <meta Http-Equiv="Pragma" Content="no-cache">

<title>Login Page</title>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}


</style>
</head>
<body onload='document.loginForm.username.focus();'class="claro" data-maq-flow-layout="true"
                    data-maq-comptype="desktop" data-maq-ws="collapse" id="myapp"
                    data-maq-appstates="{}">
					<!--<div id="underMaintenance" style="color:brown;font-size:15px;font-weight:times new roman;font-weight:bold" align="center"><marquee>Under Maintenance, visit onwards  Tuesday, 30th Dec 2014.</marquee>
					</div>-->
					<div id="content" style="display:block">
                        <form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
                            <table width="100%" cellspacing="0" cellpadding="0" align="center">
                                <tr height="200px"></tr>
                                <td  align="center">
                                    <table  align="center" cellspacing="0" cellpadding="0" style="border:1px solid #759DC0;height:250px;width:450px">
                                        <tr>
                                            <td  colspan="3" align="left" style="background-color:#ABD6Ff;height:22px;padding:3px;border-bottom:1px solid #759DC0" valign="top"><b>User Authentication</b>
                                            </td>
                                        </tr>
                                        <tr height="70px">
                                            <td colspan="3" align="center" id="login-box">
											<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if></td>
                                        </tr>

                                        <tr height="10px">
                                            <td valign="top" style="padding:5px" width="40%" align="right">Username</td>
                                            <td valign="top" style="padding:5px" align="left" width="1%">:</td>
                                            <td valign="top" style="padding:5px" align="left" width="60%">

                                                <input type="text" name="username" id="idUsername" required>	
                                            </td>
                                        </tr>

                                        <tr height="50px">
                                            <td valign="top" style="padding:5px" width="40%" align="right">Password</td>
                                            <td valign="top" style="padding:5px" align="left" width="1%">:</td>
                                            <td valign="top" style="padding:5px" align="left" width="60%">

                                                <input type="password" name="password" id="password1" required />
                                            </td>
                                        </tr>

                                        <tr>
                                            <td colspan=3 valign="top">
                                                <table width="100%" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="35%"></td>
                                                        <td width="10%" align="left"><input type="button"></td>

                                                        <td width="10%" align="left" style="padding-left: 9px"><input 
                                                            type="submit"></td>
                                                        <td width="%" style="padding-left:5px;cursor:pointer" align="left">
                                                        <!--<a style="cursor:pointer;color:#006B8F" href="/jsp/forgotpassword.html"><u>Forgot password</u></a>--></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>
                        </table>
						<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
                    </form>
                </div>

</body>
</html>