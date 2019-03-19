package Domain;

import java.util.Objects;

//CRUD film: id, titlu, an aparitie, pret bilet, in program.
//Pret > 0

public class Movie {

    private int id;
    private String title;
    private String year;
    private double price;
    private int moviePoints;
    private boolean inProgram;

    public Movie(int id, String title, String year, double price, boolean inProgram) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
        this.inProgram = inProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", moviePoints=" + moviePoints +
                ", inProgram=" + inProgram +
                '}';
    }

    public int getId() { return id;    }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isInProgram() { return inProgram; }
    public void setInProgram(boolean inProgram) { this.inProgram = inProgram; }
    public int getMoviePoints() { return moviePoints; }
    public void setMoviePoints() { this.moviePoints = (int)((this.price*10)/100); }
}
