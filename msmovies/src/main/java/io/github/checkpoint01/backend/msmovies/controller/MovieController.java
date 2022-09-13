package io.github.checkpoint01.backend.msmovies.controller;

import io.github.checkpoint01.backend.msmovies.domain.dto.CreateMovieDTO;
import io.github.checkpoint01.backend.msmovies.domain.dto.MovieDTO;
import io.github.checkpoint01.backend.msmovies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.github.checkpoint01.backend.msmovies.util.ResponseEntityUtils.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String status() {
        LOGGER.info("Obtendo o status do microservice de Movies");
        return "ok";
    }

    @GetMapping(value = "/{genre}")
    public ResponseEntity<List<MovieDTO>> findAllByGenreContainsIgnoreCase(@PathVariable("genre") String genre) {
        var movieDTOList = movieService.findAllByGenreContainsIgnoreCase(genre);
        return movieDTOList.isEmpty() ? notFound() : ok(movieDTOList);
    }

    @PostMapping
    public ResponseEntity createMovie(@RequestBody CreateMovieDTO createMovieDTO) {
        return created(movieService.createMovie(createMovieDTO));
    }
}
