public class Node {
	public double data;
	public Node next;
	
	public Node()
	{	
	}
	
	public Node(double value) {
		data = value;
	}	
	
	public String toString()
	{
		return Double.toString(data);	
	}	
}

