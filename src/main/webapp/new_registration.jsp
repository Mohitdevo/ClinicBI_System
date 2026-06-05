<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New_Registration</title>
</head>
<style>
      .register-container{
           background-color: #fff;
           position:relative;
           left: 40vw;
           top: 15vh;
            padding: 50px 40px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            width: 350px;
            text-align: center;
      }
          .register-container input, .register-container select{
               width: 100%;
            padding: 10px 12px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 12px;
          }
          button {
            padding: 15px 25px;
            margin-right: 15px;
            background-color: #1abc9c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
</style>
<body>
 <!-- Sidebar -->
<jsp:include page="sidebar.jsp" />
    


    <!-- Main Content -->
    <form action="register" method="post">
      <div class="register-container">
        <h2>New Registration</h2>
           <input  name="Pname" type="text" placeholder="Patient name" required>
           <input  name="P_age" type="number" min="0" placeholder="Age" required>
           <input name="Pcontact" type="text" placeholder="Contact Number" required>
           <input name="P_discript" type="text" placeholder="Discription" required>
           <Select name="Pgender" class="gender-select" required>
            <option value=" ">Select Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
           </Select>
           <button>Register</button>
      </div>
      </form> 
  
</body>
</html>