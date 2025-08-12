<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Checkout | EcomStore</title>
  <link rel="stylesheet" href="<c:url value='/css/customer/style.css' />">
   <link rel="stylesheet" href="css/theme.css" />
</head>
<body>
<div class="page-wrapper">

  <!-- Header -->
  <header>
    <div class="header-container">
      <div class="logo">EcomStore</div>
      <div class="nav-and-welcome" style="display:flex; gap:20px; align-items:center;">
        <h3 style="margin:0;">Welcome ${customer}</h3>
        <form action="<c:url value='search' />" method="get" class="search-bar">
          <input type="text" name="query" placeholder="Search products..." />
          <button type="submit">🔍</button>
          
        </form>
        <button id="theme-toggle">Dark Mode</button>
      </div>
    </div>
  </header>

  <div class="main-wrapper">
    <main class="main-content">
      <div class="checkout-container">

        <!-- Checkout Form -->
        <form action="<c:url value='/user/placeOrder' />" method="post">

			         <!-- Shipping Address -->
			<div class="checkout-details card">
			  <h2>Checkout</h2>
			  <section class="section">
			    <h3>Shipping Address</h3>
			    <select name="address_id" required>
			      <c:forEach var="addr" items="${addressList}">
			        <option value="${addr.address_id}">
			          <c:if test="${not empty addr.full_name}">
			            ${fn:escapeXml(addr.full_name)},
			          </c:if>
			          ${fn:escapeXml(addr.street)}, 
			          ${fn:escapeXml(addr.city)}, 
			          ${fn:escapeXml(addr.state)}, 
			          ${fn:escapeXml(addr.postal_code)}, 
			          ${fn:escapeXml(addr.country)}
			        </option>
			      </c:forEach>
			    </select>
			  </section>
			


            <!-- Payment Method -->
            <section class="section">
              <h3>Payment Method</h3>
              <div class="radio-group">
                <label>
                  <input type="radio" name="paymentMethod" value="card" />
                  Credit / Debit Card
                </label>
                <label>
                  <input type="radio" name="paymentMethod" value="upi" checked/>
                  UPI
                </label>
                <label>
                  <input type="radio" name="paymentMethod" value="cod" />
                  Cash on Delivery
                </label>
              </div>
            </section>
          </div>

          <!-- Order Summary -->
          <div class="summary-panel card">
            <h3 class="summary-title">Order Summary</h3>
            <div class="summary-wrapper">
              <table class="summary-table">
                <thead>
                  <tr>
                    <th class="align-left">Item</th>
                    <th class="align-center">Qty</th>
                    <th class="align-right">Price</th>
                    <th class="align-right">Total</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="item" items="${cart_product}">
                    <tr class="item-row">
                      <td class="item-name">${fn:escapeXml(item.p_name)}</td>
                      <td class="align-center">${item.quantity}</td>
                      <td class="align-right">
                        ₹<fmt:formatNumber value="${item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                      <td class="align-right">
                        ₹<fmt:formatNumber value="${item.quantity * item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                    </tr>
                  </c:forEach>

                  <tr class="summary-row">
                    <td colspan="3" class="align-right label">Subtotal:</td>
                    <td class="align-right value">
                      ₹<fmt:formatNumber value="${grandTotal}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>

                  <c:if test="${not empty appliedDiscount}">
                    <tr class="summary-row">
                      <td colspan="3" class="align-right label">Discount:</td>
                      <td class="align-right discount">
                        - ₹<fmt:formatNumber value="${appliedDiscount}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                    </tr>
                  </c:if>

                  <tr class="summary-row">
                    <td colspan="3" class="align-right label">Shipping:</td>
                    <td class="align-right value">
                      ₹<fmt:formatNumber value="${shippingFee}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>

                  <tr class="grand-total-row">
                    <td colspan="3" class="align-right label grand-label">Grand Total:</td>
                    <td class="align-right value grand-value">
                      ₹<fmt:formatNumber value="${finalTotal}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <input type="hidden" name="grandTotal" value="${grandTotal}" />
            
             <!-- Actions -->
          <div class="actions">
            <a href="<c:url value='user_Cart' />" class="secondary-link">Edit Cart / Continue Shopping</a>
            <a href="<c:url value='userdashboard' />" class="tertiary-btn">Cancel</a>
            <button type="submit" class="primary-btn">Place Order</button>
          </div>
          
          </div>
		</div>
         
        </form>

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
<script src="js/theme-toggle.js"></script>
</body>
</html>
