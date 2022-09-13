package io.github.checkpoint01.backend.msmovies.service;

import io.github.checkpoint01.backend.msmovies.domain.dto.CreateMovieDTO;
import io.github.checkpoint01.backend.msmovies.domain.dto.MovieDTO;
import io.github.checkpoint01.backend.msmovies.domain.repository.MovieRepository;
import io.github.checkpoint01.backend.msmovies.mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> findAllByGenreContainsIgnoreCase(String genre) {
        return movieRepository.findAllByGenreContainsIgnoreCase(genre)
            .stream()
            .map(movieMapper::fromEntityToDTO)
            .collect(Collectors.toList());
    }

    @Transactional
    public MovieDTO createMovie(CreateMovieDTO createMovieDTO) {
        var movie = movieMapper.fromCreateMovieDTOToEntity(createMovieDTO);
        return movieMapper.fromEntityToDTO(movieRepository.save(movie));
    }
}
