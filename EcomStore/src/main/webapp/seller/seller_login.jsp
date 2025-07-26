<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller Sign Up | EcomStore</title>
  <link rel="stylesheet" href="css/seller/seller-style.css">
</head>
<body>

  <div class="page-wrapper">
    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">Seller Panel</div>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
      </div>
    </header>

   <!-- Main  -->
   
    <main class="main-content">
      <div class="admin-dashboard">
      
        <h2>Seller Login</h2>
        <form action="seller_login" method="post" class="login-form">
          <input type="text" name="username" placeholder="Username" required />
          <input type="password" name="password" placeholder="Password" required />
          <button type="submit">Login</button>
          
          
          <div style="margin-top: 10px; color: red;">
            ${msg}
          </div>
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