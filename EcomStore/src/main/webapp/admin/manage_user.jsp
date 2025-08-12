<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
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
  
  
<h2>Customer List</h2>

<table class="seller-table">
    <thead>
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Phone</th>
            <th>Address</th><th>Status</th><th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${userlist}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.address}</td>
                <td>
                    <span style="color:${user.status == 'eligible' ? 'green' : 'red'};">
                        ${user.status}
                    </span>
                </td>
                <td>
                    <form action="UpdateUserStatus" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="status" 
                               value="${user.status == 'eligible' ? 'blocked' : 'eligible'}">
                        <button type="submit" 
                                class="btn ${user.status == 'eligible' ? 'btn-unapprove' : 'btn-approve'}">
                            ${user.status == 'eligible' ? 'Block' : 'Unblock'}
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

  </section>
</main>


</body>
</html>
