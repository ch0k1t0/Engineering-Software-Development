import java.io.Serializable;

public class Rectangle extends TwoDShapes  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double width, length; //sides

    public Rectangle(double width, double length) {
    	super("Rectangle", 2);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        // A = w * l
        return width * length;
    }

    @Override
    public double getPerimeter() {
        // P = 2(w + l)
        return 2 * (width + length);
    }

}