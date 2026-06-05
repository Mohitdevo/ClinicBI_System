<%@page import="java.text.Format"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"
uri="jakarta.tags.core" %>
<%@ page import=
"java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
LocalDateTime now =LocalDateTime.now();
DateTimeFormatter format =DateTimeFormatter.ofPattern("dd-MMM-yyyy, hh:mm a");
String date =now.format(format);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background: #f5f5f5;
            padding: 30px;
        }

        .invoice-container {
            max-width: 900px;
            margin: auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #ddd;
            padding-bottom: 15px;
        }

        .company-details h1 {
            margin-bottom: 5px;
        }

        .invoice-info {
            text-align: right;
        }

        .customer-section {
            margin: 25px 0;
            display: flex;
            justify-content: space-between;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th,
        table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        table th {
            background: #f0f0f0;
        }

        .total-section {
            margin-top: 20px;
            text-align: right;
            font-size: 22px;
            font-weight: bold;
        }

        .footer {
            margin-top: 40px;
            text-align: center;
            color: #666;
        }

        .btn-print {
            margin-top: 20px;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        @media print {
            .btn-print {
                display: none;
            }

            body {
                background: white;
                padding: 0;
            }

            .invoice-container {
                box-shadow: none;
            }
        }
    </style>
</head>
<body>

<div class="invoice-container">

    <div class="header">
        <div class="company-details">
            <h1>SP CLINIC</h1>
            <p>Bangalore, Karnataka</p>
            <p>Phone: +91 9876543210</p>
        </div>

        <div class="invoice-info">
            <h2>INVOICE</h2>
            <p>Invoice No: ${billId}</p>
            <p>Date: <%= date %></p>            		
        </div>
    </div>

    <div class="customer-section">
        <div>
            <h3>Customer Details</h3>
            <p><strong>Name:</strong> ${customer}</p>
            <p><strong>Contact:</strong>${contact}</p>
        </div>
    </div>

    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Product</th>
                <th>Qty</th>
                <th>Rate</th>
                <th>Total</th>
            </tr>
        </thead>

        <tbody>
         <c:forEach  var="it" items="${items}" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${it.productName }</td>
                <td>${it.quantity }</td>
                <td>${it.price }</td>
                <td>${it.total }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="total-section">
        Grand Total: ₹${grandTotal}
    </div>

    <div class="footer">
        <p>Thank you for visiting SP CLINIC!</p>
    </div>

    <button class="btn-print" onclick="window.print()">
        Print Invoice
    </button>

</div>

</body>
</html>

