<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>My Cart | EcomStore</title>
  <link rel="stylesheet" href="<c:url value='/css/customer/style.css' />">
</head>
<body>
  <div class="page-wrapper">
  
    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <div class="nav-and-welcome" style="display:flex; gap:20px; align-items:center;">
          <h3 style="margin:0;">Welcome ${customer}</h3>
          <form action="<c:url value='/search' />" method="get" class="search-bar">
            <input type="text" name="query" placeholder="Search products..." />
            <button type="submit">🔍</button>
          </form>
        </div>
      </div>
    </header>

    <!-- Scrollable Main Content -->
    <div class="main-wrapper">
      <main class="main-content">
        <div class="cart-container">
          <h2>Your Cart</h2>

          <c:if test="${empty cart_product}">
            <p>Your cart is empty.</p>
          </c:if>

          <!-- initialize grand total -->
          <c:set var="grandTotal" value="0" scope="page" />

          <c:forEach var="item" items="${cart_product}">
          <div class="cart-item">
				  <img src="${pageContext.request.contextPath}/${item.p_img}" alt="${item.p_name}" width="100" />
				
				  <div class="item-details">
				    <div class="row">
				      <div class="detail"><strong>Product Name:</strong> ${item.p_name}</div>
				      <div class="detail"><strong>Product ID:</strong> ${item.p_id}</div>
				      <div class="detail"><strong>Quantity:</strong> ${item.quantity}</div>
				      <div class="detail"><strong>Price:</strong> ₹${item.price}</div>
				    </div>
				
				    <div class="row bottom-row">
				      <div class="detail"><strong>Total:</strong> ₹${item.quantity * item.price}</div>
				      <a href="remove?p_id=${item.p_id}" class="btn">Remove</a>
				    </div>
				  </div>
				</div>


            <!-- accumulate -->
            <c:set var="grandTotal" value="${grandTotal + (item.quantity * item.price)}" />
          </c:forEach>

          <!-- summary and Buy All -->
          <c:if test="${not empty cart_product}">
            <div style="margin-top: 25px; padding-top: 15px; border-top: 1px solid #e5e5e5; display:flex; justify-content: space-between; align-items: center; flex-wrap: wrap;">
              <div style="font-size: 18px; font-weight: bold;">
                Grand Total: ₹${grandTotal}
              </div>
              <form action="<c:url value='/checkout' />" method="post" style="margin-top: 10px;">
                <!-- include any required hidden fields like cart id, CSRF token etc. -->
                <button type="submit" class="button">Buy All</button>
              </form>
            </div>
          </c:if>

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
