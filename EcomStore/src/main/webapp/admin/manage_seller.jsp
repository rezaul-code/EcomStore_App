<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Login | EcomStore</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/admin-style.css">

</head>
<body>

  <div class="page-wrapper">

    <!-- Header -->
    <header>
      <div class="header-container">
        <div class="logo">EcomStore</div>
        <h3>Welcome ${admin}</h3>
        <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
      </div>
    </header>

    <!-- Main Content -->
 
      
<main class="main-content">
  <section class="seller-management">
    <h2>Manage Sellers</h2>

    <table class="seller-table">
      <thead>
        <tr>
          <th>Seller ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="seller" items="${sellerList}">
          <tr>
            <td>${seller.id}</td>
            <td>${seller.name}</td>
            <td>${seller.email}</td>
            <td>
              <span class="status ${seller.approved}">
                ${seller.approved}
              </span>
            </td>
            <td>
              <form action="UpdateSellerStatus" method="post" style="display:inline;">
                <input type="hidden" name="sellerId" value="${seller.id}">
                <input type="hidden" name="status" value="Approved">
                <button type="submit" class="btn btn-approve">Approve</button>
              </form>
              <form action="UpdateSellerStatus" method="post" style="display:inline;">
                <input type="hidden" name="sellerId" value="${seller.id}">
                <input type="hidden" name="status" value="Unapproved">
                <button type="submit" class="btn btn-unapprove">Unapprove</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </section>
</main>


    <!-- Footer -->
    <footer>
      <div class="container">
        <p>&copy; 2025 EcomStore Admin Panel. All rights reserved.</p>
      </div>
    </footer>

  </div>

  <!-- <script src="js/theme-toggle.js"></script> -->
</body>
</html>
