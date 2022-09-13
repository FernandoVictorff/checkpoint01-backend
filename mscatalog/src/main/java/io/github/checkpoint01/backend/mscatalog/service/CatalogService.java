package io.github.checkpoint01.backend.mscatalog.service;

import io.github.checkpoint01.backend.mscatalog.domain.dto.MovieDTO;
import io.github.checkpoint01.backend.mscatalog.infra.clients.MovieControllerClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final MovieControllerClient movieControllerClient;

    public CatalogService(MovieControllerClient movieControllerClient) {
        this.movieControllerClient = movieControllerClient;
    }

    public List<MovieDTO> findAllByGenreContainsIgnoreCase(String genre) {
        return movieControllerClient.findAllByGenreContainsIgnoreCase(genre).getBody();
    }
}
