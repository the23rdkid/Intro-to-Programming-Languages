/**Name: Naomi Maranga
  * Pennkey: kmaranga
  * Recitation: 204
  * Execution: java HideMessage filename textFile seed tapPosition
  * Description: Takes in a message of Type string and either encodes it or 
  *              encrypts it(by calling methods in the Codec library) depending 
  *              on the number of command line arguments given
  */
public class HideMessage {
    public static void main(String[] args) {
        String filename = args[0];
        String textFile = args[1];
        
        //load specified image 
        int[][] image = ImageData.load(filename);
        
        //encrypt message
        In inStream   = new In(textFile);
        String msg    = inStream.readAll() + "\0";
        //encode message
        int[] encodedText = Codec.encode(textFile);
       
        
        //if message is too long for image, throw exception 
        if (encodedText.length > image.length * image[0].length) {
            throw new RuntimeException("ERROR: Attempting to use a message" +
                                            " longer than the image");
        }
        
        
        //if only two cmdlets, simply embed message without encrypting
        if (args.length == 2) {
            int count = 0; //keeps track of values to be embedded
            
            // put the message in the LSBs of the image 
          for (int i = 0; i < image.length && count < encodedText.length; i++) {
              for (int j = 0; j < image[i].length && count < encodedText.length;
                    j++) {
                        //if pixel's even and eText[count] is even too, do 
                        //nothing
                        if (image[i][j] % 2 == 0 &&
                             encodedText[count] % 2 == 0) {
                            image[i][j] = image[i][j]; //don't change anything
                            count++;
                            //if pixel's odd, its LeastSigBit is 1, 
                            //subtract 1 from pixel's LeastSigBIt & update count
                        } else if (image[i][j] % 2 == 1 && 
                                   encodedText[count] % 2 == 0) {
                            image[i][j] -= 1;
                            count++;
                        }
                         //if pixel's even and eText[count] is odd, add 1 to the 
                        //pixel's LeastSigBit
                        else if (image[i][j] % 2 == 0 && 
                                 encodedText[count] % 2 == 1) {
                            image[i][j] += 1; 
                            count++;
                        }
                        //if pixel's odd and message[count] is odd, do nothing
                        else if (image[i][j] % 2 == 1 && 
                                 encodedText[count] % 2 == 1) {
                            image[i][j] = image[i][j];
                            count++;
                        }
                    }
            }
            ImageData.show(image); //display image result 
            ImageData.save(image, textFile); //save the image
        }
        //embed encrypted cipher into image - set LSB to be bit being encoded
        //(CALL YOUR ENCODE FUNCTION INSTEAD???)
        
        //If given 4 cmdlets; encrypt message before embedding in image 
        if (args.length == 4) {
            String seed     = args[2];
            int tapPosition = Integer.parseInt(args[3]);
            
            Codec.encrypt(encodedText, seed, tapPosition);
            
            int count = 0; //keeps track of values to be embedded in image
            
          for (int i = 0; i < image.length && count < encodedText.length; i++) {
              for (int j = 0; j < image[i].length && count < encodedText.length;
                    j++) {
                        //if pixel's even and eText[count] is even too, do 
                        //nothing
                      if (image[i][j] % 2 == 0 && 
                          encodedText[count] % 2 == 0) {
                           image[i][j] = image[i][j];
                            count++;
                            //if pixel's odd, its LeastSigBit is 1, 
                            //subtract 1 from pixel's LeastSigBIt & update count
                        } else if (image[i][j] % 2 == 1 && 
                                   encodedText[count] % 2 == 0) {
                            image[i][j] -= 1;
                            count++;
                        }
                         //if pixel's even and eText[count] is odd, add 1 to the 
                        //pixel's LeastSigBit
                        else if (image[i][j] % 2 == 0 && 
                                 encodedText[count] % 2 == 1) {
                            image[i][j] += 1; 
                            count++;
                        }
                        //if pixel's odd and message[count] is odd, do nothing
                        
                        else if (image[i][j] % 2 == 1 && 
                                 encodedText[count] % 2 == 1) {
                            image[i][j] = image[i][j];
                            count++;
                        }
                        
                    }
                    
            }
            
            ImageData.show(image); //display image result 
            ImageData.save(image, textFile); //save the image
            
            //retrieve message by calling RetrieveMessage.java
        }
    }
}
