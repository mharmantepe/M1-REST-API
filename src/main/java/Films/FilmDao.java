package Films;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilmDao {
	public String getFilms() {
	    List<Film> filmList = null;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "12301230");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM film");
	        filmList = new ArrayList<>();
	        while (rs.next()) {
	            int duree = rs.getInt(1);
	            int age = rs.getInt(2);
	            String titre = rs.getString(3);
	            String langue = rs.getString(4);
	            String realisateur = rs.getString(5);
	            String acteurs = rs.getString(6);
	            String ville = rs.getString(7);
	            String jours = rs.getString(8);
	            java.sql.Date date_d = rs.getDate(9);
	            java.sql.Date date_f = rs.getDate(10);
	            
	            LocalDate localDate_d = date_d.toLocalDate();
	            LocalDate localDate_f = date_f.toLocalDate();

	            filmList.add(new Film(duree, age, titre, langue, realisateur, acteurs, ville, jours, localDate_d, localDate_f));
	        }
	        con.close();
	        stmt.close();
	        rs.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    String json = "";
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        json = objectMapper.writeValueAsString(filmList);
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return json;
	}


    public String addFilm(int duree, int age, String titre, String langue, String realisateur, String acteurs, String ville, String jours, LocalDate date_d, LocalDate date_f) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "12301230");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO film (duree, age, titre, langue, realisateur, acteurs, ville, jours, date_d, date_f) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, duree);
            stmt.setInt(2, age);
            stmt.setString(3, titre);
            stmt.setString(4, langue);
            stmt.setString(5, realisateur);
            stmt.setString(6, acteurs);
            stmt.setString(7, ville);
            stmt.setString(8, jours);
            stmt.setDate(9, Date.valueOf(date_d));
            stmt.setDate(10, Date.valueOf(date_f));

            int res = stmt.executeUpdate();
            if (res == 1) {
                return "ajouté";
            }

            con.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "failed";
    }

    public List<String> secondService(String ville){
        List<String> filmList = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "12301230");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select titre from film where ville = '"+ville+"'");
            filmList = new ArrayList<>();
            while (rs.next()) {
                String value = rs.getString(1);

                filmList.add(value);
            }
            con.close();
            stmt.close();
            rs.close();
            return filmList;
        } catch (Exception e) {
            System.out.println(e);
        }

        return filmList;
    }

    public List<String> thirdService(String titre){
        List<String> filmList = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "12301230");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from film where titre = '"+titre+"'");
            filmList = new ArrayList<>();
            while (rs.next()) {
                String ville = rs.getString(7);

                filmList.add(ville);
            }
            con.close();
            stmt.close();
            rs.close();
            return filmList;
        } catch (Exception e) {
            System.out.println(e);
        }

        return filmList;
    }

    public List<FilmTuple> thirdServiceBis(String titre){
        List<FilmTuple> filmList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "12301230");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from film where titre = '"+titre+"'");

            if (rs.next()) {
                int duree = rs.getInt("duree");
                int age = rs.getInt("age");
                String langue = rs.getString("langue");
                String realisateur = rs.getString("realisateur");
                String acteurs = rs.getString("acteurs");

                FilmTuple filmTuple = new FilmTuple(duree, age, langue, realisateur, acteurs);

                filmList.add(filmTuple);
            }
            con.close();
            stmt.close();
            rs.close();
            return filmList;
        } catch (Exception e) {
            System.out.println(e);
        }

        return filmList;
    }
}
