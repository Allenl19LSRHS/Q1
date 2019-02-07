import java.util.Scanner;
import ls.java.menu.*;
import ls.RPN.RPNStack;
import ls.RPN.RPNStackItem;


public class Q1Main {

	public static void main(String[] args) {
		//System.out.println("Hello, World!");
		
		//Q1Op1 op1 = new Q1Op1();
		//Q1OpParent op1 = new Q1Op1();
		//Q1OpParent op1 = new Q1Op2();
		
		Scanner scan = new Scanner(System.in);
		//String input;
		Q1OpParent op1 = null;
		
		/*
		do {
			System.out.println("Do you want the Parent, the first operator, or the second (1, 2, or 3))?");
			input = scan.nextLine();
			if (input.equals("1")) {
				op1 = new Q1OpParent();
			} else if (input.equals("2")) {
				op1 = new Q1Op1();
			} else if (input.equals("3")) {
				op1 = new Q1Op2();
			} else {
				System.out.println("Sorry, that's not a valid answer");
			}
		} while (op1 == null);
		*/
		
		//System.out.println(op1.op(3, 4, 5));
		//System.out.println(op1.op(2, 7, 13));
		//System.out.println(op1.op(53, 2, 10));
		//System.out.println(op1.op(1, 1, 1));
		
		LSLetterMenu menuPicker = new LSLetterMenu("Pick an operator");
		menuPicker.addItem("parent");
		menuPicker.addItem("first operator");
		menuPicker.addItem("second operator");
		int choice = menuPicker.displayAndChoose();
		
		if (choice == 1) {
			op1 = new Q1OpParent();
		} else if (choice == 2) {
			op1 = new Q1Op1();
		} else if (choice == 3) {
			op1 = new Q1Op2();
		}
		
		RPNStack stack = new RPNStack();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(op1.op(i, 3, 4));
			stack.push(new RPNStackItem(op1.op(i, 3, 4)));
		}
		stack.printStack();
		System.out.println("");
		
		// If it's not the first operator (which would divide by 0) basically sums up the contents of the stack
		if (op1 instanceof Q1Op2) {
			for (int i = 0; i <= stack.stack.size() + 1; i++) {
				// Stack was already converted to work with Floats, so Math.round outputs Int
				int a = Math.round(stack.pop().toFloat());
				int b = Math.round(stack.pop().toFloat());
				int c = Math.round(stack.pop().toFloat());
				int d = op1.op(a, b, c);
				System.out.println(d);
				stack.push(new RPNStackItem(d));
			}
			stack.printStack();
		}
		
		scan.close();
	}
}
