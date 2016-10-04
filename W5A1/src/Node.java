import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Node {
	private int priority;
	private String name;
	private Node next;

	public Node() {}
	
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
	
	/**
	 * Updated equals() method to follow Java standards
	 */
	public boolean equals(Object o){
		if (o == this) return true;
		if (!(o instanceof Node)) return false;
		
		Node node = (Node) o;
		
		return new EqualsBuilder()
			.append(this.getName(), node.getName())
			.append(this.getPriority(), node.getPriority())
			.isEquals();
	}
	
	/**
	 * Updated hashCode() to follow Java standards
	 */
	public int hashCode(){
		return new HashCodeBuilder(17, 31)
			.append(priority)
			.append(name)
			.toHashCode();
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