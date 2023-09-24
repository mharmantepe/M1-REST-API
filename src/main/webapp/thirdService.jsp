<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chercher un film</title>
</head>
<body>
    <h1>Chercher un film</h1>
    <form method="get" action="http://localhost:8080/API/films/filmservice/third">
        <label for="titre">Titre:</label>
        <input type="text" name="titre" required><br><br>
        
        <input type="submit" value="Chercher">
    </form>
</body>
</html>
