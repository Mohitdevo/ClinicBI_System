<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sidebar</title>
</head>
 <link rel="stylesheet" href="style.css">
<body>
    <div class="sidebar">
        <h2>BI System</h2>
        <a href="login.jsp">Login</a>
        <a href="new_registration.jsp">New Registration</a>
        <a href="dashboard">Dashboard</a>
        <a href="billing.jsp">Billing</a>
   <c:if test="${sessionScope.role=='ADMIN'}"> 
        <a href="inventory">Inventory</a>        
        <a href="reports.jsp">Reports</a>
        <a href="viewusers">Users</a>
       </c:if> 
        <a href="patientRegister">Patient Register</a>
        <a href="logout">Logout</a>
    </div>
</body>
</html>