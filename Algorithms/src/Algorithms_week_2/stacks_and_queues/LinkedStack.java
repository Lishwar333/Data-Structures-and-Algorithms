package Algorithms_week_2.stacks_and_queues;

public class LinkedStack {
	
	Node first = null;
	
	private class Node{
		
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		
		return first == null;
	}
	
	//Using first here similar to last in queue
	public void push(String item) {
		
		Node oldFirst = first;
		first = new Node();
		first.item= item;
		first.next = oldFirst;
	}
	
	public String pop() {
		
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] args) {
		
		LinkedStack stack = new LinkedStack();
		stack.push("l");
		stack.push("i");
		System.out.print(stack.pop());
		
	}

}
