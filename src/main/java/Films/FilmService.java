package Films;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Path("/filmservice")
public class FilmService {

    FilmDao filmDao = new FilmDao();

    @GET
    @Path("/filmList")
    @Produces(MediaType.APPLICATION_JSON)
    public String displayFilm() {
        return filmDao.getFilms();
    }

    @POST
    @Path("/filmAdd")
    @Produces(MediaType.APPLICATION_JSON)
    public String addFilm(
            @FormParam("duree") int duree,
            @FormParam("age") int age,
            @FormParam("titre") String titre,
            @FormParam("langue") String langue,
            @FormParam("realisateur") String realisateur,
            @FormParam("acteurs") String acteurs,
            @FormParam("ville") String ville,
            @FormParam("jours") String jours,
            @FormParam("date_d") String date_d,
            @FormParam("date_f") String date_f,
            @Context HttpServletResponse servletResponse) throws IOException {

        LocalDate localDate_d = LocalDate.parse(date_d);
        LocalDate localDate_f = LocalDate.parse(date_f);

        return filmDao.addFilm(duree, age, titre, langue, realisateur, acteurs, ville, jours, localDate_d, localDate_f);
    }

    @GET
    @Path("/second")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> displaySecond(@QueryParam("ville") String ville, @Context HttpServletResponse servletResponse) throws IOException {
        return filmDao.secondService(ville);
    }

    @GET
    @Path("/third")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> displayThird(@QueryParam("titre") String titre, @Context HttpServletResponse servletResponse) throws IOException {
        List<Object> combinedList = new ArrayList<>();

        List<FilmTuple> tupleList = filmDao.thirdServiceBis(titre);
        List<String> stringList = filmDao.thirdService(titre);

        combinedList.addAll(tupleList);
        combinedList.addAll(stringList);

        return combinedList;
    }

}
