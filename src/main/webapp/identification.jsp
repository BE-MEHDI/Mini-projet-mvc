<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Identification</title>
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
	<form action="Identification" method="post">
	<table>
		<tr>
			<td>E-mail:</td>
			<td><input type="text" name="E-mail"> </td>
		</tr>
		<tr>
			<td>Mot de passe:</td>
			<td><input type="password" name="mdp"></td>
			<td><input type="button" value="Ok"></td>
		</tr>
	
	</table>
	</form>
</body>
</html>