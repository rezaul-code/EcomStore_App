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
        <li><a href="<c:url value='add_product' />">Add Product</a></li>
        <li><a href="<c:url value='seller_view_products' />">My Products</a></li>
        <li><a href="<c:url value='/seller/orders' />">Orders</a></li>
        <li><a href="<c:url value='/seller/profile' />">Profile</a></li>
      </ul>
    </aside>

     <main class="dashboard-content">
      <h2>My Products</h2>

      <c:choose>
        <c:when test="${not empty productList}">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Price</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="p" items="${productList}">
                <tr>
                  <td>${p.p_id}</td>
                  <td><img src="<c:url value='/${p.p_img}' />" alt="Product Image"></td>
                  <td>${p.p_name}</td>
                  <td>${p.p_description}</td>
                  <td>${p.p_category}</td>
                  <td>₹${p.p_price}</td>
                  <td>${p.p_status}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:when>
        <c:otherwise>
          <p class="no-data">No products found.</p>
        </c:otherwise>
      </c:choose>
   
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
