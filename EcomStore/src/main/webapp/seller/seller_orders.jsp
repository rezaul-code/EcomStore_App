<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller Dashboard | EcomStore</title>
  <!-- Proper dynamic path for CSS -->
  <link rel="stylesheet" href="<c:url value='/css/seller/seller-style.css' />">
</head>
<body>

<div class="page-wrapper">
  <!-- Header -->
  <header>
    <div class="header-container">
      <div class="logo">EcomStore</div>
      
      <h2>Welcome ${seller}</h2>
      <div class="header-actions">
      
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
        <a href="<c:url value='/logout?role=seller' />" class="btn logout-btn">Logout</a>
      </div>
    </div>
  </header>

  <!-- Sidebar + Main -->
  <div class="dashboard-wrapper">
    <aside class="sidebar">
      <ul>
        <li><a href="<c:url value='add_product' />">Add Product</a></li>
        <li><a href="<c:url value='seller_view_products' />">My Products</a></li>
        <li><a href="<c:url value='/seller/orders' />">Orders</a></li>
        <li><a href="<c:url value='/seller/profile' />">Profile</a></li>
      </ul>
    </aside>

    	
    <main class="dashboard-content">
    <h2>My Orders</h2>

    <c:if test="${empty list}">
        <p>No orders found for your products.</p>
    </c:if>

    <c:if test="${not empty list}">
        <table class="order-table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Product Image</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Buyer</th>
                    <th>Payment Method</th>
                    <th>Total Amount</th>
                    <th>Order Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${list}">
                    <tr>
                        <td>${order.order_id}</td>
                        <td>
                            <img src="<c:url value='${order.img_path}' />" 
                                 alt="${order.name}" 
                                 class="product-img" />
                        </td>
                        <td>${order.name}</td>
                        <td>${order.description}</td>
                        <td>${order.category}</td>
                        <td>₹${order.price}</td>
                        <td>${order.quantity}</td>
                        <td>${order.username}</td>
                        <td>${order.payment_method}</td>
                        <td>₹${order.total_amount}</td>
                        <td>${order.order_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</main>
    
  

  <!-- Footer -->
  <footer>
    <p>&copy; 2025 EcomStore Seller Panel. All rights reserved.</p>
  </footer>
</div>

<!-- JS with proper dynamic path -->
<script src="<c:url value='/js/theme-toggle.js' />"></script>
</body>
</html>
