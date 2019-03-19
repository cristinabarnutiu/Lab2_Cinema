package Domain;

import java.util.Objects;

//CRUD card client: id, nume, prenume, CNP, data nasterii (dd.mm.yyyy), data inreg (dd.mm.yyyy), puncte acumulate.
//CNP-ul trebuie să fie unic - TO DO

import java.util.Objects;

public class Card {
    private int id;
    private String lastName;
    private String firstName;
    private String CNP;
    private String dateOfBirth, dateOfRegistration;
    private int totalPoints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }

    public Card(int id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration, int totalPoints) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.totalPoints = totalPoints;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getCNP() { return CNP; }
    public void setCNP(String CNP) { this.CNP = CNP; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getDateOfRegistration() { return dateOfRegistration; }
    public void setDateOfRegistration(String dateOfRegistration) { this.dateOfRegistration = dateOfRegistration; }
    public int getTotalPoints() { return totalPoints; }
    public void setTotalPoints(int totalPoints) { this.totalPoints = totalPoints; }
}
