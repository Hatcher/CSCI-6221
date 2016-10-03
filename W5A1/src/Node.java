
public class Node {
	private int priority;
	private String name;
	private Node next;

	public Node(Node toClone) {
		this(toClone.getName(), toClone.getPriority());
	}
	
	public Node(String inputName, int inputPriority){
		next = null;
		name = inputName;
		priority = inputPriority;
	}
	
	public void setNext(Node inputNode){
		next = inputNode;
	}
	
	public Node getNext(){
		return next;
	}
	
	public boolean hasNext(){
		boolean result = false;
		if(next != null){
			result = true;
		}
		return result;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public boolean equals(Object o){
		if (o == this) return true;
		if (!(o instanceof Node)) return false;
		
		Node inputNode = (Node) o;
		
		boolean truth = false;
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
	
	/**
	 * Overriding toString()
	 */
	public String toString() {
		return getName() + " (" + getPriority() + ")";
	}
	
	/**
	 * Overriding clone()
	 */
	public Object clone() {
		return new Node(this);
	}
}