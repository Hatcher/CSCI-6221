
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
			System.out.println(temp.getName());
			while(temp != null){
				System.out.println(temp.getName());
				temp = temp.getNext();
				
			}
		}
	}
	
	public String toString(){
		String result = "Empty queue";
		return result;
	}
	
	public Boolean equals(Queue inputQueue){
		Boolean outerTruth = true;
		Node comparisonNode = root;	
		
		
		while(comparisonNode != null){
			Node inputComparisonNode = inputQueue.getRoot();
			Boolean innerTruth = false;
			if(comparisonNode.equals(inputComparisonNode) == true){
				innerTruth = true;
			}else{
				while(inputComparisonNode != null){
					if(comparisonNode.equals(inputComparisonNode) == true){
						innerTruth = true;
					}
					inputComparisonNode = inputComparisonNode.getNext();
				}
			}
			inputComparisonNode = inputQueue.getRoot();
			if(outerTruth == false || innerTruth == false){
				outerTruth = false;
			}
			comparisonNode = comparisonNode.getNext();
		}
		return outerTruth;
	}
	
	public int hashCode(){
		int result = 0;
		Node temp = root;
		//for each node in queue
		while(temp != null){
			//find hashCode() of node
			int nodeHash = temp.hashCode();
			//add nodeHash to result
			result = result + nodeHash;
			//go to next node
			temp = temp.getNext();
		}
		//return result		
		return result;
	}
}
