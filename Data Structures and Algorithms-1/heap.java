
class Node  { 
	  public int data;
	  public  Node left, right;

	  public Node(int data) {
	    this.data=data;
	    left=null;
	    right=null;
	  }
	}

	public class heap { 
	  public Node root;
	  public heap() {
	    root=null;
	  }
	  
	  public boolean is_max_heap(Node root) {

	    if(root!=null) {
	      if(root.left!=null && root.left.data > root.data ||root.right!=null && root.right.data > root.data) {
	        return false;
	      }

	      if(is_max_heap(root.left) == true && is_max_heap(root.right) == true) {
	        return true;
	      }

	      return false;
	    }
	    
	    return true;

	  }
	  
	  public boolean is_min_heap(Node root) {

		    if (root != null) {
		      if (root.left != null && root.left.data < root.data ||root.right != null && root.right.data < root.data) {
		        return false;
		      }

		      if (is_min_heap(root.left) == true && is_min_heap(root.right) == true) {
		        return true;
		      }

		      return false;
		    }

		    return true;

		  }

	  public void inorder(Node node){

	    if(node!=null){
	      inorder(node.left);
	      System.out.print("  "+node.data);
	      inorder(node.right);
	    }

	  }

	  public static void main(String[] args) {
	    heap obj = new heap();
	    heap obj1 = new heap();

	    obj.root =new Node(17);
	    obj.root.left =new Node(15);
	    obj.root.right=new Node(16);
	    obj.root.right.right =new Node(10);
	    obj.root.right.left =new Node(8);
	    obj.root.left.left =new Node(9);
	    obj.root.left.left.left  =new Node(6);
	    obj.root.left.right =new Node(7);
	    obj.root.left.right.right =new Node(2);
	    obj.root.left.right.right.left=new Node(1);
	    obj.inorder(obj.root);
	    
	    if(obj.is_max_heap(obj.root)==true) {
	      System.out.print("\n Max Heap Binary Tree \n");
	    }
	    
	    else {
	      System.out.print(" Not a Max Heap Binary Tree \n");
	    }

	    obj.root.right.right.right      =new Node(20);
	    obj.inorder(obj.root);

	    if(obj.is_max_heap(obj.root)==true) {
	      System.out.print("\n Max Heap Binary Tree \n");
	    }
	    
	    else {
	      System.out.print("\n Not a Max Heap Binary Tree \n");
	    }
	    System.out.println();
	    System.out.println();
	    
	    
	    obj1.root = new Node(1);
	    obj1.root.left = new Node(5);
	    obj1.root.right = new Node(6);
	    obj1.root.right.right = new Node(10);
	    obj1.root.right.left = new Node(8);
	    obj1.root.left.left = new Node(9);
	    obj1.root.left.left.left = new Node(13);
	    obj1.root.left.right = new Node(7);
	    obj1.root.left.right.right = new Node(11);
	    obj1.root.left.right.left = new Node(12);
	    
	    obj1.inorder(obj1.root);
	    if (obj1.is_min_heap(obj1.root) == true) {
	      System.out.print("\n Min heap Binary Tree \n");
	    } else {
	      System.out.print("\n Not a Min Heap Binary Tree \n");
	    }
	    
	    obj1.root.right.right.right = new Node(2);
	    obj1.inorder(obj1.root);
	    if (obj1.is_min_heap(obj1.root) == true) {
	      System.out.print("\n Min heap Binary Tree \n");
	    } else {
	      System.out.print("\n Not a Min Heap Binary Tree \n");
	    }

	  }
	}