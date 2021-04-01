
/*Name:    Naomi Maranga
 *Pennkey: kmaranga
 *Recitation: 204
 *Execution: java RetrieveMessage filename seed tapPosition
 *Description: Takes in an image's filename and decodes or decrypts and decodes
 *             a hidden message in the image by calling methods in the Codec
 *             library.
 * 
 */
public class RetrieveMessage {
    public static void main(String[] args) {
        
        String filename = args[0];
        
        //load specified image 
        int[][] retrievedMsg = ImageData.load(filename);
        
        //have an accumulator variable / String to sum all these up 
        int arrSize = retrievedMsg.length * retrievedMsg[0].length;
        int maxSize = arrSize - (arrSize % 7);
        int leastSigBit = 0; //so i can use outside of loop 
        int count = 0; 
        int[] message = new int[maxSize];
        
        //extract embedded cipher 
        for (int i = 0; i < retrievedMsg.length && count < maxSize; i++) {
            for (int j = 0; j < retrievedMsg[i].length && count < maxSize; j++)
            { message[count] = retrievedMsg[i][j] % 2;
                count++;
            }
            
        }
        
        String decodedRetrievedMsg = Codec.decode(message);
        if (args.length == 1) {
            for (int i = 0; i < decodedRetrievedMsg.length(); i++) {
                if (decodedRetrievedMsg.charAt(i) == '\0') {
                    //print out characters in string but only up to and not 
                    //including that character
                    return;  
                } else {
                    System.out.print(decodedRetrievedMsg.charAt(i));
                }
            }
        } 
        
        //added functionality 
        else if (args.length == 3) {
            String seed     = args[1];
            int tapPosition = Integer.parseInt(args[2]);
            // decrypt() changes []message in place
            Codec.decrypt(message, seed, tapPosition); 
            decodedRetrievedMsg = Codec.decode(message);
            for (int i = 0; i < decodedRetrievedMsg.length(); i++) {
                if (decodedRetrievedMsg.charAt(i) == '\0') {
                    //print out characters in string but only up to and not 
                    //including that character
                    return;  
                } else {
                    System.out.print(decodedRetrievedMsg.charAt(i));
                }
            }
        }
        
    }
}