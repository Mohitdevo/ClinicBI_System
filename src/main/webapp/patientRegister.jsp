<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"
uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Management</title>
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
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        /* Inventory Table */
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        table th,
        table td {
            padding: 12px 15px;
            text-align: left;
        }

        table th {
            background-color: #1abc9c;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        /* Buttons */
        .btn {
            padding: 8px 15px;
            margin-right: 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color: white;
        }

       .btn-add {
            background-color: #1abc9c;
            
        }

        .btn-edit {
            background-color: #3498db;
            padding: 4px 10px;
        }

        .btn-delete {
            background-color: #e74c3c;
            padding: 4px 10px;
        }
        
         a{
        text-decoration:none;
        color:inherit;
        }

        .btn:hover {
            opacity: 0.9;
        }

        /* Search Box */
        .search-box {
            margin-bottom: 15px;
        }

        .search-box input[type="text"] {
            padding: 8px 12px;
            width: 250px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .search-box button {
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            background-color: #1abc9c;
            color: white;
            cursor: pointer;
        }

        .search-box button:hover {
            background-color: #16a085;
        }

        /* Add Product Modal */
       
        .close {
            color: #aaa;
            float: right;
            font-size: 24px;
            cursor: pointer;
        }

        .close:hover {
            color: black;
        }
            .popup {
            display: none;
        }
    </style>
</head>

<body>

    <!-- Sidebar -->
<jsp:include page="sidebar.jsp" />

<div id="openAdd" class="popup">
        <jsp:include page="addProduct.jsp" />
    </div>
    
    <div id="openEdit" class="popup"><jsp:include page="editProduct.jsp"></jsp:include></div>

    <!-- Main Content -->
    <div class="main-content">
        <!-- Header -->
        <div class="header">
            <h1>Patient Register</h1>
        </div>

        <!-- Search Box -->
        <div class="search-box">
        <form action="${pageContext.request.contextPath}/searchRegister" method="get">
       
            <input name="keyword" type="text" placeholder="Search product...">
            <button type="submit">Search</button>
            
            </form>
        </div>

        <!-- Inventory Table -->
        <table>
            <thead>
                <tr>
                    <th>PID</th>
                    <th>Patient Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Contact</th>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${patients}"> 
                <tr>
                    <td>${p.pid}</td>
                    <td>${p.patient_name}</td>
                    <td>${p.patient_age}</td>
                    <td>${p.patient_gender }</td>
                    <td>${p.patient_contact}</td>
                    <td>${p.patient_discript}</td>  
                    <td>${p.registerTime }</td>
                    <td>
                    <form action="${pageContext.request.contextPath}/editRegister" method="post" style="display:inline;">
                    <button type="submit"  name="pid"  value="${p.pid}" class="btn btn-edit">Edit</button></form>
                    <form action="${pageContext.request.contextPath}/deletepatient" method="post" style="display:inline;"> 
                    <button type="submit" name="pid"  value="${p.pid}"  onclick=" return confirm('Are you sure to Delete this product?')"class="btn btn-delete">
                    Delete</button></form>
                    </td>                  
                </tr>
             </c:forEach>  
            </tbody>
        </table>
    </div>
    <script src="${pageContext.request.contextPath}/js/openpop.js"></script>
     
</body>
</html>