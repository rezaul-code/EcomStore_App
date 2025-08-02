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
          <form action="<c:url value='search' />" method="get" class="search-bar">
            <input type="text" name="query" placeholder="Search products..." />
            <button type="submit">🔍</button>
          </form>
        </div>
      </div>
    </header>
    
   
    

     <div class="main-wrapper">
      <main class="main-content">
        <div class="checkout-container">
          <!-- LEFT: Shipping & Payment -->
          <div class="checkout-details card">
            <h2>Checkout</h2>

            <section class="section">
              <h3>Shipping Address</h3>
              <form id="checkout-form" action="<c:url value='/placeOrder'/>" method="post">
                <input type="hidden" name="csrf_token" value="${csrfToken}" />
                <div class="form-grid">
                  <label class="form-group">
                    <span>Full Name</span>
                    <input type="text" name="shippingName" value="${shipping.name}" required />
                  </label>
                  <label class="form-group">
                    <span>Address Line 1</span>
                    <input type="text" name="address1" value="${shipping.address1}" required />
                  </label>
                  <label class="form-group">
                    <span>Address Line 2 (optional)</span>
                    <input type="text" name="address2" value="${shipping.address2}" />
                  </label>
                  <div class="sub-grid">
                    <label class="form-group">
                      <span>City</span>
                      <input type="text" name="city" value="${shipping.city}" required />
                    </label>
                    <label class="form-group">
                      <span>State</span>
                      <input type="text" name="state" value="${shipping.state}" required />
                    </label>
                    <label class="form-group">
                      <span>ZIP / PIN</span>
                      <input type="text" name="zip" value="${shipping.zip}" required />
                    </label>
                  </div>
                  <label class="form-group">
                    <span>Phone</span>
                    <input type="tel" name="phone" value="${shipping.phone}" required />
                  </label>
                </div>

                <!-- Payment Method -->
                <section class="section">
                  <h3>Payment Method</h3>
                  <div class="radio-group">
                    <label>
                      <input type="radio" name="paymentMethod" value="card" checked />
                      Credit / Debit Card
                    </label>
                    <label>
                      <input type="radio" name="paymentMethod" value="upi" />
                      UPI
                    </label>
                    <label>
                      <input type="radio" name="paymentMethod" value="cod" />
                      Cash on Delivery
                    </label>
                  </div>
                </section>

                <input type="hidden" name="grandTotal" value="${grandTotal}" />

                <!-- Actions -->
                <div class="actions">
                  <button type="submit" class="primary-btn">Place Order</button>
                  <a href="<c:url value='/cart' />" class="secondary-link">Edit Cart / Continue Shopping</a>
                  <button type="reset" class="tertiary-btn">Cancel</button>
                </div>
              </form>
            </section>
          </div>

          <!-- RIGHT: Order Summary -->
          <div class="order-summary card">
            <h3>Order Summary</h3>
            <div class="summary-table-wrapper">
              <table class="summary-table">
                <thead>
                  <tr>
                    <th class="text-left">Item</th>
                    <th class="text-center">Qty</th>
                    <th class="text-right">Price</th>
                    <th class="text-right">Total</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="item" items="${cart_product}">
                    <tr>
                      <td>${fn:escapeXml(item.p_name)}</td>
                      <td class="text-center">${item.quantity}</td>
                      <td class="text-right">
                        ₹<fmt:formatNumber value="${item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                      <td class="text-right">
                        ₹<fmt:formatNumber value="${item.quantity * item.price}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                    </tr>
                  </c:forEach>
                  <tr class="summary-row">
                    <td colspan="3" class="text-right font-semibold">Subtotal:</td>
                    <td class="text-right">
                      ₹<fmt:formatNumber value="${grandTotal}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>
                  <c:if test="${not empty appliedDiscount}">
                    <tr>
                      <td colspan="3" class="text-right font-semibold">Discount:</td>
                      <td class="text-right discount">
                        - ₹<fmt:formatNumber value="${appliedDiscount}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                      </td>
                    </tr>
                  </c:if>
                  <tr>
                    <td colspan="3" class="text-right font-semibold">Shipping:</td>
                    <td class="text-right">
                      ₹<fmt:formatNumber value="${shippingFee}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>
                  <tr class="grand-total-row">
                    <td colspan="3" class="text-right font-bold">Grand Total:</td>
                    <td class="text-right font-large">
                      ₹<fmt:formatNumber value="${finalTotal}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <p class="small-note">
              By placing the order you agree to our 
              <a href="<c:url value='/customer/terms.jsp'/>">Terms & Conditions</a>.
            </p>
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
