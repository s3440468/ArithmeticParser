/****************************
 * Arithmetic Parser v1.2   *
 *                          *
 * Created by Andrew Sanger *
 * for                      *
 * Programming Project 1    *
 * SP3 2016                 *
 ****************************
 * SampleFormulaGenerator   *
 * Implementation provided  *
 * by Dorothea Baker        *
 ****************************/

package imagene.arithmeticParser;

import imagene.arithmeticParser.parserExceptions.IncorrectVariablesException;
import imagene.arithmeticParser.parserExceptions.InvalidArgumentException;
import imagene.arithmeticParser.parserNodes.*;

public class TestDriver {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}
	
	// (Version 1.2)
	// New test using updated requirements
	public static void test3() {
		final int populationSize = 4;
		//final int parent1Index = 2;
		//final int parent2Index = 3;
		final int xRed = 100, xBlue = 200, xGreen = 50;
		final int yRed = 79, yBlue = 36, yGreen = 178;
				
		SampleFormulaGenerator gen = new SampleFormulaGenerator();		

		String[][] formulas = gen.getFormulaArray(populationSize);
		
		for (int a = 0; a < formulas.length; a++) {
			double redResult, greenResult, blueResult;
			ArithmeticNode redColorNode = null, greenColorNode = null, blueColorNode = null;
			
			String redString = formulas[a][0];
			String greenString = formulas[a][1];
			String blueString = formulas[a][2];
			
			ParserInterface PS = ParserInterface.getInstance();
			PS.setTesting(true);
			
			// The following gets the equation trees for all strings.
			System.out.println("---+++TEST RUN " + (a + 1) + "+++---");
			
			try {
				System.out.println("\nCurrent string for red : " + redString);		
				redColorNode = PS.getArithmetic(redString);
			
				System.out.println("\nCurrent string for green : " + greenString);		
				greenColorNode = PS.getArithmetic(greenString);
			
				System.out.println("\nCurrent string for blue : " + blueString);		
				blueColorNode = PS.getArithmetic(blueString);
			} catch ( InvalidArgumentException | IncorrectVariablesException e){
				e.printStackTrace();
				System.exit(0);
			}
			
			System.out.println("\nTEST POINT 2\n");
			
			// Runs the equations on the supplied color values
			redResult = redColorNode.operation(xRed, yRed);
			greenResult = greenColorNode.operation(xGreen, yGreen);
			blueResult = blueColorNode.operation(xBlue, yBlue);
			
			// Creates a test node so we can run testAsString() and see the final results.
			PixelNode resultTest = new PixelNode(redResult, greenResult, blueResult);
			
			resultTest.testAsString();
			
			PS.setTesting(false);
		}
	}
}
