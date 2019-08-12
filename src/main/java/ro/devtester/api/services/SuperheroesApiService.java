package ro.devtester.api.services;

import ro.devtester.api.exceptions.ApiException;
import ro.devtester.model.NewSuperhero;
import ro.devtester.model.Superhero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class SuperheroesApiService implements ISuperheroesApiService {

    private final ArrayList<Superhero> listSuperheroes = new ArrayList<>();

    public Superhero addSuperhero(NewSuperhero superhero) {

        Superhero addSuperhero = new Superhero();
        addSuperhero.setId(superhero.getId());
        addSuperhero.setName(superhero.getName());
        addSuperhero.setTag(superhero.getTag());

        listSuperheroes.add(addSuperhero);

        return addSuperhero;
    }

    public Superhero findSuperheroById(Long id) throws ApiException {

        return listSuperheroes.stream().filter(superhero -> Objects.equals(superhero.getId(), id))
                .findFirst().orElseThrow(() -> new ApiException(404, "No superhero found with expected id: " + id));
    }
}
