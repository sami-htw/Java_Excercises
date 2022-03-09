package pflichtAufgabe2Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pflichtAufgabe2.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 
 * @author Osama Ahmad  567074
 */
public class ShapeTests {

    public static Point point1, point2, point3, point4;

    @Before
    public void setUp() throws InValidValueException {

        point1 = new Point(10.0, 40.0);
        point2 = new Point(20.0, 30.0);
        point3 = new Point(30.0, 20.0);
        point4 = new Point(40.0, 10.0);


    }

    private Shape getMainShapeReference() {
        return new Shape(point1);
    }

    private Rectangle getRectangleReference() throws InValidValueException {
        return new Rectangle(point2, 35.0, 15.0);
    }

    private Shape getCircleReference() throws InValidValueException {
        return new Circle(point4, 25.0);
    }

    private Rectangle getSquareReference() throws InValidValueException {
        return new Square(point3, 10.0, 5.0);
    }

    ///////////////// Good Testcases /////////////////

    @Test // first good testcase
    public void mainShapeAreaAndCircumferenceTest() {
        Shape mainShape = this.getMainShapeReference();
        double actualMainShapeCircumference = mainShape.calculateCircumference();
        double actualMainShaeArea = mainShape.calculateArea();
        Assert.assertEquals((int) 0.0, (int) actualMainShapeCircumference);
        Assert.assertTrue(actualMainShaeArea == 0.0);

    }

    @Test // 2-nd good testcase
    public void rectangleAreaAndCircumferenceTest() throws InValidValueException {
        Rectangle rectangle = this.getRectangleReference();
        rectangle.setSideLength(point1.getxOrigin() + point2.getxOrigin());
        rectangle.setSideWidth(point1.getyOrigin() + point2.getyOrigin());

        double rectangleArea = rectangle.calculateArea();
        double rectangleCircumference = rectangle.calculateCircumference();

        Assert.assertTrue(rectangleArea == 2100.0);
        Assert.assertTrue(rectangleCircumference == 200.0);
    }

    @Test // 3-d good testcase
    public void squareAreaAndCircumferenceTest() throws InValidValueException {
        Rectangle square = this.getSquareReference();
        square.setSideLength(point3.getxOrigin() - point2.getxOrigin());
        square.setSideWidth(point2.getyOrigin() - point3.getyOrigin());

        double squareArea = square.calculateArea();
        double squareCircumference = square.calculateCircumference();

        Assert.assertEquals((int) squareArea, (int) 100.0);
        Assert.assertEquals((int) squareCircumference, (int) 40.0);

    }

    @Test // 4-th good testcase
    public void circleAreaAndCircumferenceTest() throws InValidValueException {
        Shape circle = this.getCircleReference();


        double circleArea = circle.calculateArea();
        double circleCircumference = circle.calculateCircumference();

        Assert.assertEquals((int) circleArea, (int) 1963.5);
        Assert.assertEquals((int) circleCircumference, (int) 157.1);

    }


    /////////////// Edge Testcases (Grenzfall) ///////////////////


    @Test //first edge testcase
    public void rectangleAreaAndCircumferenceEdgeTest() throws InValidValueException {

        Rectangle rectangle = this.getRectangleReference();
        rectangle.setSideLength(0.0 + 0.0);
        rectangle.setSideWidth(0.0 + 0.0);

        double rectangleArea = rectangle.calculateArea();
        double rectangleCircumference = rectangle.calculateCircumference();

        Assert.assertTrue(rectangleArea == 0.0);
        Assert.assertTrue(rectangleCircumference == 0.0);
    }

    @Test // 2-nd edge testcase
    public void squareAreaAndCircumferenceEdgeTest() throws InValidValueException {
        Rectangle square = this.getSquareReference();
        square.setSideLength(point3.getxOrigin() - 0.0);
        square.setSideWidth(point2.getyOrigin() - 0.0);

        double squareArea = square.calculateArea();
        double squareCircumference = square.calculateCircumference();

        Assert.assertEquals((int) squareArea, (int) 900.0);
        Assert.assertEquals((int) squareCircumference, (int) 120.0);
    }

    @Test //3-d edge testcase
    public void circleAreaAndCircumferenceEdgeTest() throws InValidValueException {


        Circle circleNewInstance = new Circle(point4, 0.0);
        double squareArea = circleNewInstance.calculateArea();
        double squareCircumference = circleNewInstance.calculateCircumference();

        Assert.assertEquals((int) squareArea, (int) 0.0);
        Assert.assertEquals((int) squareCircumference, (int) 0.0);
    }


    ////////// Bad Testcases ////////////


    @Test // first bad Testcase
    public void rectangleAreaAndCircumferenceBadTest() {


        assertThrows(InValidValueException.class, () -> {
            Shape rectangleShape = new Rectangle(new Point(20.0, 30.0), -35.0, 15.0);

        });
    }

    @Test(expected = InValidValueException.class) // 2-nd bad
    public void squareAreaAndCircumferenceBadTest() throws InValidValueException {
        Rectangle square = new Square(new Point(-30.0, 20.0), 10.0, 5.0);
    }

    @Test //3-d bad Testcases
    public void circleAreaAndCircumferenceBadTest() {

        try {
            Shape circleNewInstance = new Circle(point4, -25.0);

        } catch (InValidValueException e) {
            e.printStackTrace();
        }


    }


}
