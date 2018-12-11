// Java Program illustrating the methods 
// of java.utl.priorityQueue class 
  
// add(), comparator(), conatins(), iterator(), offer() 
// peek(), poll(), toArray(), size(), toArray(t[] g1), 
// remove(), clear() 
  
import java.util.*; 
public class NewClass 
{ 
    public static void main(String[] args) 
    { 
        // Creating a Priority Queue : 
        PriorityQueue <Integer> geek = new PriorityQueue <Integer> (); 
  
        for(int i=2; i<=20; i=i+2) 
        { 
            // Use of add() : 
            geek.add(new Integer (i)); 
        } 
  
        System.out.println("geek PriorityQueue : " + geek); 
  
        // Use of comparator()  
        // No ordering is required here as it is naturally ordered. 
        Comparator geek_comp = geek.comparator(); 
        System.out.println("geek PriorityQueue : " + geek_comp); 
  
        // Use of contains()  
        boolean check = geek.contains(6); 
        System.out.println("Use of contains() : " + check); 
  
        // Use of iterator()  
        Iterator g_iterator = geek.iterator(); 
  
        System.out.print("Iterator values : "); 
        while(g_iterator.hasNext()) 
        { 
            System.out.print(g_iterator.next() + " "); 
        } 
        System.out.println(""); 
  
        // Use of offer()  
        geek.offer(3050); 
        System.out.println("geek PriorityQueue : " + geek); 
  
        // Use of peek()  
        System.out.println("Head of PriorityQueue via peek : " + geek.peek()); 
  
        //Use of poll()  
        int h = geek.poll(); 
        System.out.println("\nHead of PriorityQueue via poll : " + h); 
        System.out.println("geek PriorityQueue bcz of poll() : " + geek); 
  
        // Use of remove() 
        boolean r = geek.remove(8); 
        System.out.println("\nCan remove : " + r); 
        System.out.println("geek PriorityQueue bcz of remove() : " + geek); 
  
        // use of size()  
        System.out.println("\nSize of PriorityQueue : " + geek.size()); 
  
        // Use of toArray()  
        Object[] g = geek.toArray(); 
        System.out.print ( "Array from PriorityQueue : "); 
  
        for ( int i = 0; i<g.length; i++ ) 
        { 
            System.out.print (g[i].toString() + " ") ; 
        } 
  
        System.out.println("\n"); 
  
        // Use of toArray(t[] g1) : 
        Integer[] g2 = new Integer[5]; 
        Integer[] g1 = geek.toArray(g2); 
        System.out.print ( "Array from PriorityQueue of size 5 : "); 
  
        for ( int i = 0; i<g1.length; i++ ) 
        { 
            System.out.print (g1[i].toString() + " ") ; 
        } 
  
        System.out.println("\n"); 
  
        // Use of clear()  
        geek.clear(); 
        System.out.println("PriorityQueue after clear() : " + geek); 
  
    } 
} 
