<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Update Post</title>

    <link href="/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
<div>
    <jsp:include page="navbarAfterLogin.jsp"></jsp:include>
</div>
<div class="container">
    <div class="col-md-3"></div>

    <div class="col-md-6">
        <div class="row">
            <div class="col-md-12">
                <div><h4>Update Status</h4></div>
            </div>
        </div>
        <hr>
        <div class="row">
            <form action="/updatePost" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="postId" value="${postId}">
                <div class="form-group">
                    <label class="form-control" for="post">Status</label>
                    <textarea class="form-control" type="text" name="post" id="post">${post}</textarea>
                </div>

                <input class="form-control btn btn-primary" type="submit" value="Update Post" name="updatePost"
                       id="updatePost">
            </form>
        </div>
    </div>
    <div class="col-md-3"></div>

</div>
</body>
</html>
<script type="text/javascript" src="/js/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
