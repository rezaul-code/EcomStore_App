<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Product | EcomStore</title>
  <!-- Proper dynamic path for CSS -->
  <link rel="stylesheet" href="<c:url value='/css/seller/seller-style.css' />">
</head>
<body>

<div class="page-wrapper">
  <!-- Header -->
  <header>
    <div class="header-container">
      <div class="logo">EcomStore</div>
      <div class="header-actions">
      <h3>Welcome ${seller}</h3>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
        <a href="<c:url value='/logout?role=seller' />" class="btn logout-btn">Logout</a>
      </div>
    </div>
  </header>
  
  
  <!-- Sidebar + Main -->
  <div class="dashboard-wrapper">
    <aside class="sidebar">
      <ul>
        <li><a href="<c:url value='add_product' />">Add Product</a></li>
        <li><a href="<c:url value='seller_view_products' />">My Products</a></li>
        <li><a href="<c:url value='/seller/orders' />">Orders</a></li>
        <li><a href="<c:url value='/seller/profile' />">Profile</a></li>
      </ul>
    </aside>

  
  <main class="main-content">
      <div class="form-container">
        <h2>Add Product</h2>
        
        
        <form action="add_product" method="post" enctype="multipart/form-data">
        
           <label for="p_name">Product Name:</label>
          <input type="text" name="p_name" placeholder="enter product name" required>
          
          <label for="p_description">Product Description:</label>
          <input type="text" name="p_description" placeholder="describe" required>
          
          <label for="category">Category:</label>
          
          <select name="category" required="required">
          		<option>Select Categogy </option>
			    <option value="books">Books</option>
			    <option value="electronics">Electronics</option>
			    <option value="clothing">Clothing</option>
		  </select>
          <br>
          <br>
           <label for="p_price">Enter Price:</label>
          <input type="text" name="p_price" placeholder="enter product price" required>
          
          <label for="product_image">Choose Product Image:</label>
          <input type="file" name="product_image" accept="image/*" required="required">
          
          <button type="submit">Submit</button>
          
        </form>
        
        
        
      </div>
      
      <div>${Message} </div>
    </main>
  
  

  <!-- Footer -->
  <footer>
    <p>&copy; 2025 EcomStore Seller Panel. All rights reserved.</p>
  </footer>
</div>

<!-- JS with proper dynamic path -->
<script src="<c:url value='/js/theme-toggle.js' />"></script>
</body>
</html>
