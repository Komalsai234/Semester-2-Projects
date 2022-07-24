	class My_stack {
		char[] arr;
		int topElement;
		int length;
		
		My_stack(int size){
			arr = new char[size];
			length =size;
			topElement = -1;
		}
		
		public void push(char x) {
			if(isFull()) {
				System.out.println("Stack is Full");
				System.exit(1);
			}
			else {
				topElement = topElement+1;
				arr[topElement] = x; 
			}
		}
		
		public char pop() {
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
		
		public char peek() {
			if(isEmpty()) {
				System.exit(-1);
			}
			
			return arr[topElement];
		}
	}

		public class infixtopostfix {
			public int precedence(char text) {
				if (text == '+' || text == '-') {
					return 1;
				}
				else if (text == '*' || text == '/') {
					return 2;
				}
				else if (text == '^') {
					return 3;
				}
				return -1;
			}
			public boolean is_operator(char text){
				if (text == '+' || text == '-' || text == '*' || text == '/' || text == '^')
				{
					return true;
				}
				return false;
			}

			public void infixToPostfix(String infix) {
				String result = "";
				int size = infix.length();
				
				My_stack s = new My_stack(size);
				
				for (int i = 0; i < size; ++i) {
					if ((infix.charAt(i) >= '0' && infix.charAt(i) <= '9') || (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z') || (infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z')) {
						result = result + infix.charAt(i);
					}
					else {
						if (s.isEmpty() || infix.charAt(i) == '(') {
							s.push(infix.charAt(i));
						}
						else if (infix.charAt(i) == ')') {
							while (s.isEmpty() == false && s.peek() != '(') {
								result += s.peek();
								s.pop();
							}
							if (s.peek() == '(') {
								s.pop();
							}
						}
						else {
							while (s.isEmpty() == false && precedence(infix.charAt(i)) <= precedence(s.peek())) {
								result += s.peek();
								s.pop();
							}
							s.push(infix.charAt(i));
						}
					}
				}
				while (s.isEmpty() == false)
				{
					result += s.peek();
					s.pop();
				}
				System.out.println("The given Infix is : " + infix);
				System.out.println("The Postfix is : " + result);
			}
		
		public static void main(String[] args) {
			infixtopostfix task = new infixtopostfix();
			String infix = "((a/b+c))/(e*f)+k";
			task.infixToPostfix(infix);

		}
	  }

