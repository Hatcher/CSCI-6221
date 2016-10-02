
public class Queue{
	
	private Node root;

	/*
	 * Enqueue
	 * Takes a string and an integer as parameters
	 * Adds a new node to the list of nodes starting at root 
	 */
	void enqueue(String inputName, int inputPriority){
		Node temp = root;
		Node newNode = new Node(inputName, inputPriority);
		if(temp == null){
			root = newNode;
		}else{
			while(temp.hasNext() == true){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}
	
	/*
	 *	Dequeue
	 *	Returns the string from the queue that has the highest priority
	 *	Deletes the node with the highest priority
	 */
	String dequeue(){
		String result;
		if(root == null){
			result = "Empty Queue, nothing to remove";
		}else{
			Node current = root;
			Node temp = root;
			Node nodeBeforeHighestPriority = null;
			int currentPriority = current.getPriority();
			result = current.getName();
			
			while(current.hasNext() == true){
				temp = temp.getNext();
				if(temp.getPriority() < currentPriority){
					nodeBeforeHighestPriority = current;
					currentPriority = temp.getPriority();
					result = temp.getName();
					
				}
				current = temp;
			}
			if(nodeBeforeHighestPriority == null){
				temp = root.getNext();
				root = temp;
			}else {
				Node nodeToBeRemoved = nodeBeforeHighestPriority.getNext();
				nodeBeforeHighestPriority.setNext(nodeToBeRemoved.getNext());
				nodeToBeRemoved.setNext(null);
			}
		}		
		return result;
	}
	
	/*
	 * Java garbage collection takes care of deletion
	 */
	void empty(){
		root = null;	
	}
	
	/*
	 * Test to print out what is in the queue
	 */
	void printAll(){
		Node temp = root;
		if(temp == null){
			System.out.print("There is nothing in this queue");
		}else{
			System.out.println(temp.getName());
			while(temp.hasNext() == true){
				temp = temp.getNext();
				System.out.println(temp.getName());
				
			}
		}
	}
}
