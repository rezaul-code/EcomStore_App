<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String orderId = request.getParameter("orderId"); // Get order ID from URL
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Order Confirmation | EcomStore</title>
  <link rel="stylesheet" href="<c:url value='/css/customer/style.css' />">
</head>
<body>
  <div class="page-wrapper">
  
    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <div class="nav-and-welcome" style="display:flex; gap:20px; align-items:center;">
          <h3 style="margin:0;">Welcome ${customer}</h3>
          <form action="<c:url value='search' />" method="get" class="search-bar">
            <input type="text" name="query" placeholder="Search products..." />
            <button type="submit">🔍</button>
          </form>
        </div>
      </div>
    </header>
    
    <!-- Main -->
    <div class="main-wrapper">
      <main class="main-content">
        <div class="summary-title2">
          <h1>🎉 Congratulations! Your Order has been placed</h1>
          <p style="font-size:18px;">
            Your Order ID is: <strong><%= orderId %></strong>
          </p>
          <p>Thank you for shopping with us. You will receive a confirmation email shortly.</p>
        </div>

        <!-- Order Summary (Optional: fetch from DB) -->
        <div class="order-summary" style="margin-top:30px;">
          <h2>Order Summary</h2>
          <p>Products in this order will appear here.</p>
          <!-- Later: Loop through order_items and show product names, quantities, prices -->
        </div>
        
        <h1><a href="${pageContext.request.contextPath}/user/userdashboard"  class="primary-btn">Continue Shopping</a></h1>
      </main>
    </div>
    
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
