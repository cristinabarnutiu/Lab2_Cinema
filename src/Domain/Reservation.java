package Domain;
import java.util.Objects;

// CRUD rezervare: id, id_film, id_card_client (poate fi nul), data și ora.
// Clientul acumuleaza pe card 10% (parte intreaga) din prețul filmului
// Se tiparește nr total de puncte de pe card
// Rezervarea se poate face doar daca filmul este incă in program.

public class Reservation {
    private int id, idMovie, idCard;
    private String date, time; //idCard can be null
    private double moviePrice;
    private int moviePoints;


    public Reservation(int id, int idMovie, int idCard, double moviePrice, int moviePoints, String date, String time) {
        this.id = id;
        this.idMovie = idMovie;
        this.idCard = idCard;
        this.moviePrice = moviePrice;
        this.moviePoints = ((int) moviePrice*10)/100;
        this.date = date;
        this.time = time;

    }

    /**
     * 10% Discount calculation
     */

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idMovie='" + idMovie + '\'' +
                ", idCard='" + idCard + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", moviePrice=" + moviePrice +
                ", moviePoints=" + moviePoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIdMovie() { return idMovie; }

    public void setIdMovie(int idMovie) { this.idMovie = idMovie; }

    public int getIdCard() { return idCard; }

    public void setIdCard(int idCard) { this.idCard = idCard; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public double getMoviePrice() { return moviePrice; }

    public void setMoviePrice(double moviePrice) { this.moviePrice = moviePrice; }

    public void setMoviePoints(double moviePrice) { this.moviePoints = (int) ((moviePrice*10)/100); }

    public int getMoviePoints() { return (int)(this.moviePrice*10)/100;}


}
