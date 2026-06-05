<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Management</title>
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

        /* Users Table */
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        table th, table td {
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
        }
        .btn-delete {
            background-color: #e74c3c;
        }
        .btn:hover {
            opacity: 0.9;
        }

        /* Add User Modal */
        .modal {
            display: none; 
            position: fixed;
            z-index: 1;
            padding-top: 100px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.5);
        }
        .modal-content {
            background-color: #fff;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            width: 400px;
        }
        .modal-content input, .modal-content select {
            width: 100%;
            padding: 8px 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .modal-content button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 24px;
            cursor: pointer;
        }
        .close:hover {
            color: black;
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
            <h1>Users Management</h1>
            <button class="btn btn-add" onclick="openModal()">Add User</button>
        </div>

        <!-- Users Table -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            
             <c:forEach var="user" items="${users}">

        <tr>
            <td>${user.uid}</td> 
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.contact}</td>
            <td>${user.role}</td>
            <td>
                 <form action="${pageContext.request.contextPath}/edituser" method="get" style="display:inline;">
                    <button type="submit"  name="id"  value="${user.uid}" class="btn btn-edit">Edit</button></form>
                    <form action="${pageContext.request.contextPath}/deleteuser" method="post" style="display:inline;"> 
                    <button type="submit" name="id"  value="${user.uid}"  onclick=" return confirm('Are you sure to Delete this user?')"class="btn btn-delete">
                    Delete</button></form>
                    </td> 
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Add User Modal -->
    <div id="addModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2>Add User</h2>
            <input type="text" placeholder="Name">
            <input type="email" placeholder="Email">
            <input type="password" placeholder="Password">
            <select>
                <option value="">Select Role</option>
                <option value="admin">Admin</option>
                <option value="staff">Staff</option>
            </select>
            <button class="btn btn-add">Save User</button>
        </div>
    </div>
    <script>
function openModal() {
    window.location.href = "addUser.jsp";
}

</script>
</body>
</html>
