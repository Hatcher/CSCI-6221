
public class Node {
	private int priority;
	private String name;
	private Node next;
	
	public Node(String inputName, int inputPriority){
		next = null;
		name = inputName;
		priority = inputPriority;
	}
	
	void setNext(Node inputNode){
		next = inputNode;
	}
	
	Node getNext(){
		return next;
	}
	
	Boolean hasNext(){
		Boolean result = false;
		if(next != null){
			result = true;
		}
		return result;
	}
	
	String getName(){
		return name;
	}
	
	int getPriority(){
		return priority;
	}

}
