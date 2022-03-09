package service;


import mitfahrzentrale.Person;

/**
 * @author Osama Ahmad 567074
 */
public class Service implements FahrtenService {
    Fahrten[] fahrtenArray;

    public Service(Fahrten[] fahrtenArray) {
        this.fahrtenArray = fahrtenArray;

    }

    @Override
    public void zeigeFahrten() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < fahrtenArray.length; i++) {
            b.append((i + 1) + ".Fahrt"); // fahrten werden ab 1 nummeriert
            b.append(System.getProperty("line.separator"));
            b.append(this.fahrtenArray[i].toString());
        }
        System.out.println(b.toString());
    }

    @Override
    public void fahrtBuchen(int fahrtNummer, Person person) {
        if (fahrtNummer < 0 || fahrtNummer >= fahrtenArray.length) {
            System.out.println("falsche fahrtennummer");
            return;
        }
        if (fahrtenArray[fahrtNummer].fahrtBuchen(person)) {

            buchungBestätigen(fahrtenArray[fahrtNummer].gesamteFahrtKosten);
            return;
        }
        buchungAblehnen();
    }


    @Override
    public void fahrtStornieren(int fahrtNummer, Person person) {
        System.out.println("Fahrt storniert");
        fahrtenArray[fahrtNummer].fahrtStornieren(person);
    }

    @Override
    public void buchungBestätigen(double kosten) {
        System.out.println("Buchung Bestätigt " + "Kosten: " + kosten);
    }

    @Override
    public void buchungAblehnen() {
        System.out.println("Buchung Abgelehnt");
    }

    @Override
    public boolean schonGebucht(int fahrtNummer, Person person) {
        if (fahrtenArray[fahrtNummer].schonGebucht(person)) {
            System.out.println("Schon gebucht");
            return true;
        }
        System.out.println("Noch nicht gebucht");
        return false;
    }
}
