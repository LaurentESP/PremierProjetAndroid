package laurentesp.test;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Rectangle extends Shape implements Zoomx2{
    protected int height;
    protected int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.computeArea();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void computeArea(){
      area = width*height;
    }

    @Override
    public void zoomx2() {
        width *=2;
        height *=2;
    }
}
