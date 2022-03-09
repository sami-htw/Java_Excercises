import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Osama Ahmad  567074
 * @version 1.0, 27.06/2021
 */
public class AusnahmeTestMitBehandlung {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException {


        AusnahmeTestMitBehandlung ausnahmeTestMitBehandlung = new AusnahmeTestMitBehandlung();
        ausnahmeTestMitBehandlung.ausnahmeMitTryCatchAbfangen();
        // Ausnahme wird abgefangen
        try {

            ausnahmeTestMitBehandlung.fehlerMeldungWeiterleiten();

        } catch (NumberFormatException e) {
            System.out.println("Numerische Darstellung ist nicht möglich");

        }

        try {
            System.out.println("Geben Sie zähler ein : ");
            int zähler = scanner.nextInt();
            System.out.println("Geben Sie nenner ein : ");
            int nenner = scanner.nextInt();
            System.out.println("GanzzahlDivision : " + ausnahmeTestMitBehandlung.GanzzahlDivisionCatch(zähler, nenner));


            // multi-catch behandlung
        } catch (ArithmeticException e) {
            System.out.println("falsche Eingabe : " + e.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Invalid eingabe : " + ex.getMessage());
        }


        ///////////////////////////////////////
        ///          Zwei int-werte         ///
        //////////////////////////////////////

        int intAlpha = 6;
        int intBeta = 2;

        GenericNumberHelper<Integer> intReferenz = new GenericNumberHelper<>(intAlpha, intBeta);

        System.out.println("\nInteger division : " + GenericNumberHelper.division(intAlpha, intBeta));
        System.out.println("Vergleich int-Werte : " + GenericNumberHelper.compare(intAlpha, intBeta));
        System.out.println("Vergleich null Werte : " + GenericNumberHelper.compare(null, null));
        System.out.println("Vergleich wenn einer der int-Werte null ist  : " + GenericNumberHelper.compare(intAlpha, null));

        System.out.println("vergleichenViaGenerischeReferenz : " + GenericNumberHelper.vergleichenViaGenerischeReferenz(intReferenz));


        ///////////////////////////////////////
        ///          Zwei double-werte      ///
        ///////////////////////////////////////
        double doubleAlpha = 8.0;
        double doubleBeta = 4.0;
        GenericNumberHelper<Double> doubleReferenz = new GenericNumberHelper<>(doubleAlpha, doubleBeta);
        System.out.println("\nDouble division : " + GenericNumberHelper.division(doubleAlpha, doubleBeta));
        System.out.println("Vergleich double-Werte : " + GenericNumberHelper.compare(doubleAlpha, doubleBeta));
        System.out.println("Vergleich null Werte : " + GenericNumberHelper.compare(null, null));
        System.out.println("Vergleich wenn einer der double-Werte null ist  : " + GenericNumberHelper.compare(doubleAlpha, null));
        System.out.println("vergleichenViaGenerischeReferenz : " + GenericNumberHelper.vergleichenViaGenerischeReferenz(doubleReferenz));

        ////////////////////////////////////////
        ///          Zwei float-werte      ///
        //////////////////////////////////////
        float floatAlpha = 12.0f;
        float floatBeta = 3.0f;
        GenericNumberHelper<Float> floatReferenz = new GenericNumberHelper<>(floatAlpha, floatBeta);
        System.out.println("\nFloat Division : " + GenericNumberHelper.division(floatAlpha, floatBeta));

        System.out.println("Vergleich float-Werte : " + GenericNumberHelper.compare(floatAlpha, floatBeta));
        System.out.println("Vergleich null Werte : " + GenericNumberHelper.compare(null, null));
        System.out.println("Vergleich wenn einer der float-Werte null ist  : " + GenericNumberHelper.compare(null, floatBeta));
        System.out.println("vergleichenViaGenerischeReferenz : " + GenericNumberHelper.vergleichenViaGenerischeReferenz(floatReferenz));


    }


    public void ausnahmeMitTryCatchAbfangen() {
        int basis = 0;
        int i;

        for (basis = 10; basis >= 2; --basis) {
            try {
                i = Integer.parseInt("40", basis);
                System.out.println("40 zur basis " + basis + " = " + i);

            } catch (NumberFormatException e) {
                System.out.println("40 ist keine Zahl zur Basis " + basis);
            }

        }

        System.out.println("Normales Programmende!");

    }

    public void fehlerMeldungWeiterleiten() throws NumberFormatException {
        System.out.println("\nDie Exception wird weitergegeben : ");
        int i;
        int basis = 0;
        for (basis = 10; basis >= 2; --basis) {
            i = Integer.parseInt("40", basis);
            System.out.println("40 zur Basis " + basis + " = " + i);

        }
    }


    public int GanzzahlDivisionCatch(int num1, int num2) {
        int ergebnis = 0;
        try {
            ergebnis = num1 / num2;
        } catch (InputMismatchException | ArithmeticException e) { // mehrere Exception werden in einem Catch behandelt
            System.out.println("Error !!!,keine gültige eingabe " + e.getMessage());
        }

        return ergebnis;
    }
}

