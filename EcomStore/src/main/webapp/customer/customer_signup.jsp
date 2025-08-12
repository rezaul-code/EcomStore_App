<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Customer Sign Up | EcomStore</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer/style.css">
  <link rel="stylesheet" href="css/theme.css" />
</head>
<body>
  <div class="page-wrapper">
    
    <!-- Header -->
    <header>
      <div class="container header-container">
        <div class="logo">EcomStore</div>
        <nav class="nav-links">
          <a href="home.jsp">Home</a>
          <a href="products.jsp">Products</a>
          <a href="about.jsp">About</a>
          <a href="contact.jsp">Contact</a>
        </nav>
        <form action="search" method="get" class="search-bar">
          <input type="text" name="query" placeholder="Search products..." />
          <button type="submit">🔍</button>
        </form>
        <button id="theme-toggle">Dark Mode</button>
      </div>
    </header>

    <!-- Main Content -->
    <main class="main-content">
      <div class="container auth-container">
        <form class="auth-form" action="user_signup" method="post">
          <h2>Create Account</h2>
          <input type="text" name="name" placeholder="Full Name" required />
          <input type="email" name="email" placeholder="Email" required />
          <input type="password" name="password" placeholder="Password" required />
          <input type="text" name="phone" placeholder="Phone Number" required />
          <input type="text" name="address" placeholder="Address" required />
          <button type="submit">Sign Up</button>
          <h2>${sts}</h2>
        </form>
      </div>
    </main>

    <!-- Footer -->
    <footer>
      <div class="container footer-container">
        <div class="footer-section">
          <h4>Company</h4>
          <a href="about.jsp">About Us</a>
          <a href="careers.jsp">Careers</a>
          <a href="contact.jsp">Contact</a>
        </div>
        <div class="footer-section">
          <h4>Support</h4>
          <a href="faq.jsp">FAQ</a>
          <a href="terms.jsp">Terms</a>
          <a href="privacy.jsp">Privacy Policy</a>
        </div>
        <div class="footer-section">
          <h4>Follow Us</h4>
          <a href="#">Instagram</a>
          <a href="#">Facebook</a>
          <a href="#">Twitter</a>
        </div>
      </div>
      <div class="footer-bottom">
        &copy; 2025 EcomStore. All rights reserved.
      </div>
    </footer>
    
  </div>
   <script src="js/theme-toggle.js"></script>
</body>
</html>
