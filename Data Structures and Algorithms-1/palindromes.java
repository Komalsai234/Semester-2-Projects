
class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class palindromes {
	public TreeNode root;
	public palindromes() {
		this.root = null;
	}
	
	// This are check whether given path contains palindrome or not
	public boolean isPalindrom(int[] auxiliary, int length) {
		int a = 0;
		int b = length;
		while (a < b) {
			if (auxiliary[a] != auxiliary[b]) {
				return false;
			}
			a++;
			b--;
		}

		return true;
	}
	
	// This function are printing given path which is contain palindromes
	public void printPath(int[] auxiliary, int size) {
		for (int i = 0; i <= size; ++i) {
			// Display node value
			System.out.print(" " + auxiliary[i]);
		}
		System.out.print("\n");
	}
	
	// Collect all paths from root to leaf nodes
	// And path contains palindrome then this are request to print resultant data
	public void findPath(TreeNode node, int[] auxiliary, int location) {
		if (node != null) {
			auxiliary[location] = node.data;
			if (node.left == null && node.right == null) {
				if (isPalindrom(auxiliary, location)) {
					// When palindrome exist
					printPath(auxiliary, location);
				}
				return;
			}
			// Collecting path through by recursion
			findPath(node.left, auxiliary, location + 1);
			findPath(node.right, auxiliary, location + 1);
		}
	}
	
	//Find height of given binary tree
	public int height(TreeNode root) {
		if (root != null) {
			int a = height(root.left);
			int b = height(root.right);
			//returning a height of largest subtree
			if (a > b) {
				return a + 1;
			}
			else {
				return b + 1;
			}
		}
		return 0;
	}
	
	public void palindromicPath(TreeNode root){
		int size = height(root);
		if (size == 0) {
			return;
		}
		// auxiliary space which is used to collect path
		int[] auxiliary = new int[size];
		findPath(root, auxiliary, 0);
	}
	
	public static void main(String[] args) {
		palindromes tree = new palindromes();

		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(3);
		tree.root.left.right.left = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(5);
		tree.root.left.right.right.left = new TreeNode(5);
		tree.root.left.right.right.right = new TreeNode(4);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.right.right = new TreeNode(4);
		tree.palindromicPath(tree.root);
	}
}
