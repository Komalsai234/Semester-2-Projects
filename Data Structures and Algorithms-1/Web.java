import java.util.Scanner;

class My_stack {
	String[] arr;
	int topElement;
	int length;
	
	My_stack(int size){
		arr = new String[size];
		length =size;
		topElement = -1;
	}
	
	public void push(String x) {
		if(isFull()) {
			System.out.println("Stack is Full");
			System.exit(1);
		}
		else {
			topElement = topElement+1;
			arr[topElement] = x; 
		}
	}
	
	public String pop() {
		if(isEmpty()) {
			System.out.println("The Stack is Empty");
			System.exit(1);
		}
		return arr[topElement--];
	}
	
	public boolean isFull() {
		return topElement == length-1;
	}
	
	public boolean isEmpty() {
		return topElement == -1;
	}
	
	public void DisplayStack() {
		for(int i=0;i<topElement;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public String peek() {
		if(isEmpty()) {
			System.exit(-1);
		}
		
		return arr[topElement];
	}
}


public class Web {
	
	static String current_url = "";

	static My_stack f_stack = new My_stack(15);

	static My_stack b_stack = new My_stack(15);

	static void visit_new_url(String url) {
		if (current_url != "") {
			b_stack.push(current_url);
		}

		current_url = url;
	}

	static void forward() {
	if (f_stack.isEmpty() || current_url == f_stack.peek()) {
		System.out.print("Not Available\n");
		return;
	}

	else {
		b_stack.push(current_url);

		current_url = f_stack.peek();

		f_stack.pop();
	}
	}

	static void backward() {
	if (b_stack.isEmpty() || current_url == b_stack.peek()) {
		System.out.print("Not Available\n");
		return;
	}

	else {

		f_stack.push(current_url);

		current_url = b_stack.peek();

		b_stack.pop();
	}
	}
	
	static void exit() {
		System.exit(-1);
	}


	public static void main(String[] args) {
		boolean browse = true;
		System.out.println("Welcome to Chrome Browser");
		System.out.println("\nBrowser ready");
		
		while(browse) {
			System.out.println("(Commands: visit *web url*; back; quit; forward ;)");
			
			Scanner sc= new Scanner(System.in); 
			String str= sc.nextLine();  
			
			if(str.equals("visit")) {
				String url = sc.nextLine();  
				System.out.println("Now going to visit "+url);
				visit_new_url(url);
				 System.out.print("Web Visit: " + current_url +" \n");
			}
			
			if(str.equals("forward")) {
				System.out.print("Going forward...");
				forward();
				System.out.print("Web Visit: " + current_url +" \n");
			}
			
			if(str.equals("back")) {
				System.out.println("Going back...");
				backward();
				System.out.print("Web Visit"  +current_url + " \n");	
		}
			
			if(str.equals("quit")) {
				System.out.println("Quitting...");
				browse = false;	
		}
			
			if(!(str.equals("visit") || str.equals("forward") || str.equals("back") || str.equals("quit"))) {
				System.out.println("Invalid Command");
			}
	}
			
  }
}
