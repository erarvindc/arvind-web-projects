package com.misc;

public class LinkedListTester {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add( new Link("Arvind"));
		list.add( new Link("Benny"));
		list.add( new Link("Chip"));
		list.add( new Link("Dale"));
		list.add( new Link("Eny"));
		list.add( new Link("Feliz"));
	
		list.showList();
		
		System.out.println( list.getLinkAt(4) );
		
		//list.add( 1, new Link("Zoot"));
		
	//	list.showList();
		
		
		/*java.util.LinkedList<Link> linklist = new java.util.LinkedList<>();
		
		linklist.add( new Link("Arvind"));
		linklist.add( new Link("Benny"));
		linklist.add( new Link("Chip"));
	
		
		linklist.add( 1, new Link("zoooooz") );
		
		System.out.println(linklist.toString());*/
	}

}

class LinkedList {
	
	Link head = null;
	int size = 0;
	
	public void add( Link link ) {
		link.next = head;
		head = link;
		link.index = size;
		size++;
	}
	
	public void add( int index, Link link ) {
		
		Link pointer = head;
		//int insertionIndex = size - index;
		int indexCounter = 0;
		while ( pointer.next != null ) {
			if ( indexCounter == index ) {
				Link lnk = getLinkAt( index );
				link.next = lnk.next;
				lnk.next = link;
				size++;
				break;
			}
			pointer = pointer.next;
			indexCounter++;
		} /*else {
			System.out.println( "Reference Link could not be found !" );
		}*/
	}
	
	public Link findLink( Link referenceLink ) {
		
		Link link = head;
		while ( link.name != referenceLink.name ) {
			if ( link.next == null ) {
				return null;
			} else { 
				link = link.next;
			}
		}
		return link;
			
	}
	
	public Link getLinkAt( int index ) {
		
		Link link = head;
		int counter = 0;
		
		while ( counter < size ) {
			if ( counter == index ) {
				break;
			}
			counter++;
			link = link.next;			
		}
		return link;			
	}

	public boolean isEmpty() {
		return ( head == null );
	}
	public void showList() {
		
		Link link = head;

		if ( isEmpty() ) {
			System.out.println("The list is Empty !");
			return;
		}
		while ( link != null ) {
			
			System.out.println(  "'" + link + "'   next link is " + link.next );
			link = link.next;
		}
		System.out.println( "------------ End of List -------------------\n");
	}
	
	
	
}


class Link {

	String name = null;
	int index = 0;
	Link next = null;
	
	public Link ( String name  ) {
		this.name = name;
	}

	@Override
	public String toString() {
		return index + "-" + name;
	}
	
}
