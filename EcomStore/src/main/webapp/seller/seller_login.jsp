
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller login | EcomStore</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value='/css/seller/seller-style.css' />">



</head>
<body>

  <div class="page-wrapper">
    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
      </div>
    </header>

   <!-- Main  -->
   
    <main class="main-content">
      <div class="admin-dashboard">
      
        <h2>Seller Login</h2>
       
       
        <form action="seller_login" method="post" class="login-form">
          <input type="text" name="name" placeholder="name" required />
          <input type="password" name="password" placeholder="Password" required />
          <button type="submit">Login</button>
        
        <h2>${msg}</h2>
        </form>
        
      </div>
    </main>
   
   

    <!-- Footer -->
    <footer>
      <div class="container">
        <p>&copy; 2025 EcomStore Seller Panel. All rights reserved.</p>
      </div>
    </footer>
  </div>

  <script src="js/theme-toggle.js"></script>
</body>
</html>