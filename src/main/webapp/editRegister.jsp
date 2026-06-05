<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <form action="updateRegister" method="post">
      <div class="register-container">
        <h2>Update details</h2>
           <input name=pid value="${patient.pid}" readonly>
           <input  name="Pname" type="text" value="${patient.patient_name}" required>
           <input  name="P_age" type="number" min="0" value="${patient.patient_age}"  required>
           <input name="Pcontact" type="text" value="${patient.patient_contact}" required>
           <input name="P_discript" type="text" value="${patient.patient_discript}"  required>
           <Select name="Pgender" class="gender-select" required>
            <option value="${patient.patient_gender} ">${patient.patient_gender}</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
           </Select>
           <button>Update</button>
      </div>
      </form> 
  
</body>
</html>