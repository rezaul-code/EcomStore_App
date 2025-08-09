<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Orders</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            text-align: center;
        }
        .no-orders {
            text-align: center;
            margin-top: 50px;
            color: gray;
        }
    </style>
</head>
<body>

    <h2>Your Orders</h2>

    <c:choose>
        <c:when test="${not empty orders}">
            <table>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total Amount</th>
                    <th>Payment Status</th>
                    <th>Shipping Address</th>
                </tr>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.orderDate}</td>
                        <td>₹${order.totalAmount}</td>
                        <td>${order.paymentStatus}</td>
                        <td>${order.shippingAddress}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <div class="no-orders">
                <p>No orders found.</p>
            </div>
        </c:otherwise>
    </c:choose>

</body>
</html>
