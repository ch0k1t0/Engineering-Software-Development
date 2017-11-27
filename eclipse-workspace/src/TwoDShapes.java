import java.io.Serializable;

public abstract class TwoDShapes extends Shapes implements Serializable {

	// https://codereview.stackexchange.com/questions/83769/implement-a-shape-abstract-class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TwoDShapes(String name, int noOfSides) {
		super(name, noOfSides);
		// TODO Auto-generated constructor stub
	}

	public int getDimensions() {
		return 2;
	}
	
	public abstract double getArea();

	public abstract double getPerimeter();
}
