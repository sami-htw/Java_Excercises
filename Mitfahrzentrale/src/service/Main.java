package service;

import mitfahrzentrale.*;

/**
 * @author Osama Ahmad 567074
 */
public class Main {
    public static void main(String[] args) {
        Transportmittel bus = new Bus();
        Transportmittel pkw = new Pkw();
        TeilFahrt berlin = new TeilFahrt("Berlin", 50.0, bus);
        TeilFahrt frankfurt = new TeilFahrt("Frankfurt", 20.2, pkw);
        TeilFahrt koeln = new TeilFahrt("Köln", 0, null); // letzte Station hat keine Fahrtkosten und kein Transportmittel
        TeilFahrt[] array = {berlin, frankfurt, koeln};
        Fahrten f1 = new Fahrten(array);


        Transportmittel bus1 = new Bus();
        TeilFahrt berlin1 = new TeilFahrt("Berlin", 600.0, bus1);
        TeilFahrt amsterdam = new TeilFahrt("Amsterdam", 0, null);
        TeilFahrt[] array1 = {berlin1, amsterdam};
        Fahrten f2 = new Fahrten(array1);


        Transportmittel bus2 = new Bus();
        TeilFahrt berlin2 = new TeilFahrt("Berlin", 30.0, bus2);
        TeilFahrt magdeburg2 = new TeilFahrt("Magdeburg", 20.0, bus2);
        TeilFahrt hanover2 = new TeilFahrt("Hanover", 22.0, bus2);
        TeilFahrt koeln2 = new TeilFahrt("Köln", 0, null);


        TeilFahrt[] array2 = {berlin2, magdeburg2, hanover2, koeln2};
        Fahrten f3 = new Fahrten(array2);


        Transportmittel pkw3 = new Pkw();
        TeilFahrt berlin3 = new TeilFahrt("Berlin", 88.0, pkw3);
        TeilFahrt münchen = new TeilFahrt("München", 0.0, null);
        TeilFahrt[] array4 = {berlin3, münchen};
        Fahrten f4 = new Fahrten(array4);


        Fahrten[] fahrtenArray = {f1, f2, f3, f4};
        FahrtenService service = new Service(fahrtenArray);
        service.zeigeFahrten();


        Person p0 = new Person("Max", "Mueller");
        Person p1 = new Person("Kevin", "bla");
        Person p2 = new Person("Samuel", "Jackson");
        Person p3 = new Person("Paul", "Walker");
        Person p4 = new Person("John", "Wick");


        service.fahrtBuchen(3, p0);  // Buchung Bestätigt
        service.fahrtBuchen(3, p1); // Buchung Bestätigt
        service.fahrtBuchen(3, p2); // Buchung Bestätigt
        service.fahrtBuchen(3, p3); // Buchung Bestätigt
        service.fahrtBuchen(3, p4); // Buchung abgelehnt pkw hat nur 4 plätze

        // wenn 2 personen storniert haben
        service.fahrtStornieren(3, p0); //Fahrt storniert
        service.fahrtStornieren(3, p1); //Fahrt storniert

        // pkw hat 3 reservierte plätze und besteht die Möglichkeit wieder den 4-ten platz zu buchen
        service.fahrtBuchen(3, p4); // Buchung Bestätigt , da ein Platz frei geworden
        service.schonGebucht(3, p2); // schon gebucht wird gezeigt

    }
}
