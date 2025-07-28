
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller profile | EcomStore</title>
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
        <li><a href="<c:url value='/seller/add_product' />">Add Product</a></li>
        <li><a href="<c:url value='/seller/view_products' />">My Products</a></li>
        <li><a href="<c:url value='/seller/orders' />">Orders</a></li>
        <li><a href="<c:url value='/seller/profile' />">Profile</a></li>
      </ul>
    </aside>




    
    <main class="dashboard-content">
  <div class="profile-section">
    <h2>My Profile</h2>
    <hr/>

    <c:choose>
      <c:when test="${not empty sellerProfile}">
        <c:forEach var="seller" items="${sellerProfile}">
          <div class="profile-card">
            <p><strong>Name:</strong> ${seller.name}</p>
            <p><strong>Email:</strong> ${seller.email}</p>
            <p><strong>Shop Name:</strong> ${seller.shop_name}</p>
            <p><strong>Phone:</strong> ${seller.phone}</p>
            <p><strong>Address:</strong> ${seller.address}</p>
          </div>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <p>No seller profile data found.</p>
      </c:otherwise>
    </c:choose>
  </div>
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