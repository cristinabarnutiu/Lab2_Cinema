package Domain;

public class MovieValidator {

    public void validate (Movie movie) {

            if (movie.getPrice() < 0 || Integer.parseInt(movie.getYear()) < 0 ) {
                throw new RuntimeException("Price and year must be > 0.");
            }

    }
}
