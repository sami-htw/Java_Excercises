package pflichtAufgabe2;

import java.text.DecimalFormat;


/**
 * 
 * @author Osama Ahmad  567074
 */
public class Rectangle extends Shape {
    private double xDelta;
    private double yDelta;


    private double sideLength;
    private double sideWidth;

    // Initialization takes place in the constructor of the class Rectangle, which calls the constructor of the super class.
    public Rectangle(Point point, double xDelta, double yDelta) throws InValidValueException {
        super(point);

        if (xDelta < 0 || yDelta < 0) {
            throw new InValidValueException("negativ values are invalid");
        }
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }


    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideWidth() {
        return sideWidth;
    }

    public void setSideWidth(double sideWidth) {
        this.sideWidth = sideWidth;
    }

    /*
     * The class contains an calculateArea() method  to calculate the area of the rectangle and Square.
     */

    @Override
    public double calculateArea() {
        double result = getSideLength() * getSideWidth();
        result = Double.parseDouble(new DecimalFormat("#.#").format(result));
        return result;
    }


    // The class contains a Circumference method that should determine the Circumference of the rectangle and square.
    @Override
    public double calculateCircumference() {
        double result = 2 * (getSideLength() + getSideWidth());
        result = Double.parseDouble(new DecimalFormat("#.#").format(result));
        return result;
    }


    /*
     * The class contains a tostring() method ,which
     * delivers the The type of object (here Rectangle) and values for (XDelta and YDelta) .
     * @return XDelta
     * @return YDelta
     */
    @Override
    public String toString() {
        return "Rectangle with origin: " +
                getPoint() +
                ", xDelta=" + xDelta +
                ", yDelta=" + yDelta
                ;
    }
}
