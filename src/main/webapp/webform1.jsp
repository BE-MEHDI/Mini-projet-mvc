<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

td, th {
  padding: 9px;
}
h1{
  text-align: center;
}
</style>
<title>WebForm1</title>
</head>
<body >
<h1><em><strong>Catalogue</strong></em></h1>
<label for="categorie">Choisissez la categorie:</label>
<select id="cat" name="cat">
  <option value="book">Book</option>  
</select><br><br>

<table style="border-collapse: collapse; width: 100%; height: 68px;" border="1">
	<tbody>
		<tr>
			<th>Reference</th>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Photo</th>
			<th>Prix</th>
		</tr>
		<c:forEach begin="1" end="${3}" step="1">
		<tr>
			<td><c:out value="${Article.CodeArticle}" /></td>
			<td><c:out value="${Article.Desination}" /></td>
			<td><c:out value="${Article.Catgeorie}" /></td>
			<td><img alt="img1" src="/webapp/photo/img"${i} ".jpg"></td>
			<td><c:out value="${Article.Prix}" /></td>
			
			<td><a href="">Ajouter au panier</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>

</body>
</html>