public class AusnahmeTestOhneBehandlung {
    /**
     * Einfaches Programm, das eine NumberFormatException auslöst beim
     * Konvertieren einer Zeichenkette in eine ganze Zahl.
     *
     * @author Osama Ahmad  567074
     * @version 1.0, 27.06/2021
     */
    public static void main(String[] args) {
        // das  Quellcode wird geändert, sodass kein Laufzeitfehler mehr auftritt.
        int i;
        int basis = 10;


        System.out.println("Die erste Variante : ");
        do {

            //Die Methode der Klasse Integer überprüft, ob der String s eine bezüglich der Basis radix gültige
            //Zahl darstellt. Wenn dies der Fall ist, wird der entsprechende Wert geliefert und
            //andernfalls die Ausnahme NumberFormatException ausgelöst. Wenn der Parameter radix (basis)fehlt, wird 10 angenommen.
            i = Integer.parseInt("40", basis);

            System.out.println("40 zur Basis " + basis + " = " + i);
            basis--;

        } while (basis > 4);
        System.out.println("Für 4,3,2 existiert keine numerische Darstellung");


        System.out.println("\nDie Zweite Variante : ");

        for (basis = 10; basis >= 2; --basis) {

            if (basis <= 4) {
                System.out.println("keine weitere mögliche numerische Darstellung");
                return;
            }
            i = Integer.parseInt("40", basis);

            System.out.println("40 zur Basis " + basis + " = " + i);

        }


    }


}
