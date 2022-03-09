package pflichtAufgabe2;


/**
 * 
 * @author Osama Ahmad  567074
 */
public class ShapeTester {
    public static void main(String[] args) throws InValidValueException {

        // Points with coordinates
        Point point1 = new Point(10.0, 40.0);
        Point point2 = new Point(20.0, 30.0);
        Point point3 = new Point(30.0, 20.0);


        // initial Shape
        Shape shape1 = new Shape(point1);


        // another shaper
        Rectangle rectangle1 = new Rectangle(point2, 35.0, 15.0);
        rectangle1.setSideLength(point1.getxOrigin() + point2.getxOrigin());
        rectangle1.setSideWidth(point1.getyOrigin() + point2.getyOrigin());

        Rectangle square1 = new Square(point3, 10.0, 5.0);
        square1.setSideLength(point3.getxOrigin() - point2.getxOrigin());
        square1.setSideWidth(point2.getyOrigin() - point3.getyOrigin());

        Shape circle1 = new Circle(new Point(40.0, 10.0), 25.0);

        //  shape Details.
        Reporter.report(shape1);
        Reporter.report(rectangle1);
        Reporter.report(square1);
        Reporter.report(circle1);


    }
}
