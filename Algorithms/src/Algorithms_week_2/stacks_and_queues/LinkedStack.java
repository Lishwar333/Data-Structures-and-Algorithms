package Algorithms_week_2.stacks_and_queues;

import java.util.Iterator;
 
public class LinkedStack<Item> implements Iterable<Item>{
	
	Node first = null;
	
	int sz = 0;
	
	public int size() {
		
		return sz;
	}
	
public Iterator<Item> iterator() {
		
		return new IteratorLinkedStack();
	}
	
	public class IteratorLinkedStack implements Iterator<Item>{
		
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
	
	private class Node{
		
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		
		return first == null;
	}
	
	//Using first here similar to last in queue
	public void push(Item item) {
		
		Node oldFirst = first;
		first = new Node();
		first.item= item;
		first.next = oldFirst;
		sz++;
	}
	
	public Item pop() {
		
		Item item = first.item;
		first = first.next;
		sz--;
		return item;
	}
	
	public static void main(String[] args) {
		
		LinkedStack<String> stack= new LinkedStack<String>();
		Iterator<String> i = stack.iterator();
		
		stack.push("l");
		stack.push("i");
		stack.push("s");
		stack.push("h");
		stack.push("w");
		stack.push("a");
		stack.push("r");
		stack.push("k");
		
		System.out.println(stack.size());
		
		i = stack.iterator();
		
		while(i.hasNext()){
			
			String item = i.next();
			System.out.print(item);	
			
		}
		
		System.out.println();
		System.out.println(stack.pop());
		
		System.out.println(stack.size());
		
	}

}
