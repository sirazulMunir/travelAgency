<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>New Post</title>

    <link href="/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
<div>
    <jsp:include page="navbarAfterLogin.jsp"></jsp:include>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <div><h3>Something in your mind!</h3></div>
                </div>
            </div>
            <hr>
            <div>
                <form action="/postStatus" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <label for="post">Write Post</label>
                        <textarea class="form-control" type="text" name="post" id="post"></textarea>
                        <span class="alert-danger">${nullPost}</span>
                    </div>

                    <div class="form-group">
                        <label for="location">Check In</label>
                        <select name="location" id="location" class="form-control">
                            <option value="">-------</option>
                            <c:forEach var="location" items="${locationList}">
                                <option value="${location.getId()}">${location.getLocation()}</option>
                            </c:forEach>
                        </select>
                        <span class="alert-danger">${nullLocation}</span>
                    </div>

                    <div class="form-group">
                        <label for="postPrivacy">Post Privacy</label>
                        <select class="form-control" name="postPrivacy" id="postPrivacy">
                            <option value="">---------</option>
                            <option value="0">Private</option>
                            <option value="1">Public</option>
                        </select>
                        <span class="alert-danger">${nullPrivacy}</span>
                    </div>

                    <input class="form-control btn btn-primary" type="submit" value="Post" name="savePost"
                           id="savePost">
                </form>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/js/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
