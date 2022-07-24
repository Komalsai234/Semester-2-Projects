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
public class eulertour{
 	public TreeNode root;
	public eulertour() {
		this.root = null;
	}
	public void eulerPath(TreeNode node, TreeNode parent) {
		if (node == null) {

			return;
		}

		System.out.print("  " + node.data);

		eulerPath(node.left, node);
		eulerPath(node.right, node);
		if (parent != null) {
			System.out.print("   " + parent.data);
		}
	}
	public static void main(String[] args){
		eulertour tree = new eulertour();
		
		tree.root = new TreeNode(9);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.left.left = new TreeNode(10);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(8);
		tree.root.left.right.right.left = new TreeNode(2);
		tree.root.left.right.right.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(11);
		tree.root.right.right.right = new TreeNode(20);
		tree.eulerPath(tree.root, null);
	}
}
