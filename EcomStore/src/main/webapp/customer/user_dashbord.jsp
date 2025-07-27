<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>User Dashboard | EcomStore</title>
  <link rel="stylesheet" href="<c:url value='/css/customer/style.css' />">
</head>
<body>
  <div class="page-wrapper">
    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <nav class="nav-links">
          <a href="<c:url value='/customer/home.jsp' />">Home</a>
          <a href="<c:url value='/customer/products.jsp' />">Products</a>
          <a href="<c:url value='/customer/orders.jsp' />">My Orders</a>
          <a href="<c:url value='/logout?role=user' />">Logout</a>
          <h3>Welcome ${customer}</h3>
        </nav>
        <form action="<c:url value='/search' />" method="get" class="search-bar">
          <input type="text" name="query" placeholder="Search products..." />
          <button type="submit">🔍</button>
        </form>
      </div>
    </header>

    <!-- Main Content -->
    <main class="dashboard-main">
      <div class="container">
        <div class="dashboard-box">
          <h1>Welcome,${name}</h1>
          <p>This is your customer dashboard.</p>
          <p>From here, you can manage your orders, view your profile, and more.</p>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <footer>
      <div class="footer-container">
        <div class="footer-section">
          <h4>Company</h4>
          <a href="<c:url value='/customer/about.jsp' />">About Us</a>
          <a href="<c:url value='/customer/contact.jsp' />">Contact</a>
        </div>
        <div class="footer-section">
          <h4>Support</h4>
          <a href="<c:url value='/customer/faq.jsp' />">FAQ</a>
          <a href="<c:url value='/customer/terms.jsp' />">Terms</a>
        </div>
        <div class="footer-section">
          <h4>Connect</h4>
          <a href="#">Instagram</a>
          <a href="#">Twitter</a>
        </div>
      </div>
      <div class="footer-bottom">
        &copy; 2025 EcomStore. All rights reserved.
      </div>
    </footer>
  </div>
</body>
</html>
