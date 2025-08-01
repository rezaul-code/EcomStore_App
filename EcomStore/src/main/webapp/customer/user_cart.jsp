<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
    
   
    


<!-- <-- main section --> -->
<div class="main-wrapper">
  <main class="main-content">
    <div class="cart-container">
      <h2>Your Cart</h2>

      <c:if test="${empty cart_product}">
        <p>Your cart is empty.</p>
      </c:if>

      <c:if test="${not empty cart_product}">
        <!-- initialize grand total -->
        <c:set var="grandTotal" value="0" scope="page" />

        <table>
          <thead>
            <tr>
              <th style="padding: 10px 30px;">Product</th>
              <th style="padding: 10px 30px;">Quantity</th>
              <th style="padding: 10px 30px;">Unit Price</th>
              <th style="padding: 10px 30px;">Total Price</th>
              <th style="padding: 10px 30px;">Remove</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${cart_product}">
              <tr>
                <td>
                  <img src="${pageContext.request.contextPath}/${fn:escapeXml(item.p_img)}"
                       alt="${fn:escapeXml(item.p_name)}" width="100" />
                      <br>
                      ${fn:escapeXml(item.p_name)}
                      <br>
                      <br>
                </td>
                
                <input type="hidden"  ${fn:escapeXml(item.p_id)}>
                <td>${item.quantity}</td>
                <td>₹<fmt:formatNumber value="${item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
				<td>₹<fmt:formatNumber value="${item.quantity * item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                  <td> <a href="remove?p_id=${item.p_id}" class="btn" style="color:black; text-decoration:none;">❌</a></td>
              </tr>

              <!-- accumulate -->
              <c:set var="grandTotal"
                     value="${grandTotal + (item.quantity * item.price)}" />
            </c:forEach>
          </tbody>
        </table>

        <!-- summary and Buy All -->
        
          <div style="font-size:18px; font-weight:bold;">
			  Grand Total: ₹<fmt:formatNumber value="${grandTotal}" type="number" minFractionDigits="2" maxFractionDigits="2" />
			</div>

          <form action="<c:url value='checkout' />" method="get" style="margin-top: 10px;">
            <!-- include CSRF token and any necessary hidden fields here -->
            <button type="submit" class="button">Checkout</button>
          </form>
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
