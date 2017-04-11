<%-- 
    Document   : prikazPoPotraznji
    Created on : Apr 11, 2017, 12:14:58 AM
    Author     : Filip Wolve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watches shop</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <table>
            <c:forEach items="${objekti}" var="post">
                <a href="/criterium/${post}">
                    <tr>
                        <td><img src="${post.picture}" height="100px" /><c:out value="${post.name}"/></td>
                    </tr>
                    <tr>
                        <td>${objekti}</td>
                    </tr>
                </a>
            </c:forEach>
        </table>

    </body>
</html>
