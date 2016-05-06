<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- 
    Document   : category
    Created on : 25/04/2016, 08:19:00 PM
    Author     : KarinaRomero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
            <c:set var="view" value="/category" scope="session" />

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="../../CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
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
                    <a href="/itsonSoft">
                        
                        <img src="img/logo.png" alt=""/>
                    </a>
                    <img src="img/logoText.png" alt=""/>
                </div>
            </div>

<div id="indexLeftColumn">

    <c:forEach var="category" items="${categories}">

        <c:choose>
            <c:when test="${category.name == selectedCategory.name}">
                <div class="rounded categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='category?${category.idCategory}'/>" class="rounded categoryButton">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>

</div>

<div id="indexRightColumn">

    <p id="categoryTitle">
        <span style="background-color: #f5eabe; padding: 7px;"
              class="rounded">${selectedCategory.name}</span>
    </p>

    <table id="productTable">

        <c:forEach var="product" items="${categoryProducts}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                    <img src="${initParam.productImagePath}${product.name}.png"
                        alt="${product.name}"/>
                </td>

                <td>
                    <span class="smallText">${product.name}</span>
                </td>

                <td>${product.price}</td>

                <td>
                    <form action="#" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.idProduct}">
                        <input type="submit"
                               name="submit"
                               value="addToCart">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
        </div>
        <div id="footer"> footer</div>

    </body>
</html>
