<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Login | EcomStore</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/admin-style.css">

</head>
<body>

  <div class="page-wrapper">

    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <h3>Welcome ${admin}</h3>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
      </div>
    </header>

    <!-- Main Content -->
    <main class="main-content">
      <div class="admin-dashboard">
        <h2>Admin Dashboard</h2>
        <div class="admin-actions">
          <a href="manage_users.jsp">Manage Users</a>
          <a href="manage_sellers.jsp">Manage Sellers</a>
          <a href="view_orders.jsp">View Orders</a>
          <a href="${pageContext.request.contextPath}/logout?role=admin">Logout</a>
        </div>
      </div>
    </main>


    <!-- Footer -->
    <footer>
      <div class="container">
        <p>&copy; 2025 EcomStore Admin Panel. All rights reserved.</p>
      </div>
    </footer>

  </div>

  <!-- <script src="js/theme-toggle.js"></script> -->
</body>
</html>
