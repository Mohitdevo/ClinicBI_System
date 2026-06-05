<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reports Page</title>
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

        /* Report Filters */
        .filters {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .filters label, .filters select, .filters input {
            margin-right: 15px;
        }
        .filters button {
            padding: 8px 15px;
            background-color: #1abc9c;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
        .filters button:hover {
            background-color: #16a085;
        }

        /* Reports Table */
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

        /* Export Buttons */
        .export-buttons {
            margin-top: 15px;
            text-align: right;
        }
        .export-buttons button {
            padding: 10px 15px;
            margin-left: 10px;
            background-color: #3498db;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
        .export-buttons button:hover {
            background-color: #2980b9;
        }

        /* Optional: Chart placeholder */
        .chart {
            margin-top: 30px;
            background-color: #fff;
            height: 300px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            display: flex;
            justify-content: center;
            align-items: center;
            color: #555;
            font-size: 18px;
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
            <h1>Reports</h1>
        </div>

        <!-- Filters Section -->
        <div class="filters">
            <label for="reportType">Report Type:</label>
            <select id="reportType">
                <option value="sales">Billing Report</option>
                <option value="inventory">Inventory Report</option>
            </select>

            <label for="fromDate">From:</label>
            <input type="date" id="fromDate">

            <label for="toDate">To:</label>
            <input type="date" id="toDate">

            <button>Generate Report</button>
        </div>

        <!-- Reports Table -->
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Product</th>
                    <th>Quantity Sold</th>
                    <th>Revenue</th>
                    <th>Remaining Stock</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Guitar</td>
                    <td>10</td>
                    <td>$2500</td>
                    <td>5</td>
                </tr>
            </tbody>
        </table>

        <!-- Export Buttons -->
        <div class="export-buttons">
            <button>Export PDF</button>
            <button>Export Excel</button>
        </div>

        <!-- Optional Chart Placeholder -->
        <div class="chart">
            Sales / Inventory Chart Placeholder
        </div>

    </div>

</body>
</html>
