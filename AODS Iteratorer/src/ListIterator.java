public class ListIterator
{
	private Node current;
	private Node previous;
	private LinkedList theList;
	
	public ListIterator(LinkedList list)
	{
		theList = list;
		reset();
	}
	
	public void reset()
	{
		current = theList.GetFirst();
		previous = null;
	}
	
	public void NextNode()
	{
		previous = current;
		current = current.next;		
	}
	
	public Node GetCurrent()
	{
		return current;
	}
	
	public boolean AtEnd()
	{ 
	  return (current.next==null); 
	}

	public void InsertAfter(double dd)  // insert after
	{ 
	  Node newNode = new Node(dd);
	  if( theList.IsEmpty() )           // empty list
	  {
	    theList.InsertFirst(newNode);
	    current = newNode;
	  }
	  else                              // not empty
	  {
	    newNode.next = current.next;
	    current.next = newNode;
	    NextNode(); 					// point to new node
	  }
	}	
	
	public void InsertBefore(double dd)   // insert before
	{ 
	  Node newNode = new Node(dd);
	  if(previous == null)                // beginning of list
	  { // (or empty list)
	    newNode.next = theList.GetFirst();
	    theList.InsertFirst(newNode);
	    reset();
	  }
	  else                                // not beginning
	  {
	    newNode.next = previous.next;
	    previous.next = newNode;
	    current = newNode;
	  }
	}	

	public double DeleteCurrent()     // delete item at current
	{
	  double value = current.data;
	  if(previous == null)            // beginning of list
	  {
	    theList.InsertFirst(current.next);
	    reset();
	  }
	  else                            // not beginning
	  {
	    previous.next = current.next;
	    if( AtEnd() )
	    {
	      reset();
	    }
	    else
	    {
	      current = current.next;
	    }
	  }
	  return value;
	}
}
