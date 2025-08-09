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
         
        </div>
        <nav class="nav-links">
          <div class="account-menu">
			  <span class="account-link">My Accounts</span>
			  <div class="dropdown">
			    <a href="user_profile">Profile</a>
			    <a href="user_Cart">Cart</a>
			    <a href="user_orders">Orders</a>
			    <a href="user_wishlist">Wishlist</a>
			   
			  </div>
			</div>

          <a href="<c:url value='/logout?role=user' />">Logout</a>
        </nav>
      </div>
    </header>

    <!-- Scrollable Main Content -->
    <div class="main-wrapper">
      <main class="main-content">
       
       <form action="user_address" method="post" class="cart-container">
       		<h1>Add your Address</h1>     
       		 <h3>${status}</h3>  		
       		<input type="hidden" name="name" value="${customer}">
       		<input type="text" name="full_name" placeholder="Enter your full name">
       		<input type="text" name="street" placeholder="Enter your street">
       		<input type="text" name="city" placeholder="Enter your city">
       		<input type="text" name="state" placeholder="Enter your state">       		
       		<input type="text" name="postal_code" placeholder="Enter your postal pin code"> 
       		<input type="text" name="country" placeholder="Enter your country">
       		<button type="submit">Save Address</button>
       		
       		
       		
       </form>
      
       
       
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
