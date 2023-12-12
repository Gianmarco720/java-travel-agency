package org.lessons.java.agency;

import java.time.LocalDate;

public class ViaggioGruppo extends Vacanza{

    // ATTRIBUTI
    private int numberOfPartecipants;

    private int ageRange;

    // COSTRUTTORI


    public ViaggioGruppo(String destination, LocalDate startDate, LocalDate endDate, int numberOfPartecipants, int ageRange) throws IllegalArgumentException {
        super(destination, startDate, endDate);
        this.numberOfPartecipants = numberOfPartecipants;
        this.ageRange = ageRange;
    }

    // GETTER E SETTER

    // METODI
}
