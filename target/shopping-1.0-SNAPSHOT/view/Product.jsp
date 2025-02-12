<%-- 
    Document   : Product
    Created on : Feb 9, 2025, 10:24:28 PM
    Author     : rio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>

        <style>

            table{

                border: 1px solid black;
                border-collapse: collapse;
            }

            th,td{

                border: 1px solid black;
                padding: 0.5em;
            }

        </style>

    </head>

    <body>

        <h1>Product List</h1>

        <table>

            <tr>

                <th>Code</th>

                <th>Description</th>

                <th>Price</th>

                <th>Action</th>

            </tr>

            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.prodCode}</td>
                    <td>${product.prodName}</td>
                    <td>${product.prodPrice}</td>
                    <td><a href="CartServlet?action=addItem&prodCode=${product.prodCode}">Add To
                            Cart</a></td>
                </tr>
            </c:forEach>

        </table>
      
    </body>

</html>
