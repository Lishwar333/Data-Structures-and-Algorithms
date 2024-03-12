package Algorithms_week_2.stacks_and_queues;

import java.util.Iterator;


// https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html // refer this
public class ResizingArrayQueue<Item> implements Iterable<Item> {
	
	Item[] s = (Item[])new Object[1];
    int N = 0;
    int f = 0;
    
public Iterator<Item> iterator() {
		
		return new iterateArrayQueue();
	}
	
	public class iterateArrayQueue implements Iterator<Item>{
		
		private int i = 0;

		public boolean hasNext() {
			
			return i<N;
		}

		public Item next() {
			
			return s[i++];
		}
		
	}

    public void enqueue(Item item) {
        if (N == s.length) {
            resize(s.length * 2);
        }
        s[(f + N) % s.length] = item; // Use (f + N) to calculate the correct index
        N++;
    }

    public Item dequeue() {
        
    	Item item = s[f];
        s[f] = null;
        f = (f + 1) % s.length; // Use (f + 1) to calculate the correct index
        N--; // (f + N) in enqueue will compensate for this

        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    public void resize(int capacity) {
    	Item[] copy = (Item[])new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[(f + i) % s.length];
        }
        s = copy;
        f = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void calling() {
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(s[(f + i) % s.length] + " ");
        }
        System.out.println();
        System.out.println("Front index (f): " + f);
        System.out.println("Number of elements (N): " + N);
    }

	
public static void main(String[] args) {
		
	ResizingArrayQueue<String> Queue = new ResizingArrayQueue<String>();
	Iterator<String> i = Queue.iterator();
	
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
		Queue.enqueue("l");
		Queue.enqueue("i");
		Queue.enqueue("s");
		Queue.enqueue("h");
		Queue.enqueue("w");
		
		System.out.println();
		
		i = Queue.iterator();
		
		while(i.hasNext()){
			
			String item = i.next();
			System.out.print(item);			
		}
		
		System.out.println();
		
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		System.out.print(Queue.dequeue());
		
		
		Queue.calling();
		
		

		
		
	}

}
