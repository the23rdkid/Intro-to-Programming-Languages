/**
 * Name: Naomi Maranga
 * Pennkey: kmaranga
 * Recitation: 218
 * Execution: 
 * Description:Simulates a 37-string harp with notes ranging from 110Hz to 880Hz
 **/

public class Harp {
// TODO: WRITE Harp.java BASED ON THIS PROGRAM
    private static double NOTE_MAPPING;
    HarpString[] sound = new HarpString[NOTE_MAPPING.length()];
    private static double FREQUENCY_A = 440.0;
    private static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    //char NOTE_MAPPING[i] = FREQUENCY_A * 2 * Math.pow((i - 24) / 12);
    //for (int i = 0; i < NOTE_MAPPING.length(); i++) {
    = 
    
   // } 
    public static void main(String[] args) {
        // create two harp strings, for concert A and C
       
                 // infinite loop to check if a key is pressed
                 // and play the associated note
                 while (true) {
            // check if the user has typed a key; if so, process it   
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();  // which key was pressed?
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                }
            }
            
            // compute the combined sound of all harp strings
            double sample = stringA.sample() + stringC.sample();
            
            // play the sample on standard audio
            StdAudio.play(sample);
            
            // advance the simulation of each harp string by one step   
            stringA.tic();
            stringC.tic();
        }
             }

}