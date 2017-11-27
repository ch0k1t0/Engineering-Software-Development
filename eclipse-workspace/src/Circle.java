import java.io.Serializable;

public class Circle extends TwoDShapes implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double radius;
	    final double pi = Math.PI;

	    public Circle(double radius) {
	    	super("Circle", 2);
	    	this.radius = radius;
	    }

	    @Override
	    public double getArea() {
	        // A = pi r^2
	        return pi * Math.pow(radius, 2);
	    }

	    @Override
	    public double getPerimeter() {
	        // P = 2 pi r
	        return 2 * pi * radius;
	    }
}