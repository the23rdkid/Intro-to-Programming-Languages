public class DoublyLinkedList {
    private class Node() {
  public int value;
  public Node next; 
  public Node prev;
    
  
  public Node (int x) {
  value = x; 
  next = null;
  prev = null; 
  
  }
    }

private Node head, tail; 
private int size; 

public DoublyLinkedList() {
head = null;
tail = null;
size = 0; //no of nodes in linked list

}
public boolean isEmpty() {
return size == 0;

   }
public void enqueue() {
    Node newNode = new Node(x);
    if (isEmpty()) {
        head = newNode;
        tail = newNode;
        size++; 
    } else {
       // newNode = 
    
    }
}
}