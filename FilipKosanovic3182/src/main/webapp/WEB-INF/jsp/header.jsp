<%-- 
    Document   : header
    Created on : Apr 10, 2017, 11:03:07 PM
    Author     : Filip Wolve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watch Shop</title>
        <link href="resources/css/headerCSS.css" rel="stylesheet">
        <style>
            html{
                background-color: lightgray;
            }
            .desniDeoHeadera{
                right: 0;
                float: right;
                top: 0px;
                width: 20%;
            }
            .leviDeoHeadera{
                float: left;
                width: 70%;
            }
            .leviDeoHeadera ul li{
                display: inline;
                list-style-type: none;
                margin: 3%;
                border: 1px solid white;
                padding: 5px;
            }
            header{
                height: 120px;
            }
            a{
                text-decoration: none;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <header>
            <c:set var="criterium" value="${pageContext.request.contextPath}"/>
            <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form> 
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <h1>Prodavnica satova</h1>

            <div class="leviDeoHeadera">
                <ul id="header">
                    <li><a href="criterium/brendovi">Brendovi<spring:message code="head.unosFax"/></a> </li>
                    <li><a href="criterium/narukvice">Narukvice<spring:message code="head.unosStud"/> </a></li>
                    <li><a href="criterium/staklo">Stakla<spring:message code="head.prikazFax"/></a></li>
                    <li><a href="criterium/akcija">Na akciji<spring:message code="head.prikazFax"/></a></li>
                </ul>
            </div>
            <div class="desniDeoHeadera">
                <ul>
                    <li>
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <h3>
                                ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
                            </h3>
                        </c:when>    
                        <c:otherwise>
                            <a href="login">Login</a>
                        </c:otherwise>
                    </c:choose>

                    </li>

                </ul>
            </div>
        </header>
    </body>
</html>