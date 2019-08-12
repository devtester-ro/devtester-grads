package ro.devtester.api.services;

import ro.devtester.api.exceptions.ApiException;
import ro.devtester.model.NewSuperhero;
import ro.devtester.model.Superhero;

public interface ISuperheroesApiService {

    Superhero addSuperhero(NewSuperhero pet);

    Superhero findSuperheroById(Long id) throws ApiException;

}
