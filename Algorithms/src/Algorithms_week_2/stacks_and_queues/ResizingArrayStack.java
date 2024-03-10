package Algorithms_week_2.stacks_and_queues;

public class ResizingArrayStack {
	
	String[] s = new String[1];
	int N = 0;
	
	
	public void push(String item) {
		
		if(N == s.length) {
			resize(s.length*2);
		}
		s[N++] = item;
		
	}
	
	public String pop() {
		
		String item = s[--N];
		s[N] = null;
		
		if(N>0 && N == s.length/4) {
			resize(s.length/2);
		}
		
		return item;
		
	}
	
	public void resize(int capacity) {
		
		String[] copy = new String[capacity];
		for(int i=0; i<N; i++) {
			copy[i] = s[i];
		}
		s = copy;
		
	}
	
	public boolean isEmpty() {
		
		return s[0]==null;
	}
	
public static void main(String[] args) {
		
	ResizingArrayStack stack = new ResizingArrayStack();
		stack.push("l");
		stack.push("i");
		System.out.print(stack.pop());
		
	}

}
