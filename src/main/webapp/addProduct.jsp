<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add_Product</title>
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
      color:red;
        position:absolute;
        top:0px;
        right:0px;
        }
       
</style>
<body>
 
    <!-- Main Content -->

    <form action="addprod" method="post">

      <div class="register-container">
        <h2>Add Product</h2>
        <button type="button"  class="closeAdd" onclick="closeModal()">X</button>
           <input  name="id" type="number" min="0"  placeholder="Product Id" required>
           <input  name="product_name" type="text" placeholder="Product Name" required>
           <Select name="product_category" class="product-category-select" required>
            <option value=" ">Select Product category</option>
            <option value="Surgical">Surgical</option>
            <option value="Medicines">Medicines</option>
            <option value="Lab Supplies">Lab Supplies</option>
           </Select>
           <input name="quantity" type="number"  min="0" placeholder="Quantity" required>
           <input name="price" type="number"  min="0" placeholder="Price" required>
           
           
           <button>Add</button>
      </div>

      </form> 
      
</body>
</html>