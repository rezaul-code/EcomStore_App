<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
  <div class="container">
    <h2>Manage Products</h2>
    <table class="product-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Category</th>
          <th>Price</th>
          <th>Image</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="product" items="${pList}">
          <tr>
            <td>${product.p_id}</td>
            <td>${product.p_name}</td>
            <td>${product.p_description}</td>
            <td>${product.p_category}</td>
            <td>₹${product.p_price}</td>
            <td>
              <img src="${pageContext.request.contextPath}/${product.p_img}" alt="Product Image" width="60" height="60">
            </td>
            <td>${product.p_status}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
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
