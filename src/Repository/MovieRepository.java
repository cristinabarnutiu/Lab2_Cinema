package Repository;
import Domain.Movie;
import Domain.MovieValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private Map<Integer, Movie> storage = new HashMap<>();
    private MovieValidator validator;

    public MovieRepository(MovieValidator validator) { this.validator = validator; }

    public Movie findById(int id) { return storage.get(id); }

    /**
     * Adds or updates a movie if it already exists.
     * @param movie the movie to add or update.
     */
    public void upsert(Movie movie) {
        validator.validate(movie);
        storage.put(movie.getId(), movie);
    }

    /**
     * Removes a movie with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no movie with the given id.
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no movie with the given id to remove.");
        }
        storage.remove(id);
    }

    public List<Movie> getAll() {
        return new ArrayList<>(storage.values());
    }
}
