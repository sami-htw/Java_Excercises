package labyrinth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Osama Ahmad  567074
 */
public class LabyrTests {
    private static Labyrinth labyrinth1, labyrinth2, labyrinth3;

    // wenn nur ein Weg existiert
    char[][] spielBoard1 = {
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', 'X', 'X'},
            {'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
            {' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X', ' ', ' '},
            {'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},

    };

    // Wenn mehrere Wege existieren
    char[][] spielBoard2 = {
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X'},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '},
            {'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', 'X'},
            {'X', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},

    };
    // Wenn überhaupt keinen Weg existiert
    char[][] spielBoard3 = {
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X'},
            {' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
            {'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X'},
            {' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X'},
            {'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', 'X'},
            {'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},

    };

    @Before
    public void setUp() {
        labyrinth1 = new Labyrinth(spielBoard1);
        labyrinth2 = new Labyrinth(spielBoard2);
        labyrinth3 = new Labyrinth(spielBoard3);
    }


    @Test // gut Testcase
    public void WennEinWegExist() throws InterruptedException {
        boolean ergebnis = labyrinth1.existWeg(5, 5);

        Assert.assertTrue(ergebnis == true);
    }

    @Test // Grenzfall Testcase, wo nur ein Weg gezeigt wird,obwohl mehrere Wege vorhanden sind
    public void WennMehrereWegeExistieren() throws InterruptedException {
        boolean ergebnis = labyrinth2.existWeg(5, 5); // mittle punkt

        Assert.assertTrue(ergebnis == true);
    }

    @Test// schlecht Testcase
    public void WennKeinenWegExistiert() {
        try {
            boolean ergebnis = labyrinth3.existWeg(-2, -5); // Außerhalb spielboard, InterruptedException is expected
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
