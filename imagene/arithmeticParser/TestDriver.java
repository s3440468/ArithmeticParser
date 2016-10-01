/****************************
 * Arithmetic Parser        *
 *                          *
 * Created by Andrew Sanger *
 * for                      *
 * Programming Project 1    *
 * SP3 2016                 *
 ****************************/

package imagene.arithmeticParser;

import imagene.arithmeticParser.parserExceptions.IncorrectVariablesException;
import imagene.arithmeticParser.parserExceptions.InvalidArgumentException;
import imagene.arithmeticParser.parserNodes.*;

public class TestDriver {
	public static void main(String[] args) {
		// These strings are examples of complex equations that will be supplied to the parser.
		String allString1 = "plus ( sqrt ( mod ( cube ( cube ( div ( cos ( square ( mod ( tan ( minus x pi ) ) ( sqrt ( minus y x ) ) ) ) ) ( plus ( square ( square ( plus ( tan y ) ( log x ) ) ) ) ( mod ( sin ( cos ( cube y ) ) ) ( mod ( plus ( plus y x ) ( plus y x ) ) ( square ( sqrt y ) ) ) ) ) ) ) ) ( sqrt ( plus ( square ( div ( square ( div ( square ( cube x ) ) ( sin ( mod y x ) ) ) ) ( mod ( sqrt ( div ( tan y ) ( mod x y ) ) ) ( minus ( sqrt ( plus x x ) ) ( log ( sin y ) ) ) ) ) ) ( sqrt ( plus ( sqrt ( minus ( sin ( minus x y ) ) ( mod ( minus x y ) ( tan x ) ) ) ) ( div ( mod ( log ( log y ) ) ( plus ( sin x ) ( log y ) ) ) ( cos ( sqrt ( plus x x ) ) ) ) ) ) ) ) ) ) ( sqrt ( tan ( plus ( div ( cube ( square ( log ( log ( plus ( sin x ) ( sin y ) ) ) ) ) ) ( plus ( cos ( square ( tan ( tan ( plus y y ) ) ) ) ) ( plus ( plus ( plus ( sqrt ( plus rand rand ) ) ( log ( sqrt pi ) ) ) ( log ( square ( sqrt y ) ) ) ) ( plus ( square ( mod ( plus x x ) ( tan x ) ) ) ( div ( plus ( cos y ) ( square x ) ) ( sqrt ( square x ) ) ) ) ) ) ) ( sin ( square ( sqrt ( minus ( tan ( minus ( plus y x ) ( plus x y ) ) ) ( mod ( sin ( cube x ) ) ( mod ( plus x y ) ( square y ) ) ) ) ) ) ) ) ) )";
		String redString1 = "cos ( square ( times y ( mod x y ) ) )";
		String greenString1 = "sin ( cube ( div y ( mod x y ) ) )";
		String blueString1 = "tan ( log rand )";		
		
		// These nodes will hold the first node of the equation tree that is returned.
		ArithmeticNode allColorNode = null, redColorNode = null, 
				greenColorNode = null, blueColorNode = null;
		
		// Sample values of RGB for X and Y.
		double xRed = 50, xBlue = 100, xGreen = 155;
		double yRed = 25, yBlue = 60, yGreen = 255;
		
		// Creates PixelNodes out of supplied values.
		PixelNode xPixel = new PixelNode(xRed, xBlue, xGreen);
		PixelNode yPixel = new PixelNode(yRed, yBlue, yGreen);		
		
		// These values hold the results of equations being carried out on the above RGB values.
		PixelNode allColorResult;
		double redResult, greenResult, blueResult;
		
		// Creates a instance of the ParserInterface, and sets testing to true, so we can see
		// the results.
		ParserInterface PS = ParserInterface.getInstance();
		PS.setTesting(true);
		
		// The following gets the equation trees for all strings.
		System.out.println("TEST POINT 1");
		
		try {
			System.out.println("\nCurrent string for all colours : " + allString1);
			allColorNode = PS.getArithmetic(allString1);
		
			System.out.println("\nCurrent string for red : " + redString1);		
			redColorNode = PS.getArithmetic(redString1);
		
			System.out.println("\nCurrent string for green : " + greenString1);		
			greenColorNode = PS.getArithmetic(greenString1);
		
			System.out.println("\nCurrent string for blue : " + blueString1);		
			blueColorNode = PS.getArithmetic(blueString1);
		} catch ( InvalidArgumentException | IncorrectVariablesException e){
			e.printStackTrace();
			System.exit(0);
		}
			
		System.out.println("\nTEST POINT 2\n");
		
		// Runs the equations on the supplied color values
		allColorResult = allColorNode.operation(xPixel, yPixel);
		redResult = redColorNode.redOperation(xPixel, yPixel);
		greenResult = greenColorNode.greenOperation(xPixel, yPixel);
		blueResult = blueColorNode.blueOperation(xPixel, yPixel);
		
		// Creates a test node so we can run testAsString() and see the final results.
		PixelNode resultTest = new PixelNode(redResult, greenResult, blueResult);
		
		allColorResult.testAsString();
		resultTest.testAsString();
	}
	
}
