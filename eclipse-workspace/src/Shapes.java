import java.io.Serializable;
//
public abstract class Shapes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noOfSides;
	private String name;

	public int getNoOfSides() {
		return noOfSides;
	}

	public Shapes(String name, int noOfSides) {
		this.name = name;
		this.noOfSides = noOfSides;
	}
	
	public String getName() {
		return name;
	}
}