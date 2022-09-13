package io.github.checkpoint01.backend.mscatalog.controller;

import io.github.checkpoint01.backend.mscatalog.domain.dto.MovieDTO;
import io.github.checkpoint01.backend.mscatalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.github.checkpoint01.backend.mscatalog.util.ResponseEntityUtils.notFound;
import static io.github.checkpoint01.backend.mscatalog.util.ResponseEntityUtils.ok;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "/{genre}")
    public ResponseEntity<List<MovieDTO>> findAllByGenreContainsIgnoreCase(@PathVariable("genre") String genre) {
        var movieDTOList = catalogService.findAllByGenreContainsIgnoreCase(genre);
        return movieDTOList.isEmpty() ? notFound() :  ok(movieDTOList);
    }
}
