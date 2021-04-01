/**
 * Name: Naomi Maranga
 * PennKey: kmaranga
 * Recitation: 218 
 * Execution: java HarpString
 * Description: 
 */

public class HarpString {
public static final int SAMPLING_RATE = 44100;
    private RingBuffer buffer; // ring buffer
    
    // TODO: YOUR OTHER INSTANCE VARIABLES HERE (IF ANY)
public static double DECAY_FACTOR = -0.997;
private int count = 0;
private int numSamples;


    // create a harp string of the given frequency(Constructor)
    public HarpString(double frequency) {
        // TODO: YOUR CODE HERE
      
       double rate = SAMPLING_RATE / frequency;
       double numSamples = Math.ceil(rate);
       buffer = new RingBuffer((int)numSamples);
       for (int i = 0; i < numSamples; i++) {
           buffer.enqueue(0.0);
       
       }
        
    }

    // pluck the harp string by replacing the buffer with white noise
    /**
     * Description: Replaces all numSamples items in the ring buffer with 
     * numSamples random values between -0.5  and 0.5
     */
    public void pluck() {
      //changed double x to double z but nothing different happens either
      
        for (int i = 0; i < numSamples; i++) {
          double z = Math.random() - 0.5;
       //previously dequeue came first but the shift doesn't seem to affect 
            //time() or sample().....................
            buffer.dequeue();
            buffer.enqueue(z);
        
        }
    }

    // advance the simulation one time step
    public void tic() {
        // TODO: YOUR CODE HERE
        
        double average = (buffer.dequeue() + buffer.peek()) * 0.5 
                         * DECAY_FACTOR;

        buffer.enqueue(average);// add the new sample (average) to the end
        count++;  
        
    }

    /**
     * Description: Returns the value of the item at the front of the ring 
     *              buffer(i.e current sample)
     */
    public double sample() {
        
        return buffer.peek(); // return value of item at front of ring buffer
         
    }
  
    /** 
      * Description: Returns total number of times tic() was called
      */
    public int time() {
       
       return count; 
       // returns number of times tic() was called
    }

    // TODO: ADD MORE THOROUGH TESTING
    
    public static void main(String[] args) {
        // how many samples should we "play"
        int numSamplesToPlay = Integer.parseInt(args[0]);

        // a starting set of samples; it's pretty easy to calculate
        // the new samples that will get generated with a calculator
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        
        // create a harp string to test with exactly samples.length,
        // this looks a little funny because the HarpString constructor
        // expects a frequency, not a number of elements
        HarpString testString = new HarpString(44100.0 / samples.length);

        // at this point the RingBuffer underlying testString should have
        // a capacity of samples.length and should be full
        System.out.println("testString.buffer.isEmpty(): " + 
                            testString.buffer.isEmpty());
        System.out.println("testString.buffer.isFull():  " + 
                            testString.buffer.isFull());

        // replace all the zeroes with the starting samples
        for (int i = 0; i < samples.length; i++) {
            testString.buffer.dequeue();
            testString.buffer.enqueue(samples[i]);
        }

        // "play" for numSamples samples; printing each one for inspection
        for (int i = 0; i < numSamplesToPlay; i++) {
            int t = testString.time();
            double sample = testString.sample();

            // this statement prints the time t, padded to 6 digits wide
            // and the value of sample padded to a total of 8 characters
            // including the decimal point and any - sign, and rounded
            // to four decimal places
            System.out.printf("%6d %8.4f\n", t, sample);
          
            testString.tic(); // advance to next sample
        }
    }
}