package de.neemann.digital.builder.Gal22v10;

import de.neemann.digital.builder.Gal16v8.Gal16v8CuplExporter;
import de.neemann.digital.builder.PinMap;

import java.util.Date;

/**
 * Creates a CUPL file
 *
 * @author hneemann
 */
public class Gal22v10CuplExporter extends Gal16v8CuplExporter {

    /**
     * Creates a new project name
     */
    public Gal22v10CuplExporter() {
        this(System.getProperty("user.name"), new Date());
    }

    /**
     * Creates a new project name
     *
     * @param username user name
     * @param date     date
     */
    public Gal22v10CuplExporter(String username, Date date) {
        super(username, date, "g22v10", new PinMap()
                .setAvailInputs(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
                .setAvailOutputs(14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
    }

}