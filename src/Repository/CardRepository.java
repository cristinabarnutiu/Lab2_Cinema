package Repository;

import Domain.Movie;
import Domain.MovieValidator;
import Domain.Card;
import Domain.CardValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//
public class CardRepository {
    private Map<Integer, Card> storage = new HashMap();
    private CardValidator validator;

    public CardRepository(CardValidator validator) { this.validator = validator; }
    public Card findById(int id) { return storage.get(id); }
    public Card findByCNP(String CNP) { return storage.get(CNP); }
    /**
     * Adds or updates a card if it already exists.
     * @param card the card to add or update.
     * @throws RuntimeException if the CNP is not unique
     */
    public void upsert(Card card) {
        validator.validate(card);
        storage.put(card.getId(), card);
    }

    /**
     * Removes a card with a given id
     * @param id the id.
     * @throws RuntimeException if there is no card with the given id.
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no card with the given id to remove.");
        }
        storage.remove(id);
    }

    public List<Card> getAll() {
        return new ArrayList<>(storage.values());
    }

}
