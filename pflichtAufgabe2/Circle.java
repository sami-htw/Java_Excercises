package pflichtAufgabe2;

import java.text.DecimalFormat;

/**
 * 
 * @author Osama Ahmad  567074
 */
public class Circle extends Shape {

    private double radius;


    public Circle(Point point, double radius) throws InValidValueException {
        super(point);
        if (radius < 0) {
            throw new InValidValueException("Negativ values are invalid");
        }

        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        double result = (radius * radius) * Math.PI;
        // change decimal format to show only one digit after comma
        result = Double.parseDouble(new DecimalFormat("#.#").format(result));
        return result;
    }

    @Override
    public double calculateCircumference() {
        double result = Math.PI * 2 * radius;
        // change decimal format to show only one digit after comma
        result = Double.parseDouble(new DecimalFormat("#.#").format(result));
        return result;
    }

    /**
     * toString() method to deliver the type
     * of Object (hier Circle) and radius.
     *
     * @return radius
     */

    @Override
    public String toString() {
        return "Circle with origin: " + getPoint() +
                " and radius: " + radius;
    }
}
