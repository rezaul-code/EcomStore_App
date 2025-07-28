<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>EcomStore | Customer Login</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer/style.css">
  <style>
    .main-content {
      padding: 40px 0;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      min-height: 70vh;
    }

    .main-content form {
      display: flex;
      flex-direction: column;
      gap: 15px;
      width: 100%;
      max-width: 400px;
    }

    .main-content input,
    .main-content button {
      padding: 10px 15px;
      font-size: 16px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    .main-content button {
      background-color: #f4b400;
      color: #000;
      cursor: pointer;
      font-weight: bold;
      border: none;
    }

    .main-content h1 {
      margin-bottom: 20px;
    }

    .main-content h2 {
      color: green;
      font-size: 16px;
    }
  </style>
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
          <a href="logout.jsp">Logout</a>
        </nav>
        <form action="search" method="get" class="search-bar">
          <input type="text" name="query" placeholder="Search products..." />
          <button type="submit">🔍</button>
        </form>
      </div>
    </header>

    <!-- Main Content -->
    <main class="main-content">
      <h1>Welcome to EcomStore</h1>
      <form action="user_login" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
        <h2>${sts}</h2>
      </form>
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
</body>
</html>
