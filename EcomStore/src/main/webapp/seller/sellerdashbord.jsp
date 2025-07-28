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
      <div class="header-actions">
      <h3>Welcome ${seller}</h3>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
        <a href="<c:url value='/logout?role=seller' />" class="btn logout-btn">Logout</a>
      </div>
    </div>
  </header>

  <!-- Sidebar + Main -->
  <div class="dashboard-wrapper">
    <aside class="sidebar">
      <ul>
        <li><a href="<c:url value='/seller/add_product.jsp' />">Add Product</a></li>
        <li><a href="<c:url value='/seller/view_products.jsp' />">My Products</a></li>
        <li><a href="<c:url value='/seller/orders.jsp' />">Orders</a></li>
        <li><a href="<c:url value='/seller/profile.jsp' />">Profile</a></li>
      </ul>
    </aside>

    <main class="dashboard-content">
      <h2>Welcome, ${sellerName}!</h2>
      <p>This is your seller dashboard. Use the menu to manage your products, view orders, and update your profile.</p>
    </main>
  </div>

  <!-- Footer -->
  <footer>
    <p>&copy; 2025 EcomStore Seller Panel. All rights reserved.</p>
  </footer>
</div>

<!-- JS with proper dynamic path -->
<script src="<c:url value='/js/theme-toggle.js' />"></script>
</body>
</html>
