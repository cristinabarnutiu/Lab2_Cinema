package UI;
import Domain.Movie;
import Domain.Card;
import Domain.Reservation;
import Service.MovieService;
import Service.CardService;
import Service.ReservationService;
import java.util.Scanner;
//
public class ConsoleCLN {
    private MovieService movieService;
    private CardService cardService;
    private ReservationService reservationService;

    private Scanner scanner;

    public ConsoleCLN(MovieService movieService, CardService cardService, ReservationService reservationService) {
        this.movieService = movieService;
        this.cardService = cardService;
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    //Main Menu options
    private void showMenu() {
        System.out.println("1. Movie CRUD");
        System.out.println("2. Card CRUD");
        System.out.println("3. Reservation CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runCardCrud();
                    break;
                case "3":
                    runReservationCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    //CRUD Reservation
    private void runReservationCrud() {
        while (true) {
            System.out.println("1. Add or update a reservation");
            System.out.println("2. Remove a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateReservation();
                    break;
                case "2":
                    handleRemoveReservation();
                    break;
                case "3":
                    handleViewReservations();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewReservations() {
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
    }

    private void handleRemoveReservation() {
        try {
            System.out.print("Enter the id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            reservationService.remove(id);
            System.out.println("Reservation removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateReservation() {
        try {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter movie id (empty to not change for update): ");
            int idMovie = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter card id (empty to not change for update): ");
            int idCard = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Reservation reservation = reservationService.addOrUpdate(id, idMovie, idCard, date, time);
            System.out.println(String.format("Added transaction id=%s, movie price=%f", reservation.getId(), reservation.getMoviePrice()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    //CRUD Card
    private void runCardCrud() {
        while (true) {
            System.out.println("1. Add or update a card");
            System.out.println("2. Remove a card");
            System.out.println("3. View all cards");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateCard();
                    break;
                case "2":
                    handleRemoveCard();
                    break;
                case "3":
                    handleViewCards();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewCards() {
        for (Card card : cardService.getAll()) {
            System.out.println(card);
        }
    }

    private void handleRemoveCard() {
        try {
            System.out.print("Enter the card id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            cardService.remove(id);
            System.out.println("Card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateCard() {
        try {
            System.out.print("Enter card id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();
            System.out.print("Enter total points: ");
            int totalPoints = Integer.parseInt(scanner.nextLine());

            cardService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration, totalPoints);

            System.out.println("Card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    //CRUD Movie

    /**
     * Movie CRUD menu created
     * The app stores,deletes,displays data or return to the previous menu based on the given command
     */
    private void runMovieCrud() {
        while (true) {
            try {
                System.out.print("Type one of the commands below:\n" +
                        "AddMovie,[id],[title],[year],[price],[inProgram]\n" +
                        "RemoveMovie,[id]\n" +
                        "ViewMovies\n" +
                        "Exit\n");

                String line = scanner.nextLine();           // line is the input which has comma separated words
                String[] input = line.split(",");
                String args[] = new String[10];             // instantiates an array of 10

                for (int i = 0; i < input.length; i++) {
                    args[i] = input[i];
                    //System.out.print(args[i]+"\n");
                }
                if (args[0].equals("Exit")) break;

                if (args[0].equals("AddMovie")) {
                    int id = Integer.parseInt(args[1]);
                    String title = args[2];
                    String year = args[3];
                    Double price = Double.parseDouble(args[4]);
                    Boolean inProgram = Boolean.parseBoolean(args[5]);
                    movieService.addOrUpdate(id, title, year, price, inProgram);

                    System.out.println("Movie added!");
                }

                if (args[0].equals("RemoveMovie")) {
                    int id = Integer.parseInt(args[1]);
                    movieService.remove(id);
                    System.out.println("Movie removed");
                }

                if (args[0].equals("ViewMovies")) {
                    for (Movie movie : movieService.getAll()) {
                        System.out.println(movie);
                    }
                }

            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }
    }


    }

