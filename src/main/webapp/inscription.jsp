<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

td, th {
  padding: 9px;
}

tr:nth-child(even) {
 
}
input[type=submit] {
    width: 155px;  
}
input[type=password] {
    width: 155px;  
}
</style>
</head>
<body>
	<form action="Inscription" method="post">
	<table >
		<tr>
			<td>Nom:</td>
			<td><input type="text" name="fname"></td>
			<td></td>
		</tr>
		<tr>
			<td>Prenom:</td>
			<td><input type="text" name="lname"></td>
			<td></td>
		</tr>
		<tr>
			<td>Adresse:</td>
			<td><input type="text" name="adresse"></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="number" name="postal"></td>
			<td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td>E-mail:</td>
			<td><input type="text" name="E-mail"></td>
			<td></td>
		</tr>
		<tr>
			<td>Mot de passe:</td>
			<td><input type="password" name="mdp"></td>
			<td><input type="submit" value="Ok"></td>
			
		</tr>
		
	</table>
	
	</form>
</body>
</html>