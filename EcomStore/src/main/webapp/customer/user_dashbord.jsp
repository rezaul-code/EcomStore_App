<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <div class="container">
          <div class="dashboard-box">
            <div class="product-section">
              <h2>Explore Our Products</h2>
              <c:choose>
                <c:when test="${empty pList}">
                  <p style="text-align:center; font-size:18px;">
                    No products available right now. Please check back later.
                  </p>
                </c:when>
                <c:otherwise>
                  <div class="product-grid">
                    <c:forEach var="p" items="${pList}">
                      <div class="product-card">
                      <a href="product?p_id=${p.p_id}">
                        <img src="${pageContext.request.contextPath}/${p.p_img}" alt="${p.p_name}" />
                        </a>
                        <h3>${p.p_name}</h3>
                        <p>${p.p_description}</p>
                        <p><strong>₹ ${p.p_price}</strong></p>
                        
                        <form action="addToCart" method="get">
                          <input type="hidden" name="p_id" value="${p.p_id}" />
                          <input type="number" name="quantity" value="1" min="1" max="99" />
                           <br>
                           <br>
                           <br>
                            <br>
                           <br>
                           <br>
                           
                        	<a href="#" class="btnn">Withlist</a>
                          <br>
                          <button type="submit">Add to Cart</button>
                        </form>
                        <c:if test="${not empty msg}">
                          <div style="margin-top:8px; font-size:14px; color:green;">
                            ${msg}
                          </div>
                        </c:if>
                      </div>
                    </c:forEach>
                  </div>
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </div>
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
