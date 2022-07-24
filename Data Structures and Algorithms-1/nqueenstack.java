class Stack {
	int[] arr;
	int topElement;
	int length;
	
	Stack(int size){
		arr = new int[size];
		length =size;
		topElement = -1;
	}
	
	public void push(int x) {
		if(isFull()) {
			System.out.println("Stack is Full");
			System.exit(1);
		}
		else {
			topElement = topElement+1;
			arr[topElement] = x; 
		}
	}
	
	public int pop() {
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
	
	public int peek() {
		if(!isEmpty()) {
			return arr[topElement];
		}
		else {
			System.exit(-1);
		}
		return -1;
	}
	
	public int size() {
		return length;
	}
}

public class nqueenstack {
private static final int NUM_QUEENS = 4;
private static int[] board = new int[NUM_QUEENS];

public static void solve(int n) {
    int current = 0;
    int numSolutions = 0;

    Stack s = new Stack(4);

    while (true) {
        while (current < n) {
            if (isBoardCorrect(s, current)) {
                s.push(current);
                board[s.size() - 1] = current;
                current = 0;
            } else {
                current++;
            }
        }

        if (s.size() == n) {
            printSolution(++numSolutions);
        }

        if (s.isEmpty()) {
            break;
        }

        if (s.peek() == n) {
            s.pop();
        }

        current = s.pop() + 1;
    }
}

private static boolean isBoardCorrect(Stack s, int currentPosition) {
    for (int i = 0; i < s.size(); i++) {
        if (board[i] == currentPosition
                || currentPosition == board[i]
                || Math.abs(currentPosition - board[i]) == s.size() - i) {

            return false;
        }
    }
    return true;
}

private static void printSolution(int num) {
    System.out.print(num + ": ");
    for (int i = 0; i < board.length; i++) {
        System.out.print("(" + i + "," + board[i] + ")");
        if (i < board.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println();
}

public static void main(String[] args) {
    nqueenstack.solve(4);
}

}