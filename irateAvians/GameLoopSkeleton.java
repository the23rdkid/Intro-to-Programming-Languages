/*  Name: Naomi Maranga
 *  PennKey: kmaranga
 *  Recitation: 204
 *
 *  Execution: java GameLoopSkeleton
 *
 *  A simple game in which the user wins by
 * dropping a circle onto another circle.
 * Writing this program helps practice writing
 * the code logic to run a game.
 *
 */


public class GameLoopSkeleton {
    
    public static void main(String[] args) {
        PennDraw.enableAnimation(60);
        //declare all my variables here 
        double circleRadius = 0.1;
        double circleX = 0;     
        double circleY = 0;   
        boolean winConditionFulfilled = false;
        boolean mouseListeningMode    = true;
        boolean draggingCircle        = false;
        double targetX      = Math.random() * ((0.8 - 0.2) + 0.2);
        double targetY      = Math.random() * ((0.4 - 0.0) + 0.0);
        double targetRadius = Math.random() * ((0.15 - 0.05) + 0.15);
        
        while (!winConditionFulfilled) {
            PennDraw.clear();
            
            //the state in which the game begins
            if (mouseListeningMode) {
                if (!draggingCircle) {
                    //check if the user has pressed the mouse yet
                    if (PennDraw.mousePressed()) {
                        //If so, set draggingCircle to true
                        draggingCircle = true;
                    } 
                } 
                else {
                    //draw the dragging circle at mouse's position
                    if (PennDraw.mousePressed()) {
                        
                        circleX      = PennDraw.mouseX();
                        circleY      = PennDraw.mouseY();
                        PennDraw.circle(circleX, circleY, circleRadius);
                        
                    } else {
                        mouseListeningMode = false;
                        //System.out.println("am I reachable?");
                    }
                    
                }
            }
            //entered fallingCircle mode and left mouseListeningMode
            else {
                
                //draw circle at CURRENT  x and y coordinates
                //update Y coordinate so that the circle falls and is eventually
                //offscreen
                circleY = circleY - 0.02;
                PennDraw.circle(circleX, circleY, circleRadius);
                
                //check if circle is completely offscreen and then exit loop
                double distance = 0 - circleY;
                
                PennDraw.circle(circleX, circleY, circleRadius);
                PennDraw.circle(targetX, targetY, targetRadius);
                //set aside code below for now
                /* if(circleY < 0 && distance >= circleRadius) {
                 winConditionFulfilled = true;
                 } */
                double distanceX = circleX - targetX; 
                double distanceY = circleY - targetY;
                double sumRadii = circleRadius + targetRadius;
                //code that sets winConditionFulfilled to true
                if (distanceX <= sumRadii && distanceY <= sumRadii) {
                    winConditionFulfilled = true; 
                } 
                //resetting the game to mouse-listening mode if game lost
                else if (distanceX > sumRadii && distanceY > sumRadii) {
                    winConditionFulfilled = false;
                    mouseListeningMode = true;
                    draggingCircle     = false;
                }
                
            } 
            PennDraw.advance();
        }
        PennDraw.clear();
        PennDraw.text(0.5, 0.5, "You win!");
        PennDraw.advance();
    }
    
}
