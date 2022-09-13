package io.github.checkpoint01.backend.mscatalog.infra.clients;

import io.github.checkpoint01.backend.mscatalog.domain.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "msmovies", path = "/movies")
public interface MovieControllerClient {

    @GetMapping(value = "/{genre}")
    ResponseEntity<List<MovieDTO>> findAllByGenreContainsIgnoreCase(@PathVariable("genre") String genre);
}
