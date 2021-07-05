<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home Page</title>

    <link href="/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
<div>
    <jsp:include page="navbarAfterLogin.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <div class="margin-left-news-feed"><h3>News Feed</h3></div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-12">
                        <div class="question-box">
                            <c:forEach var="status" items="${statusList}">
                                <div class="single-question-box">
                                    <ul class="listStyle">
                                        <li>------------------------------------------------------------</li>
                                        <li><i class="glyphicon glyphicon-user"></i>
                                            <strong>${status.getUserName()}</strong></li>
                                        <li><i class="glyphicon glyphicon-edit"></i> ${status.getPost()}</li>
                                        <li><i class="glyphicon glyphicon-map-marker"></i> at ${status.getLocation()}</li>
                                        <li>------------------------------------------------------------</li>
                                    </ul>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>


</body>
</html>
<script type="text/javascript" src="/js/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
