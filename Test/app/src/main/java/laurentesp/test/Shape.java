package laurentesp.test;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public abstract class Shape {
    protected double area = 0;

    public Shape() {

    }

    public double getArea() {
        return area;
    }

    public abstract void computeArea();
}
