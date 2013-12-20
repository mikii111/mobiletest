
public class Program {

	public static void main(String[] args) {
		
		LinkedList myList = new LinkedList();
		ListIterator iterator = myList.GetIterator();
		iterator.InsertAfter(20);
		iterator.InsertAfter(40);
		iterator.InsertAfter(80);
		iterator.InsertBefore(60);
		
		System.out.println("Original list:");
		myList.DisplayList();		
				
		System.out.println("-----------------------------------------");
		System.out.println("Current = " + iterator.GetCurrent().data);
		iterator.reset();
		System.out.println("Current after reset = " + iterator.GetCurrent().data);
				
		iterator.NextNode();
		System.out.println("Current after next = " + iterator.GetCurrent().data);
		
		System.out.println("-----------------------------------------");
		iterator.DeleteCurrent();
		
		System.out.println("Current after delete = " + iterator.GetCurrent().data);
		System.out.println("List after delete:");
		myList.DisplayList();
				
		System.out.println("-----------------------------------------");
	
	}

}
