package Algorithms_week_2.stacks_and_queues;


// It has an issue with down sizing
// https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html // refer this
public class ResizingArrayQueue {
	
	String[] s = new String[1];
	int N = 0;
	int f = 0; // A new variable added, which is not present in S
	
	
	public void enqueue(String item) {
		
		if(N == s.length) {
			resize(s.length*2);
		}
		s[N++] = item;
		
	}
	
	public String dequeue() {
		
		String item = s[f++];
		s[f-1] = null;
		
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
	
	public void calling() {

		System.out.println(s.length);
		System.out.println(f);
		System.out.println(N);

	}
	
public static void main(String[] args) {
		
	ResizingArrayQueue Queue = new ResizingArrayQueue();
		Queue.enqueue("l");
		Queue.enqueue("i");
		Queue.enqueue("s");
		Queue.enqueue("h");
		Queue.enqueue("w");
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		Queue.enqueue("a");
		Queue.enqueue("r");
		Queue.enqueue("k");
		Queue.enqueue("3");
		Queue.enqueue("3");
		Queue.enqueue("3");
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		
		
		Queue.calling();
		
		

		
		
	}

}
