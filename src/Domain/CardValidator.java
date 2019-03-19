package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;

/**
 * Validates the dateOfBirth and dateOfRegistration ("dd.MM.yyyy" format)
 * Validates CNP length (13 digits)
 */
public class CardValidator {
    public void validate(Card card) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            format.parse(card.getDateOfBirth());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }
        try {
            format.parse(card.getDateOfRegistration());
        } catch (ParseException pe) {
            throw new RuntimeException ("The date of registration is not in a correct format!");
        }

        //not sure if working?
        if (card.getCNP().length() != 13 ) {
            throw new RuntimeException("CNP length must be 13");
        }

}
}

