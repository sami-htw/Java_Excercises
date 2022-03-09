package labyrinth;

/**
 * @author Osama Ahmad  567074
 */
public class TestLabyrinth {

    public static void main(String[] args) throws InterruptedException {

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


        // einen Weg existiert
        System.out.println("Das erste SpielBoard:\n");
        wegÜberprüfung(spielBoard1);


        //mehrere Wege, aber einer wird gezeigt
        System.out.println("Das zweite SpielBoard:\n");
        wegÜberprüfung(spielBoard2);

        // keinen Weg existiert
        System.out.println("Das dritte SpielBoard:\n");
        wegÜberprüfung(spielBoard3);
    }

    /**
     * Nach der Nachricht, ob ein Weg gefunden ist, oder nicht, liefert true oder falls.
     *
     * @param spielBoard
     * @throws InterruptedException falls koordinate außerhalb spielBoard
     */
    private static void wegÜberprüfung(char[][] spielBoard) throws InterruptedException {
        Labyrinth.printSpielBoard(spielBoard);
        Labyrinth lab = new Labyrinth(spielBoard);
        boolean status = true;
        if (lab.existWeg(5, 5)) { // mitte des Boards
            System.out.println("Existiert einen Weg: " + status);
        } else {
            System.out.println("Existiert keinen Weg: " + !status);
        }
        Labyrinth.printSpielBoard(spielBoard); // zweiter Aufruf zwecks Wegmarkierung mit Sternchen

    }
}
