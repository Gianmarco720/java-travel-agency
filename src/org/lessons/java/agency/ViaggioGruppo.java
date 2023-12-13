package org.lessons.java.agency;

import java.time.LocalDate;

public class ViaggioGruppo extends Vacanza{

    private int numberOfPartecipants;
    private int ageRange;

    public ViaggioGruppo(String destination, LocalDate startDate, LocalDate endDate, int numberOfPartecipants, int ageRange) throws IllegalArgumentException {
        super(destination, startDate, endDate);
        this.numberOfPartecipants = numberOfPartecipants;
        this.ageRange = ageRange;
    }

    public int getNumberOfPartecipants() {
        return numberOfPartecipants;
    }

    public void setNumberOfPartecipants(int numberOfPartecipants) {
        this.numberOfPartecipants = numberOfPartecipants;
    }

    public int getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(int ageRange) {
        this.ageRange = ageRange;
    }


    @Override
    public String toString() {
        return super.toString() + " numero di partecipanti: " + numberOfPartecipants + " range d'età" + ageRange;
    }
}
