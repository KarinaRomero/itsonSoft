<%-- 
    Document   : cart
    Created on : 18/04/2016, 05:57:46 PM
    Author     : KarinaRomero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/estilo.css" rel="stylesheet" type="text/css"/>
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
                    <a href="#">
                        
                        <img src="img/logo.png" alt=""/>
                    </a>
                    <img src="img/logoText.png" alt=""/>
                </div>
            </div>
            <div class="contenido">
                <div id="texto1">Your shopping cart contains x Items</div>
                <div class="cajaita">
                    <div class="contenidotexto"> <a href="#">Clear cart</a></div>
                    <div class="contenidotexto"><a href="#">Continue</a></div>
                    <div class="contenidotexto"><a href="#">Proced</a></div>
                </div>
                <div class="cajaita">[subTotal]: ....</div>
                <div class="margen">
                    <table >
                        <tbody>
                            <tr>
                                <th>
                                    Product
                                </th>
                                <th>
                                    <p>Name</p>
                                </th>
                                <th>
                                    <p>Price</p>
                                </th>
                                <th>
                                    x
                                </th>
                                <th>
                                    <p>Quantity</p>
                                </th>
                            </tr>
                            <tr>
                                <td>
                                    <img> imagen
                                </td>
                                <td>
                                    <p>[product name]</p>
                                </td>
                                <td>
                                    <p>[Price]</p>
                                </td>
                                <td>
                                    <input class="numero">
                                </td>
                                <td>
                                    <button>Update</button>
                                </td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="footer"> footer</div>
    </body>
</html>
