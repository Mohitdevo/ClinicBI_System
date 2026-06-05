<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Billing & Inventory System - Dashboard</title>
    <style>
        /* Main Content */
        .main-content {
            margin-left: 220px;
            padding: 20px;
            width: 100%;
        }

        /* Header */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #fff;
            padding: 15px 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }

        /* Dashboard cards */
        .cards {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }
        .card {
            background-color: #fff;
            padding: 20px;
            flex: 1;
            min-width: 200px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card h3 {
            margin: 0;
            font-size: 18px;
            color: #555;
        }
        .card p {
            font-size: 24px;
            margin: 10px 0 0;
            color: #2c3e50;
        }

        /* Quick Actions */
        .quick-actions {
            margin-top: 30px;
        }
        .quick-actions button {
            padding: 15px 25px;
            margin-right: 15px;
            background-color: #1abc9c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .quick-actions button:hover {
            background-color: #16a085;
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
  <jsp:include page="sidebar.jsp" />
    <!-- Main Content -->
    <div class="main-content">
        <!-- Header -->
        <div class="header">
            <h1>Welcome, ${sessionScope.username}</h1>
            <div>User Role: ${sessionScope.role}</div>
        </div>

        <!-- Dashboard Cards -->
        <div class="cards">
            <div class="card">
                <h3>Patients Visit Today</h3>
                <p>${dashboardData.petientCount}</p>
            </div>
            <div class="card">
                <h3>Today's Treatment </h3>
                <p>10</p>
            </div>
            <div class="card">
                <h3>Today's Sell</h3>
                <p>₹1,250</p>
            </div>
            <div class="card">
                <h3>Today's Total Revenue</h3>
                <p>₹1,250</p>
            </div>
            <div class="card">
                <h3>Low Stock Alerts</h3>
                <p>5</p>
            </div>
        </div>

        <!-- Quick Actions -->
        <div class="quick-actions">
        <c:if test="${sessionScope.role=='ADMIN'}">
            <button onclick="goToInventory()">Add Product</button>
            <button onclick="goToReports()">Generate Report</button>
            </c:if>
            <button onclick="goToBilling()">Create Invoice</button>

        </div>
    </div>

</body>

<script>
  function goToInventory() {
    window.location.href = "inventory.jsp";
  }
   function goToBilling() {
    window.location.href = "billing.jsp";
  }
   function goToReports() {
    window.location.href = "reports.jsp";
  }
</script>

</html>
