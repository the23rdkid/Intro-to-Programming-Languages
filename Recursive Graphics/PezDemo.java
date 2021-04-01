/**
 * Pez Dispensers - a class - describes behaviour and attributes of a pezdisp
 * a class is a blueprint, any hypothetical pez dispenser
 */
public class PezDemo {
    //these lines describe the qualities of my Pez dispensers.
    public class PezDispenser {
        public String character;
        public String color;
        public int capacity; 
        public int count; //how many pez currently in dispenser
        
        public PezDispenser(String characterName,
                            String sleeveColor,
                            int cap) {
            character = characterName; //(was xter before, became xterName)
              color  = sleeveColor;
                capacity = cap;
                count = 0; //no candies in the beginning
                //count changes to 12 to capacity
                PezDispenser mickey = new PezDispenser ("Mickey", "Red", 12);
                PezDispenser pumpkin = new PezDispenser ("Pumpkin", "Green", 12);
                PezDispenser yoshi = new PezDispenser ("Yoshi", "White", 12);
                //calling one doesnt affect others
                
                System.out.println(yoshi); 
                System.out.println(mickey); 
                
                
              System.out.println("Loading Yoshi");
              yoshi.load(); //behaviour 
              System.out.println(yoshi); 
              System.out.println(mickey);
              System.out.println(pumpkin); 
                
              
              System.out.println("Loading Mickey");
              mickey.load();
              System.out.println(yoshi);
              System.out.println(mickey);
              System.out.println(pumpkin); 
                
        }
        
        //actions described as methods! 
        /**
         * method loads candy into dp
         * 
         */
        public void load() { //no static function. 
            count = capacity;
        }
        /**
         * This one dispenses a candy
         */
        public boolean dispense() {
            if (count > 0) {
            count--; //dispense one candy
            return true;
            } else { 
                return false;
            }
            
            //in java every object you use has to be constructed
            //e.g int[] x = new int[] y
        }
    }
    
    //when making objects? 
    //instances of classes = examples of classes 
    //you can act on them independently (i.e instances)
    public String toString() {
    
    String out = "\tColor: " + color + "\n";
    
    //this function prints whatever 
        return out;
    }
    public static void main (String[] args) {
        System.out.println(yoshi);
    }
}