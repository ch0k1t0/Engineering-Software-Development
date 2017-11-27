import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

	public String CreateFirstMenu() throws Exception {
		String menuSelection = "";

		// creating first menu
		System.out.println("1. Create 2D Shapes");
		System.out.println("2. Create 3D Shapes");
		System.out.println("3. Exit");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		menuSelection = br.readLine();

		if (menuSelection.equals("1") || menuSelection.equals("2") || menuSelection.equals("3")) {
			System.out.println("Your selection is " + menuSelection);
		} else {
			System.out.println("Invalid selection");
		}
		return menuSelection;
	}

	public Shapes Create2DMenu() throws Exception {
		String selection = "";
		Shapes returnShape = null;

		// creating first menu
		System.out.println("Enter shape name: Triangle, Rectangle or Circle");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		selection = br.readLine();

		if (selection.equals("Triangle")) {
			System.out.println("Enter hypotenuse,adjacent,opposite values");
			selection = br.readLine();
			String[] listDimensions = selection.split(",");
			returnShape = new Triangle(Double.parseDouble(listDimensions[0]), Double.parseDouble(listDimensions[1]),
					Double.parseDouble(listDimensions[2]));
		} else if (selection.equals("Rectangle")) {
			System.out.println("Enter length,width");
			selection = br.readLine();
			String[] listDimensions = selection.split(",");
			returnShape = new Rectangle(Double.parseDouble(listDimensions[0]), Double.parseDouble(listDimensions[1]));
		} else if (selection.equals("Circle")) {
			System.out.println("Enter radius");
			selection = br.readLine();
			returnShape = new Circle(Double.parseDouble(selection));
		} else
		{
			System.out.println("Invalid selection");
		}		
					
		return returnShape;
	}

}
