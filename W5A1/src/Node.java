
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
	
	public Boolean equals(Node inputNode){
		Boolean truth = false;
		String inputName = inputNode.getName();
		int inputPriority = inputNode.getPriority();
		if(inputName.equals(name) == true && inputPriority == priority){
			truth = true;
		}
		return truth;
	}
	
	public int hashCode(){
		int result = 0;
		//Calc value for priority
		int priorityHash = priority;
		//calc value for string
		int nameHash = name.length();
		//combine values
		result = priorityHash + nameHash;
		//return value
		return result;
	}

}
