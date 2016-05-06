<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- 
    Document   : index
    Created on : 18/04/2016, 05:57:32 PM
    Author     : KarinaRomero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var='view' value='/index' scope='session' />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <title>ITSONSoftbean</title>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="widgeBar">
                    <div class="headerWidget">
                        [languaje toggle]
                    </div>
                    <div class="headerWidget">
                        <img src="img/cart.gif" alt=""/>
                    </div>
                    <a href="#">

                        <img src="img/logo.png" alt=""/>
                    </a>
                    <img src="img/logoText.png" alt=""/>
                </div>
            </div>
            <%-- <sql:query var="categories" dataSource="jdbc/itsonsoftbean">
                SELECT * FROM category
            </sql:query> --%>

            <div id="indexLeftColumn"> 
                <div id="welcomeText">
                           <p style="font-size: larger">Bienvenido</p>
                </div>

            </div>
            <div id="indexRightColumn">
                <c:forEach var="category" items="${categories}">
                    <div class="categoryBox">
                        <a href="<c:url value='category?${category.idCategory}'/>">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.name}</span>

                            <img src="${initParam.categoryImagePath}${category.name}.jpg"
                                 alt="<fmt:message key='${category.name}'/>" class="categoryImage">
                        </a>
                    </div>
                </c:forEach>


            </div>

        </div>
        <div id="footer"> footer</div>
    </body>
</html>
