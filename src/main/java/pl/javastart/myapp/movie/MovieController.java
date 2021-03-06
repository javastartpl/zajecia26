package pl.javastart.myapp.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String allMovies(Model model, MovieFilters movieFilters) {

        if(movieFilters == null) {
            movieFilters = new MovieFilters();
        }

        List<Movie> movies = movieRepository.findUsingFilters(movieFilters.getTitle(), movieFilters.getTargetAudience());

        model.addAttribute("movies", movies);
        model.addAttribute("filters", movieFilters);

        return "movies"; // ->> resources/templates/movies.html
    }

    @GetMapping("/film/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            Movie movie = optional.get();
            model.addAttribute("movie", movie);
            return "movie"; // ->> resources/templates/movie.html
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/addmovie")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("mode", "add");
        return "addMovieForm";
    }

    @PostMapping("/addmovie")
    public String addMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/film/" + movie.getId();
    }

    @GetMapping("/usun/{id}")
    public String delete(@PathVariable Long id) {

        movieRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/film/edytuj/{id}")
    public String edytujForm(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);

        if (optional.isPresent()) {
            Movie movie = optional.get();
            model.addAttribute("movie", movie);
            model.addAttribute("mode", "edit");
            return "addMovieForm";

        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/editmovie")
    public String editMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/film/" + movie.getId();
    }

}
