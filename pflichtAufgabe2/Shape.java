package pflichtAufgabe2;


/**
 * Base class for geometrical shapes.
 * Each shape has an explicit origin
 * represented by a point: (x,y).
 *
 * 
 * @author Osama Ahmad  567074
 * @ version 1.x
 */
public class Shape {


    Point point;


    public Shape(Point point) {


        this.point = point;
    }


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }


    /**
     * calculate the area of a shape. the base shape is just point so it has no
     * area.
     *
     * @return the area of the shape
     */

    public double calculateArea() {
        double initialArea = 0.0;

        return initialArea;
    }


    /**
     * calculate the circumference of a shape. the base shape is just point so
     * it has no circumference.
     *
     * @return the circumference of the shape
     */
    public double calculateCircumference() {
        double initialCircumference = 0.0;
        return initialCircumference;

    }

    /**
     * @return xOrigin
     * @return yOrigin
     */

    @Override
    public String toString() {
        return "Shape with Origin: (" + point.getxOrigin() + "," + point.getyOrigin() + ")";
    }
}
