
	class StackNode {
		public int element;
		public StackNode next;
		public StackNode(int element, StackNode next){
			this.element = element;
			this.next = next;
		}
	}

	class MyStack {
		public StackNode top;
		public int size;
		public MyStack() {

			this.top = null;
			this.size = 0;
		}

		public void push(int element) {
			this.top = new StackNode(element, this.top);
			this.size++;
		}
		public Boolean isEmpty() {
			if (this.size > 0 && this.top != null) {
				return false;
			}
			else {
				return true;
			}
		}

		public void pop() {
			if (this.size > 0 && this.top != null) {
				StackNode temp = this.top;
				this.top = temp.next;
				temp = null;
				this.size--;
			}
		}
		
		public int peek() {
			return this.top.element;
		}
	}
	
	public class sortstackLLrecur {
		public MyStack stack;
		public sortstackLLrecur() {
			this.stack = new MyStack();
		}
		public void printData() {
			StackNode temp = this.stack.top;
			while (temp != null) {
				System.out.print("   " + temp.element);
				temp = temp.next;
			}
			System.out.print("\n");
		}

		public void sortedAdd(int element) {
			if (this.stack.isEmpty() == true || this.stack.peek() > element) {
				this.stack.push(element);
			}
			else {
				int data = this.stack.peek();
				this.stack.pop();
				this.sortedAdd(element);
				this.stack.push(data);
			}
		}
		
		public void sortStack() {
			if (this.stack.isEmpty() == false) {
				int element = this.stack.peek();
				this.stack.pop();
				this.sortStack();
				this.sortedAdd(element);
			}
		}

		public static void main(String[] args) {
			sortstackLLrecur task = new sortstackLLrecur();

			task.stack.push(4);
			task.stack.push(7);
			task.stack.push(9);
			task.stack.push(2);
			task.stack.push(3);
			task.stack.push(8);
			task.stack.push(5);
			task.stack.push(6);

			System.out.print("\n Original Stack \n");
			task.printData();

			task.sortStack();

			System.out.print("\n Stack after sorting \n");
			task.printData();
		}
	}
