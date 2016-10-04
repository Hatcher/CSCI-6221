import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Queue {
	
	private Node root;

	public Queue() {
		this.root = null;
	}
	
	public Queue(Node root) {
		this.root = root;
	}
	
	public Queue(Queue toClone) {
		this(toClone.getRoot());
	}
	
	/*
	 * Enqueue
	 * Takes a string and an integer as parameters
	 * Adds a new node to the list of nodes starting at root 
	 */
	void enqueue(String inputName, int inputPriority){
		Node temp = getRoot();
		Node newNode = new Node(inputName, inputPriority);
		
		if (temp == null) {
			root = newNode;
		}
		else {
			while(temp.hasNext()){
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
	public Node dequeue(){
		Node result;
		if(getRoot() == null){
			return null;
		}else{
			Node current = getRoot();
			Node temp = getRoot();
			Node nodeBeforeHighestPriority = null;
			int currentPriority = current.getPriority();
			result = current;
			
			while(temp != null){
				if(temp.getPriority() < currentPriority){
					nodeBeforeHighestPriority = current;
					currentPriority = temp.getPriority();
					result = temp;
					
				}
				current = temp;
				temp = temp.getNext();
			}
			if(nodeBeforeHighestPriority == null){
				temp = getRoot().getNext();
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
		Node temp = getRoot();
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
		Node node = getRoot(), oNode = inputQueue.getRoot();
		while (node != null && oNode != null && node.hasNext() && oNode.hasNext()) {
			node = node.getNext();
			oNode = oNode.getNext();
			eb.append(node, oNode);
		}
		
		if ((node != null && node.hasNext()) || (oNode != null && oNode.hasNext())) return false;
		
		return eb.isEquals();
	}
	
	/**
	 * Overriding hashCode()
	 */
	public int hashCode(){
		HashCodeBuilder hcb = new HashCodeBuilder(17, 31);
		Node node = getRoot();
		while (node != null && node.hasNext()) {
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
		
		Node node = getRoot();
		while (node != null && node.hasNext()) {
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
