/**
 * Name: Naomi Maranga
 * Pennkey: kmaranga
 * Recitation: 218
 * Execution: java Sierpinski 
 * Description: Recursively draws a Sierpinski triangle by making half-sized 
 *              triangles with each function call. 
 */
public class Sierpinski {
      //plot a triangle with top vertex (x,y) of given sideLength
    
    public static void triangle(double x, double y, double sideLength) {
        //compute the coordinates of the 3 triangle vertices
        double x0 = x - sideLength / 2;
        double x1 = x + sideLength / 2;
        double y0 = y;
        double y1 = y0 - (sideLength / 2 * 1.73205); //tan 60 degrees = 1.73205
        
        PennDraw.filledPolygon(x0, y1, x, y, x1 , y1); 
        
    }
    
    public static void sierpinski(int numLevels, double x, double y, 
                                  double size) {
        PennDraw.enableAnimation(60);
        double h = size / 2 * 1.73205; //tan 60 degrees = 1.73205
        // System.out.println(numLevels  + " " + size); 
        triangle(x, y, size);
        
        //recursion stops when numLevels == 1
        if (numLevels == 1) {
            return;
        }
        
        //calculate coordinates of 3 half-size triangles
        double ay = y;
        double by = y - h;
        double cy = y - h;
        
        double ax = x;
        double bx = x + size / 2;
        double cx = x - size / 2;
        
        //use recursion to draw 3 half-size triangles of order numLevels - 1
        sierpinski(numLevels - 1, bx, ay, size / 2); //top right triangle
        sierpinski(numLevels - 1, cx, ay, size / 2); //top left triangle
        sierpinski(numLevels - 1, x, by, size / 2); //lower triangle
        PennDraw.advance();  
    } 
    
    public static void main(String[] args) {
        int numLevels = Integer.parseInt(args[0]);
        //double size = Double.parseDouble(args[1]);
        double sideLength = 0.50;                                            
        double x = 0.50; //x-coordinate of triangle's top vertex
        double y = 0.87; //y-coordinate of triangle's top vertex 
        
        sierpinski(numLevels, x, y, 0.5);
        // System.out.println(numLevels + " " + 0.5);
        
    }
}
