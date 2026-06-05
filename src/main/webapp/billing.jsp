<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF=8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Billing Page</title>
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

/* Invoice Form */
.invoice-form {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.invoice-form input, .invoice-form select {
	padding: 8px 10px;
	margin: 5px 0;
	border-radius: 5px;
	border: 1px solid #ccc;
	width: 100%;
}

.invoice-form button {
	padding: 10px 20px;
	margin-top: 10px;
	border: none;
	border-radius: 5px;
	background-color: #1abc9c;
	color: white;
	cursor: pointer;
}

.invoice-form button:hover {
	background-color: #16a085;
}

/* Invoice Table */
table {
	width: 100%;
	border-collapse: collapse;
	background-color: #fff;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
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

/* Action Buttons */
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

.btn-generate {
	background-color: #e67e22;
}

.btn:hover {
	opacity: 0.9;
}

/* Totals Section */
.totals {
	margin-top: 15px;
	text-align: right;
}

.totals p {
	font-size: 18px;
	margin: 5px 0;
}

#result {
	width: 250px;
	max-height: 200px;
	overflow-y: auto;
	border: 1px solid #ccc;
	border-radius: 8px;
	background: white;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
	position: absolute;
	z-index: 1000;
	margin-top: 5px;
}

#result div {
	padding: 12px;
	cursor: pointer;
	border-bottom: 1px solid #eee;
	transition: 0.2s;
}

#result div:hover {
	background: #f5f5f5;
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
			<h1>Billing / Invoice</h1>
		</div>

		<!-- Invoice Form -->
		<div id="billForm">
			<div class="invoice-form">
				<h2>Create Invoice</h2>
				<form  id="billingForm" method="post" autocomplete="off" >
					<input id=custname  type="text" placeholder="Customer Name" required>
						 <input id=phone type="text" placeholder="Contact Number" required>
						 <label>choose product:</label>
						 <input type="text" id="search" autocomplete="off"
						name="searchKey" list="prodList" onkeyup="searchProduct()"
						placeholder="search..." required>
					<div id="result"></div>
					<input id="qty" type="number" placeholder="Quantity" min="1" value="" onkeyup="checkStock()" required> 
						<input id="price" type="text" value="" readonly>						
					<button type="button" class="btn btn-add" onclick="addItem()">Add
						Item</button>
				</form>
			</div>

			<!-- Invoice Table -->
			<table>
				<thead>
					<tr>
						<th>S.No.</th>
						<th>Product</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Total</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="billBody">

				</tbody>
			</table>

			<!-- Totals 
		
			<p>Subtotal: ₹1000</p>
			<p>Tax (10%): ₹100</p>-->
			<div class="totals">
				<p>
					<strong id="grandTotal" class="totals"> ₹00</strong>
				</p>
				<button type="button" class="btn btn-generate"
					onclick="generateInvoice();">Generate Invoice</button>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/fetchInventry.js"></script>
	<script src="${pageContext.request.contextPath}/js/bill.js"></script>
</body>
</html>
