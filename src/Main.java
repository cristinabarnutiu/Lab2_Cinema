import Domain.MovieValidator;
import Domain.CardValidator;
import Domain.ReservationValidator;
import Repository.MovieRepository;
import Repository.CardRepository;
import Repository.ReservationRepository;
import Service.MovieService;
import Service.CardService;
import Service.ReservationService;
import UI.Console;
import UI.ConsoleCLN;
public class Main {

    public static void main(String[] args) {

        MovieValidator movieValidator = new MovieValidator();
        CardValidator cardValidator = new CardValidator();
        ReservationValidator reservationValidator = new ReservationValidator();

        MovieRepository movieRepository = new MovieRepository(movieValidator);
        CardRepository cardRepository = new CardRepository(cardValidator);
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        CardService cardService = new CardService(cardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, movieRepository);

        ConsoleCLN console = new ConsoleCLN(movieService, cardService, reservationService);
        console.run();
    }
}