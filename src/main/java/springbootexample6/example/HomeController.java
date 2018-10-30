package springbootexample6.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")

    public String index(Model model){
        Director director = new Director();

        director.setName("Stephan Bullock");
        director.setGenre("Sci Fi");


        Movie movie = new Movie();
        movie.setTitle("Start Movies");
        movie.setYear(2017);
        movie.setDescription("About  the movie start");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie  = new Movie();
        movie.setTitle("DeathStar Ewoks");
        movie.setYear(2011);
        movie.setDescription("This is about the movie DeathStar Ewoks");
        movies.add(movie);

        director.setMovies(movies);
        directorRepository.save(director);
        model.addAttribute("directors", directorRepository.findAll());

        return "index";
    }

}
