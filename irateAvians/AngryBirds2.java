/*Name: Naomi Maranga 
 *PennKey: kmaranga
 * Recitation: 204
 *Execution: java IrateAvians targetFile1.txt
 *Description:  Read a given text file to populate the game
 * with targets to hit. Then, run a game loop
 * that lets the player click and drag to launch
 * their bird at the loaded targets.
 *
 */
public class IrateAvians{
    public static void main(String[]args) {
        //ALL MY VARIABLES HERE
        boolean winConditionFulfilled = false;
        boolean draggingCircle = false;
        boolean mouseListeningMode = true;
        PennDraw.enableAnimation(30);
        PennDraw.setCanvasSize(1000, 500);
        PennDraw.setXscale(0.0, 10.0);
        PennDraw.setYscale(0.0, 5.0);
        
        double birdPosX = 1.0; // Bird’s position X coordinate
        double birdPosY = 1.0;// Bird’s position Y coordinate
        double birdPosX2; //end points of my initial velocity line
        double birdPosY2;
        double birdVelX = 0.0; // Bird’s velocityX coordinate
        double birdVelY = 0.0; // Bird’s velocity Y coordinate
        double birdRadius = 0.25; // Bird’s radius
        
        //initial mouse position
        double mouseX = PennDraw.mouseX();
        double mouseY = PennDraw.mouseY();
        final double TIME_STEP = 0.2;
        
        //populate arrays with values
        String filename = args[0];
        In inStream          = new In(filename);
        int numTargets       = inStream.readInt();
        double[] targetXs    = new double [numTargets];
        double[] targetYs    = new double [numTargets];
        double[] targetRadii = new double [numTargets];
        boolean[] targetsHit = new boolean[numTargets];
        boolean allTargetsHit = false;
        
        //read in values from file
        for (int i = 0; i < numTargets ; i++) {
            targetXs[i]    = inStream.readDouble();
            targetYs[i]    = inStream.readDouble();
            targetRadii[i] = inStream.readDouble();
        } 
        
        //while loop that runs throughout the game
        while(!winConditionFulfilled) {
            PennDraw.clear();
            if(mouseListeningMode) {
                if(!draggingCircle) {
                    if(PennDraw.mousePressed()) {
                        draggingCircle = true;
                        
                    }
                } 
                
                else { 
                    if(PennDraw.mousePressed()) {
                        mouseX = PennDraw.mouseX();
                        mouseY = PennDraw.mouseY();
                        birdVelX = birdPosX - mouseX;
                        birdVelY = birdPosY - mouseY;
                        
                        birdPosX2 = birdPosX + birdVelX;
                        birdPosY2 = birdPosY + birdVelY;
                        
                        PennDraw.line(birdPosX, birdPosY, birdPosX2, birdPosY2);
                    } else {  
                        mouseListeningMode = false;
                    
                    }
                }
            } 
            
            //BIRD PHYSICS
            else {
                 
                birdPosX = birdPosX + birdVelX  * TIME_STEP;
                birdVelY = birdVelY - 0.05;
                birdPosY = birdPosY + birdVelY  * TIME_STEP;
                
                for (int i = 0; i < numTargets; i++) {
                   //Check if they overlap
                   double birdTargetX = birdPosX - targetXs[i];
                   double birdTargetY = birdPosY - targetYs[i];
                   double birdTargetRad = birdRadius + targetRadii[i];
             if((Math.sqrt(birdTargetX*birdTargetX) + (birdTargetY*birdTargetY)) 
                    <= birdTargetRad)
                      {
                       targetsHit[i] = true; 
                   }
                }
                
                boolean yBirdRad = (0-birdPosY) >= birdRadius;
                boolean xBirdRad = (0-birdPosX) >= birdRadius;
                boolean yScreen = birdPosY < 0 || birdPosY > 5;
                boolean yxScreen = birdPosX < 0 || birdPosY > 10;
                boolean birdYrad = birdPosY - 10 >= birdRadius;
                if((yScreen || yxScreen) && ((yBirdRad || (birdPosY - 5) >= 
                    birdRadius || xBirdRad || birdYrad ))){
                       birdVelX = 0.0;
                       birdPosX = 1.0;
                       birdVelY = 0.0;
                       birdPosY = 1.0;
                       
                       mouseListeningMode = true;
                       draggingCircle = false;
                       }
            }
            for (int i = 0; i < numTargets; i++) {
                if (!targetsHit [i]) {
                PennDraw.setPenColor(PennDraw.RED);
                PennDraw.filledCircle(targetXs[i], targetYs[i], targetRadii[i]);
                }
            }
             boolean winCondition = true;
             
             for (int i = 0; i < numTargets; i++) {
                 winCondition = winCondition && targetsHit[i];
             
             }
             if (winCondition) {
                winConditionFulfilled = true;
             }
          
            
            //ADD CODE TO DRAW MY BIRD AND TARGETS 
           PennDraw.setPenColor(PennDraw.YELLOW);
           PennDraw.filledCircle(birdPosX, birdPosY, birdRadius);
            PennDraw.advance();           
            }
            
    //display text "you win" after all targets are hit     
    PennDraw.clear();
    PennDraw.text(0.5, 0.5, "You win!");
    PennDraw.advance();
    }
    
    
}

    
