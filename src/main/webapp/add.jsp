<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un film</title>
    <script>
        function submitForm() {
            var select = document.getElementById("jours");
            var selectedOptions = Array.from(select.selectedOptions).map(option => option.value);
            document.getElementById("joursHidden").value = selectedOptions.join(",");
            return true;
        }
    </script>
</head>
<body>
    <h1>Ajouter un film</h1>
    <form method="post" action="http://localhost:8080/API/films/filmservice/filmAdd" onsubmit="return submitForm()">
        <label for="duree">Durée:</label>
        <input type="number" name="duree" required><br><br>
        
        <label for="age">Âge:</label>
        <input type="number" name="age" required><br><br>
        
        <label for="titre">Titre:</label>
        <input type="text" name="titre" required><br><br>
        
        <label for="langue">Langue:</label>
        <input type="text" name="langue" required><br><br>
        
        <label for="realisateur">Réalisateur:</label>
        <input type="text" name="realisateur" required><br><br>
        
        <label for="acteurs">Acteurs:</label>
        <input type="text" name="acteurs" required><br><br>
        
        <label for="ville">Ville:</label>
        <input type="text" name="ville" required><br><br>
        
        <label for="date_d">Date début:</label>
        <input type="date" name="date_d" required><br><br>
        
        <label for="date_f">Date fin:</label>
        <input type="date" name="date_f" required><br><br>
        
        <label for="jours">Jours:</label>
        <select id="jours" multiple required>
            <option value="lundi">Lundi</option>
            <option value="mardi">Mardi</option>
            <option value="mercredi">Mercredi</option>
            <option value="jeudi">Jeudi</option>
            <option value="vendredi">Vendredi</option>
            <option value="samedi">Samedi</option>
            <option value="dimanche">Dimanche</option>
        </select><br><br>
        
        <input type="hidden" id="joursHidden" name="jours" value="">
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
