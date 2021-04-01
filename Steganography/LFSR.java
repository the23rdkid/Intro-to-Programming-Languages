,≥/** Name: Naomi Maranga
  * PennKey: kmaranga
  * Recitation: 204
  * Execution: java LFSR
  * Compilation: javac LFSR
  * Desscription: Creates a Linear Feedback Shift Register and populates it with
  *               random bits. It then shifts all the bits in the LFSR to the 
  *               left by one and takes the XOR of the most significant bit and 
  *               the one in the tapPosition and inserts this bit as the least 
  *                significant bit of the LFSR. It can also print out a string 
  *               representation of the bits currently in the LFSR. 
  */
public class LFSR {
    //fields 
    private int[] shiftRegister; //length will be the length of the string
    private int tapPosition; 
    
    /* Input: A String seed and an integer tapPosition
     * Output: integer values 0 or 1. 
     * Description: Constructor that takes in a String seed whose characters are 
     *              a series of 0s and 1s and an integer tapPosition that 
     *              specifies what position in the regiser to use as the tap. 
     *              Throws an exception if seed characters are not 0 or 1 or if 
     *              the referenced index is out of bounds or if the seed is null
     */
    public LFSR(String seed, int tapPosition) {
        //iterate through the string's characters checking if they're 0 or 1
        for (int i = 0; i < seed.length(); i++) {
             
            if (seed == null) {
                throw new RuntimeException("ERROR: Attempting to perform" + 
                                               " operations on a null seed"); 
            }
            if (seed.charAt(i) != '0' && seed.charAt(i) != '1') {
                throw new RuntimeException("ERROR: Attempting to use" +
                                    "non-binary bits/characters in seed");
            }
        }
        shiftRegister = new int [seed.length()]; //create the array
        if (tapPosition < 0 || tapPosition > shiftRegister.length) {
            throw new RuntimeException("ERROR: tapPosition index is out" + 
                                           "of bounds");
        } else {
            //go through string of random bits and map into indices of array 
            for (int i = 0; i < shiftRegister.length; i++) {
                if (seed.charAt(i) == '0') {
                    shiftRegister[i] = 0; 
                } else if (seed.charAt(i) == '1') {
                    shiftRegister[i] = 1;
                }
            }
        }
        
    }
    
    /*Input: an integer seedLength and an integer tapPosition
     *Output: Random integers, 0 or 1. 
     *Description: A constructor which generates a random seed i.e a random 
     *             String of 0s and 1s of length seedLength. Throws runtime 
     *             exceptions if the seedLength is not positive or if the 
     *             tapPosition's index is out of bounds. 
     */
    public LFSR(int seedLength, int tapPosition) {
        //if seedlength is not positive
        if (seedLength < 0) {
            throw new RuntimeException("ERROR: SeedLength can not be" +
                                            " negative");
        }
        if (tapPosition < 0 || tapPosition > shiftRegister.length) {
            throw new RuntimeException("ERROR: tapPosition index is out" +
                                            " of bounds");
        } else {
            //generate a random seed 
            for (int i = 0; i < shiftRegister.length; i++) {
                if (Math.random() < 0.5) {
                    shiftRegister[i] = 0; 
                } else if (Math.random() > 0.5) {
                    shiftRegister[i] = 1; 
                }
            }
        }
    }
    
    /**
     * Input: Takes in an empty string and adds to it the random bits in the 
     *        LFSR
     * Output: A string s that represents the current bits in the LFSR
     * Description: Returns a string representation of the current bit 
     *              sequence of the LFSR - as 0s and 1s. 
     */
    public String toString() {
        String s = ""; //empty string 
        for (int i = 0; i < shiftRegister.length; i++) {
            s += shiftRegister[i]; //do I NEED TO MAKE MY SEED STRING 
        }
        return s; //dummy return
    }
    
    /* Input: takes in the field variable tapPosition and maps it to local 
     *        variable 
     * Output: An integer representation of the index the tap is at in the LFSR
     * Description: Returns an integer that connotes the tap Position.
     */
    public int getTapPosition() {
        this.tapPosition = tapPosition; 
        return tapPosition; 
    }
    
    /*Input: the leftmost bit and the bit at the tap position
     *Output: the XOR of the two bits found above
     *Description: Returns a random bit(the least significant bit) and updates 
     *             the LFSR. Gets the tap position and does the XOR of the left
     *             most bit and the one at the tapPosition and adds this to the
     *             rightmost end of the array, then shifts all the indices to 
     *             the left by one. (updates after one step)
     */
    public int nextBit() {
        int leastSigBit = shiftRegister[shiftRegister.length - 1]; 
        int mostSigBit  = shiftRegister[0]; 
        
        for (int i = 0; i < shiftRegister.length - 1; i++) {
            shiftRegister[i] = shiftRegister[i + 1]; //shift left 
        }
        int tapPsnBit  = shiftRegister[ getTapPosition() + 1]; 
        leastSigBit    = mostSigBit ^ tapPsnBit; 
        //replace righmost Bit with XOR 
        shiftRegister[shiftRegister.length - 1] = leastSigBit; 
        return leastSigBit; 
    }
    
    //my main function for testing 
    public static void main(String[] args) {
        // LFSR lfsr = new LFSR("101011", 3);
        //System.out.println(lfsr.toString());
        
//        LFSR lfsr = new LFSR("01101000010", 8);
//        for (int i = 0; i < 10; i++) {
//            int bit = lfsr.nextBit();
//            System.out.println(lfsr.toString() + " " + bit);
//        }
    }
}