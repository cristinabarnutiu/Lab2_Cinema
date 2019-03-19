package Service;

import Repository.MovieRepository;
import Domain.Movie;

import java.util.List;

public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(int id, String title, String year, double price, boolean inProgram) {
        Movie existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (title.isEmpty()) { title = existing.getTitle(); }
            if (year.isEmpty()) { year = existing.getYear(); }
            if (price == 0) { price = existing.getPrice();}
        }
        Movie movie = new Movie(id, title, year, price, inProgram);
        repository.upsert(movie);
    }
        public void remove(int id){ repository.remove(id); }
        public List<Movie> getAll () { return repository.getAll(); }
    }

