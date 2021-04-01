import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List; //interface
import java.util.ListIterator;

public class ListDemo{
    public static void main(String[] args) {
        List<Integer> myList = new LinkedList<Integer>();
        System.out.println("Starting");
        for(int i = 0; i < 100000; i++) {
            myList.add(0, i);
        }
        System.out.println("Ending list add");
        
         System.out.println("Starting list get");
        for(int i = 0; i < 100000; i++) {
            int tempInt = myList.get(i);
        }
         System.out.println("Ending list get");
        
         System.out.println("Starting list iter");
       
       /* ListIterator<Integer> iter = myList.listIterator();
        while(iter.hasNext()) {
            int i = iter.next();
        }
          System.out.println("Ending list iter");
          */
          System.out.println("Starting enhanced for loop list iter");
        for(int i : myList) {
          //  int tempInt = 
        }
    }
}