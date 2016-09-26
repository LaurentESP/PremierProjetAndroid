package laurentesp.test;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Ellipse extends Shape {
    protected int smallRay;
    protected int largeRay;

    public Ellipse(int smallRay, int largeRay) {
        this.smallRay = smallRay;
        this.largeRay = largeRay;
        this.computeArea();
    }

    public int getSmallRay() {
        return smallRay;
    }

    public int getLargeRay() {
        return largeRay;
    }

    @Override
    public void computeArea() {
        area = Math.PI*smallRay*largeRay;
    }
}
