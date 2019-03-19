package Service;

import Domain.Movie;
import Domain.Card;
import Repository.MovieRepository;
import Repository.CardRepository;

import java.util.List;

public class CardService {
    private CardRepository repository;
    public CardService(CardRepository repository){ this.repository = repository;};

    public void addOrUpdate(int id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration, int totalPoints) {
        Card existing = repository.findById(id);
       if (existing != null) {
            // keep unchanged fields as they were
            if (lastName.isEmpty()) { lastName = existing.getLastName(); }
            if (firstName.isEmpty()) { firstName = existing.getFirstName(); }
            if (CNP.isEmpty()) { CNP = existing.getCNP(); }
            if (dateOfBirth.isEmpty()) { dateOfBirth = existing.getDateOfBirth(); }
            if (dateOfRegistration.isEmpty()) { dateOfRegistration = existing.getDateOfRegistration(); }
            if (totalPoints == 0) { totalPoints = existing.getTotalPoints(); }
        }
            Card card = new Card(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration, totalPoints);
            repository.upsert(card);
        }

    public void remove(int id) {
        repository.remove(id);
    }
    public List<Card> getAll() {
        return repository.getAll();
    }

}
