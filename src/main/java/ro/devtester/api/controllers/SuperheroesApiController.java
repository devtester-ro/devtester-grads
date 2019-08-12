package ro.devtester.api.controllers;

import ro.devtester.api.SuperheroesApi;
import ro.devtester.api.exceptions.ApiException;
import ro.devtester.api.services.ISuperheroesApiService;
import ro.devtester.model.NewSuperhero;
import ro.devtester.model.Superhero;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SuperheroesApiController implements SuperheroesApi {

    private static final Logger logger = LoggerFactory.getLogger(SuperheroesApiController.class);

    private final ISuperheroesApiService superheroesApiService;

    public SuperheroesApiController(ISuperheroesApiService superheroesApiService) {
        this.superheroesApiService = superheroesApiService;
    }

    @Override
    @PostMapping("/superheroes")
    public ResponseEntity<Superhero> addSuperhero(@ApiParam(value = "Superhero to add", required = true) @Valid @RequestBody NewSuperhero superhero) {
        Superhero newSuperhero = superheroesApiService.addSuperhero(superhero);

        return new ResponseEntity<>(newSuperhero, HttpStatus.OK);
    }

    @Override
    @GetMapping("/superheroes/{id}")
    public ResponseEntity<Superhero> findSuperheroById(@ApiParam(value = "ID of superhero to fetch", required = true) @PathVariable("id") Long id) {
        Superhero superhero = null;

        try {
            superhero = superheroesApiService.findSuperheroById(id);
        } catch (ApiException e) {
            logger.error(e.getMessage());
        }

        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

}
