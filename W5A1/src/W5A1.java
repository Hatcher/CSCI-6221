
public class W5A1 {
	
	public static void main(String[] args) {
//		Queue test = new Queue();
//		test.enqueue("andy", 1);
//		test.enqueue("john", 10);
//		
//		Queue test2 = new Queue();
//		test2.enqueue("andy", 1);
//		test2.enqueue("john", 10);
//		
//		boolean eq = test.equals(test2);
//		System.out.println(eq);
//		
//		String deq = test.dequeue();
//		System.out.println(deq);
//		deq = test.dequeue();
//		System.out.println(deq);
//		
//		test.enqueue("andy", 1);
//		test.enqueue("john", 10);
//		test.printAll();
		
		Queue toTest = new Queue();
		prepareQueue(toTest);
		testQueue(toTest);
	}
	
	private static void prepareQueue(Queue q) {
		q.enqueue("andy", 1);
		q.enqueue("collin", 2);
		q.enqueue("mason", 3);
		q.enqueue("john", 10);
	}
	
	private static void testQueue(Queue q) {
		Queue test = new Queue();
		prepareQueue(test);
		
		System.out.println("Equals:\t\t" + (testQueue_Equals(q, test) ? "PASS" : "FAIL"));
		System.out.println("Clone:\t\t" + (testQueue_Clone(q) ? "PASS" : "FAIL"));
		System.out.println("HashCode:\t" + (testQueue_HashCode(q) ? "PASS" : "FAIL"));
		System.out.println("ToString:\t" + (testQueue_ToString(q) ? "PASS" : "FAIL"));
	}
	
	private static boolean testQueue_Equals(Queue q1, Queue q2) {
		// Should equal
		if (!(q1.equals(q2))) return false;

		Queue t = new Queue();
		//Should not equal
		if (q1.equals(t)) return false;
		
		return true;
	}
	
	private static boolean testQueue_Clone(Queue q1) {
		Queue q2 = new Queue(q1);
		return q1.equals(q2);
	}
	
	private static boolean testQueue_HashCode(Queue q1) {
		Queue q2 = new Queue();
		
		// Should not equal
		if (q1.hashCode() == q2.hashCode()) return false;
		
		q2 = new Queue(q1);
		
		// Should equals
		return (q1.hashCode() == q2.hashCode());
	}
	
	private static boolean testQueue_ToString(Queue q1) {
		Queue q2 = new Queue();
		
		// Should not equal
		if (q1.toString().equals(q2.toString())) return false;
		
		q2 = new Queue(q1);
		
		// Should equal
		return (q1.toString().equals(q2.toString()));
	}
}

/*
equals() Done
clone() Done
toString() Done
hashCode() Done
Include a Client class to test the all the methods
*/

