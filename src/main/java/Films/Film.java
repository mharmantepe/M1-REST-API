package Films;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")
public class Film implements Serializable {
    private int duree, age;
    private String titre, langue, realisateur, acteurs, ville, jours;
    private Date date_d, date_f;

    public Film(int duree, int age, String titre, String langue, String realisateur, String acteurs, String ville, String jours, LocalDate date_d, LocalDate date_f) {
        this.duree = duree;
        this.age = age;
        this.titre = titre;
        this.langue = langue;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.ville = ville;
        this.jours = jours;

        this.date_d = java.sql.Date.valueOf(date_d);
        this.date_f = java.sql.Date.valueOf(date_f);
    }

    @XmlElement
    public int getDuree() {
        return duree;
    }

    @XmlElement
    public void setDuree(int duree) {
        this.duree = duree;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getTitre() {
        return titre;
    }

    @XmlElement
    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlElement
    public String getLangue() {
        return langue;
    }

    @XmlElement
    public void setLangue(String langue) {
        this.langue = langue;
    }

    @XmlElement
    public String getRealisateur() {
        return realisateur;
    }

    @XmlElement
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    @XmlElement
    public String getActeurs() {
        return acteurs;
    }

    @XmlElement
    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    @XmlElement
    public String getVille() {
        return ville;
    }

    @XmlElement
    public void setVille(String ville) {
        this.ville = ville;
    }

    @XmlElement
    public Date getDate_d() {
        return date_d;
    }

    @XmlElement
    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }

    @XmlElement
    public Date getDate_f() {
        return date_f;
    }

    @XmlElement
    public void setDate_f(Date date_f) {
        this.date_f = date_f;
    }

    @XmlElement
    public String getJours() {
        return jours;
    }

    @XmlElement
    public void setJours(String jours) {
        this.jours = jours;
    }

    @XmlElement
    public String getFormattedDate_d() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date_d);
    }

    @XmlElement
    public String getFormattedDate_f() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date_f);
    }
}
