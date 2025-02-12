<%-- 
    Document   : Cart
    Created on : Feb 9, 2025, 10:24:15 PM
    Author     : rio
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <style>
            table {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid black;
                padding: 0.5em;
            }
        </style>
    </head>

    <body>

        <h1>Shopping Cart</h1>

        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Unit Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>

            <c:choose>
                <c:when test="${empty cart.items}">
                    <tr>
                        <td colspan="5" style="text-align:center;">Cart is empty.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <td>${item.product.prodCode}</td>
                            <td>${item.product.prodName}</td>
                            <td>${item.product.prodPrice}</td>
                            <td>
                                <form action="CartServlet" method="post">
                                    <input type="hidden" name="action" value="updateQuantity">
                                    <input type="hidden" name="prodCode" value="${item.product.prodCode}">
                                    <input type="text" name="quantity" value="${item.quantity}">
                                    <input type="submit" value="update">
                                </form>
                            </td>
                            <td><a href="CartServlet?action=removeItem&prodCode=${item.product.prodCode}">Remove</a></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="4"><b>Total:</b></td>
                        <td><b>${cart.totalAmount}</b></td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>

        <h2><a href="ProductServlet">Continue Shopping</a></h2>

    </body>
</html>
