<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add User</title>

<style>
.register-container {
	background-color: #fff;
	position: absolute;
	z-index: 10;
	left: 40vw;
	top: 15vh;
	padding: 50px 40px;
	border-radius: 10px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.5);
	width: 350px;
	text-align: center;
}

.register-container input, .register-container select {
	width: 100%;
	padding: 10px 12px;
	margin: 10px 0;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 12px;
	box-sizing: border-box;
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

.closeAdd {
	position: absolute;
	top: 10px;
	right: 10px;
	background: none;
	border: none;
	color: red;
	font-size: 18px;
	cursor: pointer;
}
</style>
</head>
<body>

	<!-- Sidebar Include -->
	<jsp:include page="sidebar.jsp" />

	<form action="updateuser" method="post">

		<div class="register-container">

			<h2>Edit User</h2>

			<button type="button" class="closeAdd" onclick="closeModal()">X</button>
             
             <input name="uid" type="text" value="${user.uid}"  readonly required>
             
			<input name="username" type="text" value="${user.username}" required>

			<input name="email" type="email" value="${user.email}"  required>

			<input name="contact" type="tel" maxlength="10" pattern="[0-9]{10}"
				value="${user.contact}"  required> <input
				name="password" type="password" value="${user.password}"  required>

			<select name="role" required>
				<option value="${user.role}">${user.role}</option>
				<option value="ADMIN">Admin</option>
				<option value="STAFF">Staff</option>
			</select>

			<button type="submit">Update User</button>

		</div>

	</form>

	<script>
		function closeModal() {
			window.location.href = "viewusers";
		}
	</script>

</body>
</html>