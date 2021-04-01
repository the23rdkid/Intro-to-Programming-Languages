/**
 * Name: Naomi Maranga
 * Pennkey: kmaranga
 * Recitation: 218
 * Compilation: javac Art
 * Description: Recursively draws T-shaped crystals coming out of a test-tube,
 *              and they are half-sized with each recursive call; ultimately
 *              making a crystal lattice
 */
public class Art1 {
    
    public static void tCrystal(double x, double y, double l) {
        //make pen color green
        PennDraw.setPenColor(255, 105, 180); //hot pink
        //compute the coordinates of the first T-shaped crystal
        
        double y0 = y + l / 2;
        double x0 = x + l / 2;
        double x1 = x - l / 2;
        PennDraw.line(x, y, x, y0);//vertical line
        PennDraw.line(x1, y0, x0, y0);//horizontal line
        
    }
     
    public static void crystal(int n, double x, double y, 
                               double h) {
        PennDraw.enableAnimation(30);
        PennDraw.setPenRadius(0.003);
        //x = 0.64; 
        //y = 0.36; 
        //l = 0.2;
        double half = h / 2;
        
         tCrystal(x, y, h);
         //stop recursion when n = 1/base-case
         if (n == 1) { 
            return;
            }   
         
        //calculate coordinates of quarter-sized T-crystals
        double ay = y;
        double by = y - half;
        double cy = y + half;
        
        double ax = x;
        double bx = x + half;
        double cx = x - half;
        
        crystal(n - 1, cx, cy, h / 2); // left side of T-crystal
        crystal(n - 1, bx, cy, h / 2); // right side of T-crystal
        crystal(n - 1, x, cy, h / 2); // central test - tube
        crystal(n - 1, bx, by, h / 2);
        crystal(n - 1, x, ay, h / 2);
        
        PennDraw.advance();
    }
    
    /**
     * Description: Calls other functions. 
     * Input: an integer n
     * Output: An image where T-crystals grow exponentially 
     * 
     * --later, have the whole scenario replicate itself and become tinier. 
     */
    
    public static void main(String[] args) {
        PennDraw.picture(0.5, 0.5, "teenDexter.jpg");
        int n = Integer.parseInt(args[0]);
        double x = 0.64;
        double y = 0.38;
        double h = 0.2;
        crystal(n, x, y, h);
       
        
    }
}