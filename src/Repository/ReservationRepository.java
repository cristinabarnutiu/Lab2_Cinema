package Repository;
import Domain.Card;
import Domain.CardValidator;
import Domain.Reservation;
import Domain.ReservationValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;

public class ReservationRepository {
    private Map<Integer, Reservation> storage = new HashMap<>();
    private ReservationValidator validator;

    public ReservationRepository(ReservationValidator validator) { this.validator = validator; }
    public Reservation findById(int id) {return storage.get(id);}

    /**
     * Adds or updates a reservation if it already exists.
     * @param reservation the transaction to add or update.
     */
    public void upsert(Reservation reservation) {
        validator.validate(reservation);
        storage.put(reservation.getId(), reservation);
    }

    /**
     * Removes a reservation with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no reservation with the given id.
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no reservation with the given id to remove.");
        }
        storage.remove(id);
    }

    public List<Reservation> getAll() {
        return new ArrayList<>(storage.values());
    }
}
