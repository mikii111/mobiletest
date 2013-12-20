package com.example.länkadlista;

class LinkList{
	private Link first; // ref to first link on list
	private Link last;
	public Link next; // next link in list
	public Link previous; // previous link in list
	public LinkList(){
		first = null; 
		last = null;
	}

	public void insertFirst(int id){
		Link newLink = new Link(id);
		newLink.next = first; // it points to old first link
		first = newLink; // now first points to this
	}
	public void insertLast(int id){
		Link current = first; // start at beginning of list
		while(current != null){
			current = current.next; // move to next link
		}
		Link newLink = new Link(id);
		newLink.next = first;
		first = newLink;
	}

	public Link find(int key){
		Link current = first; // start at ‘first’
		while(current.iData != key){
			if(current.next == null) // if end of list,
				return null; // didn’t find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current; // found it
	}

	public Link delete(int key){
		Link current = first; // search for link
		Link previous = first;
		while(current.iData != key){
			if(current.next == null)
				return null; // didn’t find it
			else{
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if(current == first) // if first link,
			first = first.next; // change first
		else // otherwise,
			previous.next = current.next; // bypass it
		return current;
	}

	public void displayList(){
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
		while(current != null){
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
	
	public void isEmpty(){
		Link current = first;
		if(current==null )
			System.out.println("List is empty");
		else
			System.out.println("List is not empty");
	}
	public void deleteList(){
		
	}

	public void printListRecursive(){
		Link current = first;
		System.out.println("List (Last-->First):");
		recursiveReversePrint(current);
	}
	public void recursiveReversePrint(Link current){  
		if (current != null) {
			recursiveReversePrint( current.next ); 
		    current.displayLink();
		    
		}
	}
	public Link deleteFirst(){
		Link current = first;
		Link newFirst = first;
		if ( current!=null ){
			newFirst=current;
			first = current.next;
	        return newFirst;
		}else
			return null;
	}
	
	public Link deleteLast() {
			Link temp = last;
			Link newFirst = first;
			if(first.next == null) // if only one item
				first = null; // first --> null
			else
				last.previous.next = null; // old previous --> null
			newFirst = last.previous;
			last = last.previous; // old previous <-- last
		return newFirst;
	
	}
}