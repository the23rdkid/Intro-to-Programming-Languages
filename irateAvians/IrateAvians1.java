/*  Name: Naomi Maranga
 *  PennKey: kmaranga
 *  Recitation: 204
 *
 *  Execution: java IrateAvians filename.txt 
 *
 *  Read a given text file to populate the game
 * with targets to hit. Then, run a game loop
 * that lets the player click and drag to launch
 * their bird at the loaded targets.
 *
 */

public class IrateAvians1 {
    public static void main(String[] args) {
        // TODO
        PennDraw.setCanvasSize(1000, 500);
        PennDraw.setXscale(0.0, 10.0);
        PennDraw.setYscale(0.0, 5.0);
        PennDraw.enableAnimation(30);
        double birdPosX; // Bird’s position X coordinate
        double birdPosY; // Bird’s position Y coordinate
        double birdVelX; // Bird’s velocityX coordinate
        double birdVelY; // Bird’s velocity Y coordinate
        double targetX;
        double targetY;
        double targetRadius;
        double birdRadius; // Bird’s radius
        double mouseX = PennDraw.mouseX();
        double mouseY = PennDraw.mouseY();
        final double TIME_STEP = 0.2;
        targetX      = Math.random() * ((0.8 - 0.2) + 0.2);
        targetY      = Math.random() * ((0.4 - 0.0) + 0.0);
        targetRadius = Math.random() * ((0.15 - 0.05) + 0.15);
        birdPosX = 1.0; 
        birdPosY = 1.0;
        birdVelX = 0.0;
        birdVelY = 0.0;
        birdRadius = 0.1;
        double birdPosX1 = birdPosX + birdVelX;
        double birdPosY1 = birdPosY + birdVelY;
        String filename = args[0];
        In inStream          = new In(filename);
        int numTargets       = inStream.readInt();
        double[] targetXs    = new double [numTargets];
        double[] targetYs    = new double [numTargets];
        double[] targetRadii = new double [numTargets];
        boolean[] targetsHit = new boolean [3];//stores one boolean per target
        
        //while loop as in game loop skeleton here
        boolean winConditionFulfilled = false;
        boolean mouseListeningMode    = true;
        boolean draggingCircle        = false;
        //In inStream = new In(filename);
        while(!winConditionFulfilled) {
            inStream    = new In(filename);
            numTargets   = inStream.readInt();
            targetXs    = new double [numTargets];
            targetYs    = new double [numTargets];
            targetRadii = new double [numTargets];
            // for (int i = 0; i < 3; i++) {
            
            //System.out.println(inStream);
            // targetXs[i]    = inStream.readDouble();
            // targetYs[i]    = inStream.readDouble();
            // targetRadii[i] = inStream.readDouble();
            //System.out.println("hey");
            // }
            if(mouseListeningMode) { 
                //lets the player click and drag bird to set initial velocity
                //for the bird that begins at a fixed point
                if(!draggingCircle) {
                    //check if the user has pressed the mouse yet
                    if (PennDraw.mousePressed()) {
               //here when I press my mouse, i should set its initial condition
                        
                        
                        //If so, set draggingCircle to true
                        //change  code that handles mouse dragging
                       /* birdVelX = birdPosX - mouseX;//bird's initial X velocity
                        birdVelY = birdPosY - mouseY;//bird's initial Y velocity
                        birdPosX1 = birdPosX + birdVelX;
                        birdPosY1 = birdPosY + birdVelY;
                        //what's the bird's current position? mouse psn? 
                        PennDraw.line(birdPosX, birdPosY, birdPosX1, birdPosY1);
                        */
                        
                         //When the mouse is pressed, set the velocity variables
                        birdVelX = birdPosX - mouseX;//bird's initial X velocity
                        birdVelY = birdPosY - mouseY;//bird's initial Y velocity
                        double birdPosXf = birdPosX + birdVelX;
                       double birdPosYf = birdPosY + birdVelY;
                       PennDraw.line(birdPosXf, birdPosYf,birdPosX, birdPosY);
                        draggingCircle = true;
                        System.out.println("mouse pressed");
                    }
                    
                } 
                else{
                    //draw the dragging circle
                    //mouse isn't being pressed 
                    //update bird's position and velocity
                        birdPosX = birdPosX + birdVelX * TIME_STEP;
                        birdPosY = birdPosY + birdVelY * TIME_STEP;
                        birdVelY = birdVelY - 0.05;
                    if(PennDraw.mousePressed()) {
                 //when I stop pressing mouse, my bird should launch    
                   
            
                        
//PennDraw.circle(birdPosX, birdPosY, birdRadius); BIRD AT INITIAL X,Y POSN
                     
                        
                        /*  //update bird's position and velocity
                        birdPosX = birdPosX + birdVelX * TIME_STEP;
                        birdPosY = birdPosY + birdVelY * TIME_STEP;
                        birdVelY = birdVelY - 0.05;
                        */
                    } else {
                        /* //update bird's position and velocity
                        birdPosX = birdPosX + birdVelX * TIME_STEP;
                        birdPosY = birdPosY + birdVelY * TIME_STEP;
                        birdVelY = birdVelY - 0.05;
                        mouseListeningMode = false;
                        */
                    }
                    //add code to draw bird
                    PennDraw.setPenColor(PennDraw.PINK);
                    double birdPosXf = birdPosX + birdVelX;
                    double birdPosYf = birdPosY + birdVelY;
                    PennDraw.filledCircle(birdPosXf, birdPosYf, birdRadius);
                    
                    //draw targets
                    PennDraw.setPenColor(PennDraw.YELLOW);
                    for (int i = 0; i < 3; i++) {
                        targetXs[i]    = inStream.readDouble();
                        targetYs[i]    = inStream.readDouble();
                        targetRadii[i] = inStream.readDouble();
                        PennDraw.filledCircle(targetXs[i], targetYs[i], targetRadii[i]);
                       
                    }
                    // PennDraw.filledCircle(targetX, targetY, targetRadius);
                    
                    
                    
                }
                PennDraw.advance();
            }
            
            
            // if(computeBallMotion()) {
            
            //}
            
        }
        PennDraw.advance();
        
        
    }
}