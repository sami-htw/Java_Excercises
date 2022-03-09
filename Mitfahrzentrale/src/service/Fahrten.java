package service;

import mitfahrzentrale.Person;

/**
 * @author Osama
 */
public class Fahrten {
    private TeilFahrt start;
    public double gesamteFahrtKosten = 0;

    public Fahrten(TeilFahrt[] teilFahrtArray) {
        if (teilFahrtArray.length < 2) {
            throw new IllegalArgumentException("Array muss mindestens 2 Stationen haben");
        }
        start = teilFahrtArray[0];
        for (int i = 0; i < teilFahrtArray.length; i++) {
            teilFahrtArray[i].next = teilFahrtArray[i + 1];
            this.gesamteFahrtKosten += teilFahrtArray[i].fahrtKosten;
            if (teilFahrtArray.length <= i + 2) {
                this.gesamteFahrtKosten += teilFahrtArray[i + 1].fahrtKosten; // wegen abbruch bedingung muss fahrtkosten von letzter stadt nicht berechnet werden
                break;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder fahrt = new StringBuilder();
        fahrt.append("Kosten: " + gesamteFahrtKosten);
        fahrt.append(System.getProperty("line.separator"));
        TeilFahrt current = start;
        while (current.next != null) {
            fahrt.append("->");
            fahrt.append(current.stationName);
            fahrt.append("(" + current.transport.transportName() + ": freiePlätze=" + current.transport.getFreieSitzPlätze() + ")");
            current = current.next;
        }
        fahrt.append("->"); // letzte iteration brauch keine freie Plätze angabe
        fahrt.append(current.stationName);
        fahrt.append(System.getProperty("line.separator"));
        return fahrt.toString();
    }


    public boolean fahrtBuchen(Person person) {
        TeilFahrt current = start;
        //überprüfe ob es freie plätze überall in der Fahrt existiert wenn nein return false
        while (current.next != null) {
            if (current.transport.getFreieSitzPlätze() == 0) {
                return false;
            }
            current = current.next;
        }
        current = start; // current zurücksetzen
        //da oben schon gecheckt ob buchung möglich ist nur noch buchen
        while (current.next != null) {
            current.transport.personBuchen(person);
            current = current.next;
        }
        return true;
    }


    public boolean fahrtStornieren(Person person) {
        TeilFahrt current = start;
        // Falls person gebucht hat d.h. in personenArray existiert , dann person auf null setzen durch aufrufen der
        // methode personStornieren in abstrakte klasse Transportmittel
        while (current.next != null) {
            current.transport.personStornieren(person);
            current = current.next;
        }
        return true;
    }


    public boolean schonGebucht(Person person) {
        //da Person immer einmal buchen kann, es wird an die abstrakte klasse Transportmittel delegiert zwecks duplikat-buchung zu vermeiden
        return start.transport.personSchonGebucht(person);
    }
}

