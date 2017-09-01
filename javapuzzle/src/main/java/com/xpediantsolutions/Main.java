package com.xpediantsolutions;

/**
 * Create a Shape class that draws the following figures to Standard.out when its draw method is invoked.  The
 * vertical bar(|) represents the left margin, or start of the line, neither it or the left to its left should be
 * included in the output.
 *
 * Size 0:|B
 *
 * Size 1:| B
 *        |B B
 *        | B
 *
 * Size 2:|  B
 *        | B B
 *        |B F B
 *        | B B
 *        |  B
 *
 * Size 3:|   B
 *        |  B B
 *        | B F B
 *        |B F F B
 *        | B F B
 *        |  B B
 *        |   B
 *        
 *  Shape should be able to generate the appropriate figure for sizes 4 through N where N is a very large number.
 *
 */
public class Main {
    public static void main(String[] args) {
    	if(args==null||args.length==0){
    		System.out.println("Usage >Main <N>.");
    		System.out.println("Where N is a positive number.");
    	}
        int size = Integer.parseInt(args[0]);
        Shape shape  = new ShapeImpl(size, 'B', 'F');
        shape.draw();
    }
}