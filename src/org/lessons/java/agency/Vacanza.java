package org.lessons.java.agency;


import static java.time.temporal.ChronoUnit.DAYS;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

public class Vacanza {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Escursione> listEscursioni = new ArrayList<>();

    public ArrayList<Escursione> getListEscursioni() {
        return listEscursioni;
    }

    public Vacanza(String destination, LocalDate startDate, LocalDate endDate)throws IllegalArgumentException {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        validateDestination(destination);
        validateStartDate(startDate);
        validateEndDate(endDate);
    }

    public void addEscursioni(Escursione escursione) {
        listEscursioni.add(escursione);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        validateDestination(destination);
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        validateStartDate(startDate);
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        validateEndDate(endDate);
        this.endDate = endDate;
    }






    private void validateDestination(String destination){
        if (destination == null || destination.isEmpty()){
            throw new IllegalArgumentException("destinazione non valida");
        }
    }

    private void validateStartDate(LocalDate startDate){
        if (startDate == null || startDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("data di partenza non valida!");
        }
    }


    private void validateEndDate(LocalDate endDate) {
        if (endDate == null || (this.startDate != null && endDate.isBefore(this.startDate))){
            throw new IllegalArgumentException("data di arrivo non valida!");
        }
    }

    public long totalDays(){
        return DAYS.between(startDate, endDate);
    }

    @Override
    public String toString() {
        return "Hai prenotato una vacanza di " + totalDays()+ " giorni a " + destination +  " dal " + startDate + " al " + endDate;
    }

    public BigDecimal totalEscursionPrice(){
        BigDecimal initialPrice = BigDecimal.ZERO;
        for (Escursione element:listEscursioni){
            initialPrice = initialPrice.add(element.getPrice()).setScale(2, RoundingMode.HALF_DOWN);
        }
        return initialPrice;
    }

}