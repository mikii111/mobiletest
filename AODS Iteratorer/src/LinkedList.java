public class LinkedList {
	private Node first;
	private Node last;
	private int count;
	
	public LinkedList()
	{
		first = null;
		last = null;
	}
	
	public void InsertFirst(double value)
	{
		InsertFirst(new Node(value));
	}
	
	public void InsertFirst(Node node)
    {
      node.next = first;
      first = node;
      count++;
      if(count == 1)
      {
        last = first;
      }      
    }
	    
    public void InsertLast(double value)
    {
    	InsertLast(new Node(value));
    }

    public void InsertLast(Node node)
    {
      if (count == 0)
      {
          first = node;
      }
      else
      {
          last.next = node;
      }
      last = node;
      count++; 
    }
   
	public Node DeleteFirst()
	{
		Node temp = first;
		first = first.next;
		return temp;		
	}
	
    public Node DeleteLast()
    {
      Node temp = first;
      Node tOut = null;
      if(last != null)
      {
        while(temp.next != last)
        {
          temp = temp.next;
        }
        tOut = temp.next;
        last = temp;
        last.next = null;
                
        count--;
      }                 
      return tOut;
    }	
	    
	public boolean IsEmpty()
	{
		return(first==null);		
	}
	
	public Node GetFirst()
	{
		return first;		
	}
	    
	public void DisplayList()
	{
		PrintNodes(first);
	}
		
	public ListIterator GetIterator()
	{
		return new ListIterator(this);
	}
	
	public void PrintNodes(Node node)
	{
		System.out.println(node);
		if(node.next != null)
		{
			
			PrintNodes(node.next);			
		}
		return;
	}	
}

