package Algorithms_week_2.stacks_and_queues;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
		
	Item[] s = (Item[])new Object[1]; 
	int N = 0;
	
	public Iterator<Item> iterator() {
		
		return new iterateArrayStack();
	}
	
	public class iterateArrayStack implements Iterator<Item>{
		
		private int i = N;

		public boolean hasNext() {
			
			return i>0;
		}

		public Item next() {
			
			return s[--i];
		}
		
	}
	
	public void push(Item item) {
		
		if(N == s.length) {
			resize(s.length*2);
		}
		s[N++] = item;
		
	}
	
	public Item pop() {
		
		Item item = s[--N];
		s[N] = null;
		
		if(N>0 && N == s.length/4) {
			resize(s.length/2);
		}
		
		return item;
		
	}
	
	public void resize(int capacity) {
		
		Item[] copy = (Item[])new Object[capacity];
		for(int i=0; i<N; i++) {
			copy[i] = s[i];
		}
		s = copy;
		
	}
	
	public boolean isEmpty() {
		
		return s[0]==null;
	}
	
public static void main(String[] args) {
		
	ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
	
	Iterator<String> i = stack.iterator(); // This prevents us from stack.s[0], hence hides internal implementstion
	
		stack.push("l");
		stack.push("i");
		stack.push("s");
		stack.push("h");
		stack.push("w");
		stack.push("a");
		stack.push("r");
		
	i = stack.iterator();
		
		while(i.hasNext()){
			
			String item = i.next();
			System.out.print(item);			
		}
		System.out.println();
		System.out.print(stack.pop());
		
		
	}

}
