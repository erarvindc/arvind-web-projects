package com.misc;

public class LinkedListTester {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.addLink( new Link("Arvind"));
		list.addLink( new Link("Benny"));
		list.addLink( new Link("Chip"));
		
		list.showList();
		

	}

}

class LinkedList {
	
	Link head = null;
	
	public void addLink( Link link ) {
		link.next = head;
		head = link;		
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
			
			System.out.println(  link );
			
			link = link.next;
			
			System.out.println( "The next link is " + link );				
		}
		
	}
	
	
	
}


class Link {

	String name = null;
	
	Link next = null;
	
	public Link ( String name  ) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
