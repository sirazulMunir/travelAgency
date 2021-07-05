<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>My Posts</title>

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
                <div><h3>My Status List</h3></div>
            </div>
        </div>
        <hr>
        <div class="row">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <td>SL</td>
                    <td>Post</td>
                    <td>Check In</td>
                    <td>Post Privacy</td>
                    <td>Posted At</td>
                    <td>Edit Post</td>
                    <td>Change Privacy</td>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="post" items="${personalPostList}" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${post.getPost()}</td>
                        <td>${post.getLocation()}</td>
                        <td><c:choose>
                            <c:when test="${post.getPostPrivacy() == 0}">
                                Private
                            </c:when>
                            <c:otherwise>
                                Public
                            </c:otherwise>
                        </c:choose></td>
                        <td> <fmt:formatDate pattern="dd-MMMM-yyyy" value="${post.getPostDate()}" /> </td>
                        <td><a href="/editPost/${post.getPostId()}">Edit</a></td>
                        <td><a href="/changePrivacy/${post.getPostId()}">Change</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
<script type="text/javascript" src="/js/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
