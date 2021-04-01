/*  Name: Naomi Maranga
 *  PennKey: kmaranga
 *  Recitation: 204
 *
 *  Execution: java MousePressTesting
 *
 *  Draws a red screen until the user presses a mouse button.
 * Then, it draws a green screen and displays the mouse
 * coordinates above the mouse cursor.
 *
 */


public class MousePressTesting {
 
 public static void main(String[] args) {
 
     PennDraw.enableAnimation(60);
     while (true) {
         
         PennDraw.clear(PennDraw.BOOK_RED);
         if (PennDraw.mousePressed()) {
             PennDraw.clear(PennDraw.GREEN);
             double mouseX = PennDraw.mouseX();
             double mouseY = PennDraw.mouseY();
             PennDraw.text(mouseX, mouseY, mouseX + ", " + mouseY);
         } 
        PennDraw.advance();
     }
     
 }

}
