package io.github.checkpoint01.backend.msmovies.domain.repository;

import io.github.checkpoint01.backend.msmovies.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByGenreContainsIgnoreCase(@Param("genre") String genre);
}
