package Schule.LF05.Parkscheinautomat;

import java.util.Scanner;
public class Parkscheinautomat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double zoneA = 2.50;
        double zoneB = 3.70;
        double zoneC = 5.20;
        double zwischenbetrag = 0.0;
        while (true){
            System.out.println("Hier können Sie Fahrkarten kaufen!");
            System.out.println("Bitte wählen Sie Ihre Zone aus:");
            System.out.println("A - Zone A (" + zoneA +" Euro)");
            System.out.println("B - Zone B (" + zoneB +" Euro)");
            System.out.println("C - Zone C (" + zoneC +" Euro)");
            System.out.println("Ihre Auswahl (A, B oder C):");
            String zone = input.next();
            double preis = 0.0;
            if (zone.equalsIgnoreCase("A")){
                preis = zoneA;
            } else if (zone.equalsIgnoreCase("B")){
                preis = zoneB;
            } else if (zone.equalsIgnoreCase("C")){
                preis = zoneC;
            } else {
                System.out.println("Ungültiger Eintrag. Bitte erneut versuchen!");
                continue;
            }

            System.out.print("Wie viele Karten möchten Sie?:");
            int anzahl = input.nextInt();
            zwischenbetrag += (preis * anzahl);
            System.out.print("Möchten Sie weitere Karten kaufen? (ja/nein):");
            String weitereKarten = input.next();
            if (weitereKarten.equalsIgnoreCase("nein")) {
                System.out.println("Zu zahlender Betrag: " + zwischenbetrag + " Euro");
                System.out.println("Bitte geben Sie Ihr Geld ein:");
                double restbetrag = zwischenbetrag;
                while (restbetrag > 0) {
                    System.out.print("Geldmünzen eingeben (z.B. 0,5 für 50 Cent):");
                    double eingabe = input.nextDouble();
                    restbetrag -= eingabe;
                    if (restbetrag > 0) {
                        System.out.println("Noch zu bezahlen:" + restbetrag + "Euro");
                    } else if (restbetrag < 0) {
                        System.out.println("Gutschein ausdrucken: " + (-restbetrag) + " Euro");
                    } else {
                        System.out.println("Vielen Dank! Ihre Karten sind gedruckt.");
                    }
                }
            zwischenbetrag = 0;
            }
        }
    }
}
