package pflichtAufgabe2;

/**
 * 
 * @author Osama Ahmad  567074
 */
public class Point {

    // x-coordinate of the origin
    private double xOrigin;

    // y-coordinate of the origin
    private double yOrigin;



    public Point(double xOrigin, double yOrigin) throws InValidValueException {
        if (xOrigin <0||yOrigin<0){
            throw new InValidValueException("negativ values are invalid");
        }
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }


    public double getyOrigin() {
        return yOrigin;
    }


    public double getxOrigin() {
        return xOrigin;
    }


    /**
     *
     * @return xOrigin
     * @return yOrigin
     */

    @Override
    public String toString() {
        return "(" + xOrigin + "," + yOrigin + ")";
    }
}
