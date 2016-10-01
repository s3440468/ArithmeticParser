/****************************
 * Arithmetic Parser        *
 *                          *
 * Created by Andrew Sanger *
 * for                      *
 * Programming Project 1    *
 * SP3 2016                 *
 ****************************/

package imagene.arithmeticParser.parserNodes;

// This PixelNode extends ParserNode, and is designed to hold RGB values
// for X and Y pixels.
public class PixelNode extends ParserNode{
	// RGB color values.
	private double redColor;
	private double blueColor;
	private double greenColor;
	
	// Constructor.
	public PixelNode(double red, double green, double blue){
		this.redColor = this.fixColor(red);
		this.greenColor = this.fixColor(green);
		this.blueColor = this.fixColor(blue);
	}
	
	// Setter to set all colors at once.
	public void setAllColor(double newRed, double newBlue, double newGreen) {
		this.setRedColor(newRed);
		this.setBlueColor(newBlue);
		this.setGreenColor(newGreen);
	}
	
	// Getters and setters.
	public double getRedColor() {
		return this.redColor;
	}
	
	public void setRedColor(double newRed) {
		this.redColor = this.fixColor(newRed);
	}
	
	public double getBlueColor() {
		return this.blueColor;
	}
	
	public void setBlueColor(double newBlue) {
		this.blueColor = this.fixColor(newBlue);
	}
	
	public double getGreenColor() {
		return this.greenColor;
	}
	
	public void setGreenColor(double newGreen) {
		this.greenColor = this.fixColor(newGreen);
	}
	
	// This function will normalize any double numbers that are received
	// by this object. This means that all values will always be between
	// 0 and 255. Negative numbers are turned into their positive
	// counterparts, 0 is turned into 1 (to stop issues with some Arithmetic
	// operations that don't like 0), and anything above 255 is returned
	// to 255.
	public double fixColor(double color) {
		if (color < -255) {
			return 255;
		} else if (color < 0) {
			return (Math.abs(color));
		} else if (color == 0) {
			return 1;
		} else if (color > 255) {
			return 255;
		}
		
		else return color;
	}

	// This operation function is overriden, but never used for PixelNode
	@Override
	public PixelNode operation(PixelNode XPixel, PixelNode YPixel) {
		return null;
	}
	
	// Displays information about this Object, and the colors contained
	// within. Also normalizes the colors into 0 - 255 (
	//
	// NOTE: Normalizing the numbers was just a test i was trialling,
	// due to the fact that most numbers received by this code ended up
	// being very low, in the 0 - 5 range. 
	public void testAsString() {
		System.out.println("==============================");
		System.out.println("VALUES CURRENTLY IN PIXEL NODE");
		System.out.println("==============================");
		System.out.println("Red Color is : " + this.redColor);
		System.out.println("Green Color is : " + this.greenColor);
		System.out.println("Blue Color is : " + this.blueColor);
		System.out.println("\nTEST OF VALUES NORMALIZED TO 0-255\n");
		System.out.println("Red : " + (int)((this.redColor % 1) * 255));
		System.out.println("Green : " + (int)((this.greenColor % 1) * 255));
		System.out.println("Blue : " + (int)((this.blueColor % 1) * 255));
		System.out.println();
	}
}
