<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
        <div style="display:flex; gap:30px; align-items:center; flex:1; flex-wrap:wrap;">
          <h3 style="margin:0;">Welcome ${customer}</h3>
          <form action="<c:url value='/search' />" method="get" class="search-bar">
            <input type="text" name="query" placeholder="Search products..." />
            <button type="submit">🔍</button>
          </form>
        </div>
        <nav class="nav-links">
          <div class="account-menu">
			  <span class="account-link">My Accounts</span>
			  <div class="dropdown">
			    <a href="user_profile">Profile</a>
			    <a href="user_Cart">Cart</a>
			    <a href="user_orders">Orders</a>
			    <a href="user_wishlist">Wishlist</a>
			    <a href="user_address">Address</a>
			  </div>
			</div>

          <a href="<c:url value='/logout?role=user' />">Logout</a>
        </nav>
      </div>
    </header>
    
    
    
    
    
    
    
    

    <!-- Scrollable Main Content -->
    <div class="main-wrapper">
      <main class="main-content">
  <h2>Your Orders</h2>

  <c:if test="${empty orderDetails}">
    <p>You haven't placed any orders yet.</p>
  </c:if>

  <c:if test="${not empty orderDetails}">
    <table border="1" cellpadding="8" cellspacing="0" style="width:100%; border-collapse:collapse;">
      <thead>
        <tr>
          <th>Order ID</th>
          <th>Date</th>
          <th>Payment Method</th>
          <th>Total Amount</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="order" items="${orderDetails}">
          <tr>
            <td>${order.order_id}</td>
            <td>
              <fmt:formatDate value="${order.order_date}" pattern="dd-MMM-yyyy HH:mm" />
            </td>
            <td>${order.payment_method}</td>
            <td>₹${order.total_amount}</td>
            <td>${order.status}</td>
            <td><a href="cancel_order?id=${order.order_id}" class="btn">Cancel order</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <h2>${status}</h2>
  </c:if>
  
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
