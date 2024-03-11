package Algorithms_week_2.stacks_and_queues;

public class LinkedQueue {
	
	Node first, last = null;
	
	public class Node{
		
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		
		return first == null;
	}
	
	public void enqueue(String item) {
		
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
	
	public String dequeue() {
		
		String item = first.item;
		if(isEmpty()) {
			last=null;
		}
		
		first = first.next;
		return item;
	}
	
	public static void main(String[] args) {
		
		LinkedQueue Queue = new LinkedQueue();
		Queue.enqueue("l");
		Queue.enqueue("i");
			System.out.print(Queue.dequeue());
	}

}
