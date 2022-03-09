package pflichtAufgabe2;


/**
 * 
 * @author Osama Ahmad  567074
 */
public class Reporter {

    public static void report(Shape s) {

        System.out.println(s + "/ Area:" + s.calculateArea() + "/ Circumference:" + s.calculateCircumference());
    }
}
