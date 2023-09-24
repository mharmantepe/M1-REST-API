package Films;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "filmTuple")
public class FilmTuple {
    private int duree;
    private int age;
    private String langue;
    private String realisateur;
    private String acteurs;
    
    public FilmTuple(int duree, int age, String langue, String realisateur, String acteurs) {
		this.duree = duree;
		this.age = age;
		this.langue = langue;
		this.realisateur = realisateur;
		this.acteurs = acteurs;
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
}

