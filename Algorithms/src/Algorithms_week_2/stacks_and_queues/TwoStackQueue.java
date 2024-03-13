package Algorithms_week_2.stacks_and_queues;


public class TwoStackQueue<Item> {
	
	LinkedStack<Item> input = new LinkedStack<>();
	LinkedStack<Item> output = new LinkedStack<>();
	
	public int size() {
		
		return input.size() + output.size();
	}
	
	public boolean isEmpty() {
		
		return (size() == 0);
	}
	
	public void enqueue(Item item) {
		
		input.push(item);
		
	}
	
	public Item dequeue() {
		
		if(output.isEmpty()) {
			
			while(!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		
		return output.pop();
	}
	
public static void main(String[] args) {
		
	TwoStackQueue<String> Queue = new TwoStackQueue<String>();
				
		Queue.enqueue("l");
		Queue.enqueue("i");
		Queue.enqueue("s");
		Queue.enqueue("h");
		Queue.enqueue("w");
		Queue.enqueue("a");
		Queue.enqueue("r");
		Queue.enqueue("k");
		
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());
		System.out.println(Queue.dequeue());

}
}