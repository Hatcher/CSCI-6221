
public class W5A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue test = new Queue();
		test.enqueue("andy", 1);
		test.enqueue("john", 10);

		
		Queue test2 = new Queue();
		test2.enqueue("andy", 1);
		test2.enqueue("john", 10);

		
		Boolean eq = test.equals(test2);
		System.out.println(eq);
		
		String deq = test.dequeue();
		System.out.println(deq);
		System.out.println("testing");
		
		test.printAll();
		
		
	}

}

/*
equals() Done
clone()
toString()
hashCode() Done
Include a Client class to test the all the methods
*/

