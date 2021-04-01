/*  Name: Naomi Maranga
 *  PennKey: kmaranga
 *  Recitation: 204
 *
 *  Execution: java FileReading filename.txt 
 *
 *  Reads a given text file and prints its contents.
 *
 */

public class FileReading {
    public static void main(String[] args) {
        
        
        String filename = args[0];
        // creates a variable inStream to read  from the file
        In inStream = new In(filename);
        
        //assign numTargets the first value in the file 
        int numTargets       = inStream.readInt();
        double[] targetXs    = new double [numTargets];
        double[] targetYs    = new double [numTargets];
        double[] targetRadii = new double [numTargets];
        
        //create arrays and populate them with target position and radii values
        for (int i = 0; i < 3; i++) {
            targetXs[i]    = inStream.readDouble();
            targetYs[i]    = inStream.readDouble();
            targetRadii[i] = inStream.readDouble();
            System.out.println();
        }
        System.out.printf("%d\n", numTargets);
        for (int i = 0; i < numTargets; i++) {
      System.out.printf("%f %f %f\n", targetXs[i], targetYs[i], targetRadii[i]);
        }
    }
    
}