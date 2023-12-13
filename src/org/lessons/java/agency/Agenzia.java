package org.lessons.java.agency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Creo una serie di escursioni
        Escursione escursione1 = new Escursione("Stadio", 3, new BigDecimal(68.99));
        Escursione escursione2 = new Escursione("Cimitero", 10, new BigDecimal(0.99));
        Escursione escursione3 = new Escursione("Centro storico" , 10, new BigDecimal(6.99));

        // Chiedo all'utente se vuole andare in vacanza
        System.out.println("Vuoi andare in vacanza? (y/n)");
        String travelOrNot = scan.nextLine();

        // Uso uno switch per gestire i tre casi
        switch (travelOrNot){
            case "y":
                System.out.println("Che tipo di vacanza vuoi fare: 1.Generica 2.Nozze 3.Gruppo");
                String travelChoice = scan.nextLine();

                System.out.println("Dove vuoi andare?");
                String destination = scan.nextLine();

                System.out.println("Quando vuoi partire? (yyyy-mm-dd)");
                String firstDate = scan.nextLine();

                LocalDate startDate = LocalDate.parse(firstDate);
                System.out.println("Quando vuoi tornare? (yyyy-mm-dd)");
                String secondDate = scan.nextLine();

                LocalDate endDate = LocalDate.parse(secondDate);

                if (travelChoice.equals("1") || travelChoice.equalsIgnoreCase("generica")){
                    try{
                        Vacanza vacanza = new Vacanza(destination,startDate,endDate);

                        vacanza.addEscursioni(escursione1);
                        vacanza.addEscursioni(escursione2);
                        vacanza.addEscursioni(escursione3);

                        System.out.println("Il prezzo delle escursioni è: " + vacanza.totalEscursionPrice());
                        System.out.println(vacanza);

                    }catch (IllegalArgumentException e){
                        System.out.println("destinazione o date non corrette");
                    }
                } else if (travelChoice.equals("2") || travelChoice.equalsIgnoreCase("nozze") ) {
                    try{
                        System.out.println("Indica il trattamento che desideri ricervere durante il viaggio: ");
                        String treatment = scan.nextLine();

                        ViaggioNozze viaggioNozze = new ViaggioNozze(destination,startDate,endDate,treatment);

                        viaggioNozze.addEscursioni(escursione1);
                        viaggioNozze.addEscursioni(escursione2);
                        viaggioNozze.addEscursioni(escursione3);

                        System.out.println("Il prezzo delle escursioni è: " + viaggioNozze.totalEscursionPrice());
                        System.out.println(viaggioNozze);

                    }catch (IllegalArgumentException e){
                        System.out.println("destinazione, date o trattemento non corretti");
                    }
                } else if (travelChoice.equals("3") || travelChoice.equalsIgnoreCase("gruppo")) {
                    try{
                        System.out.println("Indica il numero di persone: ");
                        int numberOfPartecipants = Integer.parseInt(scan.nextLine());

                        System.out.println("Indica il range d'eta");
                        int rangeAge = Integer.parseInt(scan.nextLine());

                        ViaggioGruppo viaggioGruppo = new ViaggioGruppo(destination,startDate,endDate,numberOfPartecipants,rangeAge);

                        viaggioGruppo.addEscursioni(escursione1);
                        viaggioGruppo.addEscursioni(escursione2);
                        viaggioGruppo.addEscursioni(escursione3);

                        System.out.println("Il prezzo delle escursioni è: " + viaggioGruppo.totalEscursionPrice());
                        System.out.println(viaggioGruppo);

                    }catch (IllegalArgumentException e){
                        System.out.println("destinazione,date, numero di partecipanti o range d'età non corretti");
                    }
                }

                break;
            case "n":
                System.out.println("Va bene, alla prossima!");

                break;

            default:
                System.out.println("Risposta non valida, riprova inserendo y/n");

                break;
        }
        scan.close();
    }
}