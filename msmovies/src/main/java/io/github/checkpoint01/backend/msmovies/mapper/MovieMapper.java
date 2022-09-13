package io.github.checkpoint01.backend.msmovies.mapper;

import io.github.checkpoint01.backend.msmovies.domain.dto.CreateMovieDTO;
import io.github.checkpoint01.backend.msmovies.domain.dto.MovieDTO;
import io.github.checkpoint01.backend.msmovies.domain.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    public abstract MovieDTO fromEntityToDTO(Movie movie);
    public abstract Movie fromCreateMovieDTOToEntity(CreateMovieDTO createMovieDTO);
}
