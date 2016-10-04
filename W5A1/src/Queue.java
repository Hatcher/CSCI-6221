import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Queue {
	
	private Node root;

	public Queue() {
		this.root = new Node();
	}
	
	public Queue(Node root) {
		this.root = root;
	}
	
	public Queue(Queue toClone) {
		this(toClone.root);
	}
	
	/*
	 * Enqueue
	 * Takes a string and an integer as parameters
	 * Adds a new node to the list of nodes starting at root 
	 */
	void enqueue(String inputName, int inputPriority){
		Node temp = root;
		Node newNode = new Node(inputName, inputPriority);
		
		while(temp.hasNext()){
			temp = temp.getNext();
		}
		temp.setNext(newNode);	
	}
	
	/*
	 *	Dequeue
	 *	Returns the string from the queue that has the highest priority
	 *	Deletes the node with the highest priority
	 */
	public String dequeue(){
		String result;
		if(root == null){
			result = "Empty Queue, nothing to remove";
		}else{
			Node current = root;
			Node temp = root;
			Node nodeBeforeHighestPriority = null;
			int currentPriority = current.getPriority();
			result = current.getName();
			
			while(temp != null){
				if(temp.getPriority() < currentPriority){
					nodeBeforeHighestPriority = current;
					currentPriority = temp.getPriority();
					result = temp.getName();
					
				}
				current = temp;
				temp = temp.getNext();
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
	
	Node getRoot(){
		return root;
	}
	
	/*
	 * Test to print out what is in the queue
	 */
	void printAll(){
		Node temp = root;
		if(temp == null){
			System.out.print("There is nothing in this queue");
		}else{
			while(temp != null){
				System.out.println(temp.getName());
				temp = temp.getNext();
				
			}
		}
	}
	
	/**
	 * Overriding equals
	 */
	public boolean equals(Object o){
		
		if (o == this) return true;
		if (!(o instanceof Queue)) return false;

		Queue inputQueue = (Queue) o;
		
		EqualsBuilder eb = new EqualsBuilder();
		Node node = this.root, oNode = inputQueue.root;
		while (node.hasNext() && oNode.hasNext()) {
			node = node.getNext();
			oNode = oNode.getNext();
			eb.append(node, oNode);
		}
		
		if (node.hasNext() || oNode.hasNext()) return false;
		
		return eb.isEquals();
	}
	
	/**
	 * Overriding hashCode()
	 */
	public int hashCode(){
		HashCodeBuilder hcb = new HashCodeBuilder(17, 31);
		Node node = this.root;
		while (node.hasNext()) {
			node = node.getNext();
			hcb.append(node);
		}
		
		return hcb.toHashCode();
	}

	/**
	 * Overriding toString()
	 */
	public String toString(){
		String result = "";
		
		Node node = root;
		while (node.hasNext()) {
			node = node.getNext();
			result += node.toString() + "\n";
		}
		return result;
	}
	
	/**
	 * Overriding clone()
	 */
	public Object clone() {
		return new Queue(this);
	}
}
