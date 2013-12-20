package com.example.l�nkadlista;

class LinkList2App
{
public static void main(String[] args){
	LinkList theList = new LinkList(); // skapa en tom lista//done
	
//s�tter in p� f�rst platsen/done
	
	//s�tter in p� sista platsen//done
	theList.insertLast(77);
	theList.insertLast(66);
	theList.insertFirst(88);
	theList.insertLast(37);
	theList.insertFirst(74);
	theList.insertLast(99);

	//Skriver ut listan recursive//done
	theList.printListRecursive();
	
	//funkar ta bort fr�n plats 1 och skriva ut v�rdet
	Link deletedItem = theList.deleteFirst();
	System.out.println("");
	deletedItem.displayLink();
	//funkar ej, ta bort sista noden i listan och skriv ut v�rdet
    deletedItem = theList.deleteLast();
	System.out.println("");
	deletedItem.displayLink();
	
	
	//funkar ej �n men ska ta bort fr�n sista platsen och skriva ut v�rdet
	//theList.deleteLast();
	
	//kolla om listan �r tom//done
	System.out.println("");
	theList.isEmpty();
	
	//kolla om elementet finns,f�ruts�tter att == finns �verlagrad f�r datatypen
	
	
	//ta bort f�rsta och sista elementet i listan och d�rmed tar bort jag bort 
	//theList.deleteList();
	//�verlagra = f�r listan
	
	//g�r det m�jligt att initiera en lista med en annan lista
	
	
	
	//Hittar ett specifikt v�rde i listan
	Link f = theList.find(88);
	if( f != null)
		System.out.println("Found link " + f.iData);
	else
		System.out.println("Can�t find link");

	//ta bort ett specifict v�rde
	Link d = theList.delete(66); // delete item
	if( d != null )
	System.out.println("Deleted link " + d.iData);
	else
		System.out.println("Can�t delete link");
	
	
	
	theList.displayList(); // display list
	} // end main()
}