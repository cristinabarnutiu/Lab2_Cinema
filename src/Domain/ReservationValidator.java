package Domain;
// CRUD rezervare: id, id_film, id_card_client (poate fi nul), data și ora.

public class ReservationValidator {
    public void validate (Reservation reservation){
            if (reservation.getIdMovie() < 0) {
                throw new RuntimeException("Movie id must be positive");
            }
        }

    }
