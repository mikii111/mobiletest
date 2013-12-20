package com.example.länkadlista;

class LinkList2App
{
public static void main(String[] args){
	LinkList theList = new LinkList(); // skapa en tom lista//done
	
//sätter in på först platsen/done
	
	//sätter in på sista platsen//done
	theList.insertLast(77);
	theList.insertLast(66);
	theList.insertFirst(88);
	theList.insertLast(37);
	theList.insertFirst(74);
	theList.insertLast(99);

	//Skriver ut listan recursive//done
	theList.printListRecursive();
	
	//funkar ta bort från plats 1 och skriva ut värdet
	Link deletedItem = theList.deleteFirst();
	System.out.println("");
	deletedItem.displayLink();
	//funkar ej, ta bort sista noden i listan och skriv ut värdet
    deletedItem = theList.deleteLast();
	System.out.println("");
	deletedItem.displayLink();
	
	
	//funkar ej än men ska ta bort från sista platsen och skriva ut värdet
	//theList.deleteLast();
	
	//kolla om listan är tom//done
	System.out.println("");
	theList.isEmpty();
	
	//kolla om elementet finns,förutsätter att == finns överlagrad för datatypen
	
	
	//ta bort första och sista elementet i listan och därmed tar bort jag bort 
	//theList.deleteList();
	//överlagra = för listan
	
	//gör det möjligt att initiera en lista med en annan lista
	
	
	
	//Hittar ett specifikt värde i listan
	Link f = theList.find(88);
	if( f != null)
		System.out.println("Found link " + f.iData);
	else
		System.out.println("Can’t find link");

	//ta bort ett specifict värde
	Link d = theList.delete(66); // delete item
	if( d != null )
	System.out.println("Deleted link " + d.iData);
	else
		System.out.println("Can’t delete link");
	
	
	
	theList.displayList(); // display list
	} // end main()
}