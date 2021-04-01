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
  double circleRadius = 0.1;
  double circleX = 0;     
  double circleY = 0;   
  boolean winConditionFulfilled = false;
  boolean mouseListeningMode    = true;
  boolean draggingCircle        = false;
  double targetX      = Math.random() * ((0.8 - 0.2) + 0.2);
  double targetY      = Math.random() * ((0.4 - 0.0) + 0.0);
  double targetRadius = Math.random() * ((0.15 - 0.05) + 0.15);
 
  while(!winConditionFulfilled) {
   PennDraw.clear();

   //TODO
   if(mouseListeningMode) {
       //the state in which the game begins
       //wait for the user to press a mouse button
       //and draw a circle at the mouse position when they do
      
       if(!draggingCircle) {
          //check if the user has pressed the mouse yet
           if (PennDraw.mousePressed()) {
           //If so, set draggingCircle to true
           draggingCircle = true;
           }
          
       } 
       else {
           //draw the dragging circle
           //draw circle at the mouse's position
           //mouse isn't being pressed -- STOP DRAGGING CIRCLE AROUND!
           if(PennDraw.mousePressed()) {
          
           circleX      = PennDraw.mouseX();
           circleY      = PennDraw.mouseY();
           PennDraw.circle(circleX, circleY, circleRadius);
           
           } else {
            mouseListeningMode = false;
            //System.out.println("here");
           }
        //draggingCircle  = false;
       }
   }
   else {
       //entered fallingCircle mode and left mouseListeningMode
      
       //draw circle at CURRENT  x and y coordinates
       //THESE WERE COMMENTED OUT EARLIER
        //circleX;
       
     
         //update Y coordinate so it's a little bit farther down
       //update the circle's position every time the while 
       //loop iterates such that the circle falls downward
       //and eventually offscreen
      
        circleY = circleY - 0.02;
         PennDraw.circle(circleX, circleY, circleRadius);
         
         //check if circle is completely offscreen
         //check if the circle is offscreen and then exit loop
                double distance = 0 - circleY;
                //add code after all the if-else statements
                //code that sets winConditionFulfilled to true
                PennDraw.circle(circleX, circleY, circleRadius);
                 //add code after all the if-else statements
                PennDraw.circle(targetX, targetY, targetRadius);
                       //set aside code below for now
               // if(circleY < 0 && distance >= circleRadius) {
               // winConditionFulfilled = true;
               // }
                 double distanceX = circleX - targetX; 
                double distanceY = circleY - targetY;
                double sumRadii = circleRadius + targetRadius;
                if (distanceX <= sumRadii && distanceY <= sumRadii ){
                winConditionFulfilled = true; 
                } 
                 //resetting the game to mouse-listening mode if game lost
                else if(distanceX > sumRadii && distanceY > sumRadii) {
                 winConditionFulfilled = false;
                 mouseListeningMode = true;
                 draggingCircle     = false;
                 }
       
   }   //double circleY1 = circleY - 0.02;
       //PennDraw.circle(circleX, circleY1, circleRadius);

   PennDraw.advance();
  }
    PennDraw.clear();
        
        PennDraw.text(0.5, 0.5, "You win!");
        PennDraw.advance();
 }

}
