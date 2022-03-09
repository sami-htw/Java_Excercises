import mitfahrzentrale.Bus;
import mitfahrzentrale.Person;
import mitfahrzentrale.Pkw;
import mitfahrzentrale.Transportmittel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.Fahrten;
import service.FahrtenService;
import service.Service;
import service.TeilFahrt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Osama Ahmad 567074
 */
public class MitfahrtZentraleTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // als buffer verwendet zum Vergleichen
    private final PrintStream originalOut = System.out;

    private FahrtenService service;
    Person p0;
    Person p1;
    Person p2;
    Person p3;
    Person p4;


    private double f2Kosten;
    private double f0Kosten;

    @Before
    public void setUp() {

        // wenn diese Zeile kommentiert, werden die Strings auf der Konsole vorgezeigt, aber String Werte werden in ByteArrayOutputStream nicht hinzugefügt
        System.setOut(new PrintStream(outContent)); // landet System.out in outContent und macht der Vergleich

        p0 = new Person("Max", "Mueller");
        p1 = new Person("Kevin", "bla");
        p2 = new Person("Samuel", "Jackson");
        p3 = new Person("Paul", "Walker");
        p4 = new Person("John", "Wick");

        Transportmittel bus0 = new Bus();
        Transportmittel pkw0 = new Pkw();
        TeilFahrt berlin0 = new TeilFahrt("Berlin", 50.0, bus0);
        TeilFahrt frankfurt0 = new TeilFahrt("Frankfurt", 20.2, pkw0);
        TeilFahrt koeln0 = new TeilFahrt("Köln", 0, null); // letzte Station hat keine Fahrtkosten und kein Transportmittel
        TeilFahrt[] array0 = {berlin0, frankfurt0, koeln0};
        Fahrten f0 = new Fahrten(array0);

        f0Kosten = 50.0 + 20.2;

        Transportmittel bus1 = new Bus();
        TeilFahrt berlin1 = new TeilFahrt("Berlin", 600.0, bus1);
        TeilFahrt amsterdam = new TeilFahrt("Amsterdam", 0, null);
        TeilFahrt[] array1 = {berlin1, amsterdam};
        Fahrten f1 = new Fahrten(array1);

        double f1Kosten = 600.0;

        Transportmittel pkw1 = new Pkw();
        TeilFahrt berlin2 = new TeilFahrt("Berlin", 135.0, pkw1);
        TeilFahrt stuttgart = new TeilFahrt("Stuttgart", 10.5, pkw1);
        TeilFahrt muenchen = new TeilFahrt("München", 0, null); // letzte Station hat keine Fahrtkosten und kein Transportmittel
        TeilFahrt[] array2 = {berlin2, stuttgart, muenchen};
        Fahrten f2 = new Fahrten(array2);

        f2Kosten = 135.0 + 10.5;

        Transportmittel pkw2 = new Pkw();
        Transportmittel bus2 = new Pkw();
        TeilFahrt hamburg = new TeilFahrt("Hamburg", 135.0, pkw2);
        TeilFahrt bremen = new TeilFahrt("Bremen", 1045.5, bus2);
        TeilFahrt tuebingen = new TeilFahrt("Tübingen", 1.2, bus2);
        TeilFahrt potsdam = new TeilFahrt("Potsdam", 101.4, bus2);
        TeilFahrt aachen = new TeilFahrt("Aachen", 0, null); // letzte Station hat keine Fahrtkosten und kein Transportmittel
        TeilFahrt[] array3 = {hamburg, bremen, tuebingen, potsdam, aachen};
        Fahrten f3 = new Fahrten(array3);

        double f3Kosten = 135.0 + 1045.5 + 1.2 + 101.4;

        Fahrten[] fahrtenArray = {f0, f1, f2, f3};
        service = new Service(fahrtenArray);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test // gut testcase
    public void stornierTest() {
        // ausgabe string erstellen
        StringBuilder b = new StringBuilder();
        b.append("Buchung Bestätigt " + "Kosten: " + f0Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Schon gebucht");
        b.append(System.getProperty("line.separator"));
        b.append("Fahrt storniert");
        b.append(System.getProperty("line.separator"));
        b.append("Noch nicht gebucht");
        b.append(System.getProperty("line.separator"));


        service.fahrtBuchen(0, p0);
        Assert.assertTrue(service.schonGebucht(0, p0));
        service.fahrtStornieren(0, p0);
        Assert.assertFalse(service.schonGebucht(0, p0));
        Assert.assertEquals(b.toString(), outContent.toString());


    }

    @Test //gut testcase
    public void ueberBuchen() {
        //fahrt mit nummer 2 ist ein pkw mit 4 sitzen
        // es wird 5 mal gebucht
        service.fahrtBuchen(2, p0);
        service.fahrtBuchen(2, p1);
        service.fahrtBuchen(2, p2);
        service.fahrtBuchen(2, p3);
        service.fahrtBuchen(2, p4);

        // der ausgabeString sollte 4 mal bestätigen und einmal ablehnen
        StringBuilder b = new StringBuilder();
        b.append("Buchung Bestätigt " + "Kosten: " + f2Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f2Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f2Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f2Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Abgelehnt");
        b.append(System.getProperty("line.separator"));
        Assert.assertEquals(b.toString(), outContent.toString());

    }

    @Test // gut testcase
    public void ueberBuchenFahrtMitBusDannPkw() {
        //fahrt mit nummer 0 fährt mit bus dann Pkw aber pkw hat nur 4 sitzer
        // es wird 5 mal gebucht das heißt ab dem 5. ist der pkw im 2. stop voll und überbucht
        service.fahrtBuchen(0, p0);
        service.fahrtBuchen(0, p1);
        service.fahrtBuchen(0, p2);
        service.fahrtBuchen(0, p3);
        service.fahrtBuchen(0, p4);

        // der ausgabeString sollte 4 mal bestätigen und einmal ablehnen
        StringBuilder b = new StringBuilder();
        b.append("Buchung Bestätigt " + "Kosten: " + f0Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f0Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f0Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Bestätigt " + "Kosten: " + f0Kosten);
        b.append(System.getProperty("line.separator"));
        b.append("Buchung Abgelehnt");
        b.append(System.getProperty("line.separator"));

    }

    @Test //gut testcase
    public void schonGebuchtTest() {
        service.fahrtBuchen(3, p0);
        service.fahrtBuchen(3, p1);
        service.fahrtBuchen(3, p2);
        service.fahrtBuchen(3, p3);
        service.fahrtBuchen(3, p4);
        Assert.assertTrue("Max hat schon gebucht : ", service.schonGebucht(3, p0));
        service.fahrtStornieren(3, p0);// Max hat storniert
        Assert.assertFalse("hat Max eine Buchung noch ?", service.schonGebucht(3, p0));

    }

    @Test(expected = IllegalArgumentException.class) // schlecht Testcase, wo ein einziges zwischenstopp existiert
    public void fahrtLengthTest() {
        Transportmittel bus = new Bus();
        TeilFahrt berlin = new TeilFahrt("Berlin", 50.0, bus);
        TeilFahrt[] einzigeStationArray = {berlin};
        Fahrten fahrten = new Fahrten(einzigeStationArray);
    }


}
