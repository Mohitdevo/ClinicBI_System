<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Clinic Billing & Inventory System</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(
    135deg,#1abc9c,#16a085);
}

.login-container{
    background:#fff;
    width:420px;
    padding:40px 35px;
    border-radius:15px;
    box-shadow:0 10px 25px
    rgba(0,0,0,0.2);
    text-align:center;
}

.system-title{
    color:#1abc9c;
    font-size:28px;
    font-weight:bold;
    margin-bottom:8px;
}

.subtitle{
    color:#666;
    font-size:15px;
    margin-bottom:30px;
}

.welcome-text{
    font-size:18px;
    font-weight:bold;
    color:#333;
    margin-bottom:25px;
}

.input-group{
    position:relative;
    margin-bottom:18px;
}

.login-container input{
    width:100%;
    padding:14px 15px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    font-size:15px;
    transition:0.3s;
}

.login-container input:focus{
    border-color:#1abc9c;
    box-shadow:0 0 5px
    rgba(26,188,156,0.4);
}

.login-btn{
    width:100%;
    padding:14px;
    border:none;
    border-radius:8px;
    background:#1abc9c;
    color:white;
    font-size:17px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

.login-btn:hover{
    background:#16a085;
}

.footer-text{
    margin-top:20px;
    color:#777;
    font-size:13px;
}

</style>
</head>

<body>

<div class="login-container">

    <div class="system-title">
        Clinic Management
    </div>

    <div class="subtitle">
        Billing & Inventory Management System
    </div>

    <div class="welcome-text">
        Welcome Back!
    </div>
   <%String msg=request.getParameter("msg");
             if("invalid".equals(msg)){%>
                <p class="error-message" style="color:red;">Incorrect username or password</p>
           <%} %>
    <form action="login" method="post">

        <div class="input-group">
            <input type="email"
            name="email"
            placeholder="Enter Email"
            required>
        </div>

        <div class="input-group">
            <input type="password"
            name="password"
            placeholder="Enter Password"
            required>
        </div>

        <button type="submit"
        class="login-btn">
            Login
        </button>

    </form>

    <div class="footer-text">
        Secure access for Admin & Staff
    </div>

</div>

</body>
</html>