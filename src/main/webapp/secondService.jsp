<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chercher une ville</title>
</head>
<body>
    <h1>Chercher une ville</h1>
    <form method="get" action="http://localhost:8080/API/films/filmservice/second">
        <label for="ville">Ville:</label>
        <input type="text" name="ville" required><br><br>
        
        <input type="submit" value="Chercher">
    </form>
</body>
</html>
