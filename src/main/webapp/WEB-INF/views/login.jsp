<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log In</title>

    <link href="/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>

<div>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h4 class="form-heading margin-left-login">Log in</h4>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="Email"
                           autofocus="true"/><br>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                </div>
            </form>
            <h5>New User? Click <a href="/registration">here</a> to register.</h5>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

</body>
</html>
