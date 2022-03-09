package labyrinth;

/**
 * @author Osama Ahmad  567074
 */
public class Labyrinth {

    private char[][] lab;

    public Labyrinth(char[][] lab) {
        this.lab = lab;
    }

    /**
     * quadratisches (10x10)-Labyrinths
     *
     * @param spielBoard
     */
    public static void printSpielBoard(char[][] spielBoard) {

        for (int zeile = 0; zeile < 10; zeile++) {
            for (int spalte = 0; spalte < 10; spalte++) {
                System.out.print(spielBoard[zeile][spalte] + " ");
            }

            System.out.println(" ");
        }
        System.out.println();
    }

    /**
     * Die Methode existWeg gibt zurück, ob es einen Weg vom Punkt (x, y) bis zum Rand des Labyrinths gibt.
     *
     * @param x
     * @param y
     * @return situation, wenn ein weg existiert liefert true, sonst wird die methode rekursive aufgerufen mit neuer richtung.
     * @throws InterruptedException wenn x oder y außerhalb spielBoard
     */
    public boolean existWeg(int x, int y) throws InterruptedException {
        boolean situation = false;


        if (istGültigeSituation(x, y)) {
            lab[x][y] = '*';

            if (x < 0 || x > 10 || y < 0 || y > 10) {
                throw new InterruptedException("Außerhalb SpielBoard");
            }
            if (x == lab.length - 1 || y == lab[0].length - 1) {
                situation = true;
            } else {
                situation = existWeg(x - 1, y);//oben

                if (!situation) {
                    situation = existWeg(x, y - 1);//links

                }
                if (!situation) {
                    situation = existWeg(x + 1, y);//unten
                }
                if (!situation) {
                    situation = existWeg(x, y + 1);//recht
                }
            }

            if (situation) {
                // übrigens die koordinate sind von 0 bis 9 jeweils für Zeilen und Spalten von End-Punkt bist mittel-Punkt
                System.out.println("Punkt: " + x + "," + y);
            }


        }
        return situation;
    }


    /**
     * Gültige zustände werden überprüft, wenn platz nicht frei wird false zurückgeliefert.
     *
     * @param zeile
     * @param spalte
     * @return zustand  true wenn Weg existiert oder false mit Wänden (gesperrt)
     */
    private boolean istGültigeSituation(int zeile, int spalte) {
        boolean zustand = false;

        if (zeile >= 0 && zeile < lab.length && spalte >= 0 && spalte < lab[0].length) {
            if (lab[zeile][spalte] == ' ') {
                zustand = true;
            }
        }
        return zustand;

    }
}
