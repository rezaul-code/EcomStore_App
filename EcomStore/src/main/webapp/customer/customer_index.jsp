<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>EcomStore</title>
  <link rel="stylesheet" href="css/style.css"/>
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

    <!-- Main content -->
    <main class="main-content">
      <div class="container">
        <h1>Welcome to EcomStore</h1>
        <p>Start exploring products now.</p>
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
</body>
</html>
