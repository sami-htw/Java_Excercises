/**
 * @author Osama Ahmad  567074
 * @version 1.0, 27.06/2021
 */

public class GenericNumberHelper<T> {

    T alpha;
    T beta;

    public GenericNumberHelper(T alpha, T beta) {
        this.alpha = alpha;
        this.beta = beta;
    }


    public static <T extends Number> T division(T firstVal, T secondVal) {
        Integer ergebnis = firstVal.intValue() / secondVal.intValue(); // als Int-wert zurückgeliefert
        return (T) ergebnis;
    }


    public static <T extends Comparable<T>> int compare(T val1, T val2) {

        if (val1 == null) return val2 == null ? -1 : 0;
        if (val2 == null) return val1 == null ? -1 : 0;

        if (val1 != null && val2 != null) return 1;
        return val1.compareTo(val2);
    }

    // Die zweite Variante zum Vergleichen(compare)
    public static int vergleichenViaGenerischeReferenz(GenericNumberHelper genericNumberHelper) {
        int returnedValue = 0;
        if (genericNumberHelper.alpha == null)
            return genericNumberHelper.beta == null ? -1 : 0;
        if (genericNumberHelper.beta == null)
            return genericNumberHelper.alpha == null ? -1 : 0;

        if (genericNumberHelper.alpha != null && genericNumberHelper.beta != null) returnedValue = 1;

        return returnedValue;

    }


}
