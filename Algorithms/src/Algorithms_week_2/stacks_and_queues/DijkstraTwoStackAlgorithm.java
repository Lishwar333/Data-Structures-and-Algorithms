package Algorithms_week_2.stacks_and_queues;

import java.util.Scanner;

public class DijkstraTwoStackAlgorithm {
	
	public static void main(String agrs[]) {
		
		LinkedStack<String> ops = new LinkedStack<String>();
		LinkedStack<Double> val = new LinkedStack<Double>();
		
		// Scanner scanner = new Scanner(System.in); //(1+2+(2*5)*(4+6))
		// scanner.useDelimiter("\\s+|(?=[()\\/*+-])|(?<=[()\\/*+-])");
		
		String s = "(1+((2+3)*(4*5)))"; // may be put the scanner here and then close scanner
		//(1+2+(2*5)*(4+6)) fails for this input because of format, grp the middles using extra paranthesis
		int i=0;
		
		while(i<s.length()){
			
			String token =""+ s.charAt(i);
			//System.out.println("Token: " + token);
			
			if(token.equals("(")) {}
			else if(token.equals("+")) { ops.push(token); }
			else if(token.equals("*")) { ops.push(token); }
			else if(token.equals(")")) {
			    String op = ops.pop();
			    if(op.equals("+")) {
			        val.push(val.pop() + val.pop());
			       
			    } else if(op.equals("*")) {
			        val.push(val.pop() * val.pop());
			    }
			}else {
				val.push(Double.parseDouble(token));
			}
			
			i++;
			
		}
		
		System.out.println("Result: " + val.pop());
		
		
		}
	
}
