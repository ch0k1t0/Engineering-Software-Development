
import java.io.Serializable;

public class Triangle extends TwoDShapes implements Serializable {
	
	private static final long serialVersionUID = 5950169519310163575L;
	
	private final double a, b, c; // sides

    public Triangle(double a, double b, double c) {
    	super("Triangle", 3);
    	this.a = a;
        this.b = b;
        this.c = c;              
    }

    @Override
    public double getArea() {
        // Heron's formula:
        // A = SquareRoot(s * (s - a) * (s - b) * (s - c)) 
        // where s = (a + b + c) / 2, or 1/2 of the perimeter of the triangle 
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        // P = a + b + c
        return a + b + c;
    }
}