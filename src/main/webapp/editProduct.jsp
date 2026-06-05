<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit_Product</title>
</head>
<style>
      .register-container{
           background-color: #fff;
           position:absolute;
           z-index:10;
           left: 40vw;
           top: 15vh;
            padding: 50px 40px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.5);
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
      .closeAdd{
        background:red;
        margin:0;
        color:white;
        position:absolute;
        top:0px;
        right:0px;
        }
       
</style>
<body>
 
    <!-- Main Content -->

    <form action="${pageContext.request.contextPath}/update" method="post">

      <div class="register-container">
        <h2>Edit Product</h2>
        <button type="button"  class="closeAdd" onclick="window.location.href='inventory'">X</button>
           <input  name="id" type="number" min="0"  value="${product.prod_id}" required>
           <input  name="product_name" type="text" value="${product.product_name}" required>
           <Select name="product_category" class="product-category-select" required>
            <option value=" ${product.product_category}">${product.product_category}</option>
            <option value="Surgical">Surgical</option>
            <option value="Medicines">Medicines</option>
            <option value="Lab Supplies">Lab Supplies</option>
           </Select>
           <input name="quantity" type="number"  min="0" value="${product.quantity}" required>
           <input name="price" type="number"  min="0" value="${product.price}" required>
           
           
           <button>Edit</button>
      </div>

      </form> 
      
</body>
</html>