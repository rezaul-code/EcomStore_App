<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller Dashboard | EcomStore</title>
  <link rel="stylesheet" href="css/seller/seller-dashboard.css">
</head>
<body>

<div class="page-wrapper">
  <!-- Header -->
  <header>
    <div class="header-container">
      <div class="logo">Seller Dashboard</div>
      <div class="header-actions">
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
        <a href="seller_logout" class="btn logout-btn">Logout</a>
      </div>
    </div>
  </header>

  <!-- Sidebar + Main -->
  <div class="dashboard-wrapper">
    <aside class="sidebar">
      <ul>
        <li><a href="add_product.jsp">Add Product</a></li>
        <li><a href="view_products.jsp">My Products</a></li>
        <li><a href="orders.jsp">Orders</a></li>
        <li><a href="profile.jsp">Profile</a></li>
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

<script src="js/theme-toggle.js"></script>
</body>
</html>