package Algorithms_week_2.stacks_and_queues;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {
	
	Node first, last = null;
	
	public Iterator<Item> iterator() {
		 
		return new IteratorLinkedQueue();
	}
	
	public class IteratorLinkedQueue implements Iterator<Item>{
		
		Node current = first;

		
		public boolean hasNext() {
			
			return current != null;
		}

		
		public Item next() {
			
			Item item = current.item;
			current = current.next;
			
			return item;
		}
		
	}
	
	public class Node{
		
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		
		return first == null;
	}
	
	public void enqueue(Item item) {
		
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
		}
		else {
		oldLast.next = last;
		}
	}
	
	public Item dequeue() {
		
		Item item = first.item;
		if(isEmpty()) {
			last=null;
		}
		
		first = first.next;
		return item;
	}
	
	public static void main(String[] args) {
		
		LinkedQueue<String> Queue = new LinkedQueue<String>();
		Iterator<String> i = Queue.iterator();
		
		Queue.enqueue("l");
		Queue.enqueue("i");
		Queue.enqueue("s");
		Queue.enqueue("h");
		Queue.enqueue("w");
		Queue.enqueue("a");
		Queue.enqueue("r");
		Queue.enqueue("k");
		
		i = Queue.iterator();
		
		while(i.hasNext()){
			
			String item = i.next();
			System.out.print(item);			
		}
		System.out.println();
		
		System.out.print(Queue.dequeue());
	}


}
