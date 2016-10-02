
public class W5A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue test = new Queue();
		test.enqueue("andy", 1);
		test.enqueue("john", 10);
		test.enqueue("michael", 5);
		test.printAll();
		
		String deq = test.dequeue();
		System.out.println(deq);
		System.out.println("testing");
		
		test.printAll();
		
		
	}

}

/*
Write an abstract data type in Java for a queue whose elements 
include both a String and an integer priority. 

This must have the following methods:
enqueue, which takes a string and an integer as parameters; 
dequeue, which returns the string from the queue that has the highest priority;
and empty. ****

The queue is not to be maintained in priority order of its elements,
so the dequeue operation must always search the whole queue.


In addition to those methods, this abstract data type must implement the following methods using Java best practices.


 The method dequeue removes the node that has the highest priority.  
 If the queue is empty, nothing is removed. 
 The method empty removes all nodes from the queue.
 As indicated, the queue is not to be maintained in priority order of its elements, 
 so the dequeue method must always search the whole queue. (see Sebesta's book, page 487, exercise#8)



equals()
clone()
toString()
hashCode()
Include a Client class to test the all the methods
*/

