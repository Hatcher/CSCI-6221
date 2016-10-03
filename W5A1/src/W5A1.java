
public class W5A1 {
	
	public static void main(String[] args) {
		Queue test = new Queue();
		test.enqueue("andy", 1);
		test.enqueue("john", 10);
		
		Queue test2 = new Queue();
		test2.enqueue("andy", 1);
		test2.enqueue("john", 10);
		
		boolean eq = test.equals(test2);
		System.out.println(eq);
		
		String deq = test.dequeue();
		System.out.println(deq);
		deq = test.dequeue();
		System.out.println(deq);
		
		test.enqueue("andy", 1);
		test.enqueue("john", 10);
		test.printAll();
	}
}

/*
equals() Done
clone() Done
toString() Done
hashCode() Done
Include a Client class to test the all the methods
*/

