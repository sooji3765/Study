# 트리

![default](https://user-images.githubusercontent.com/26784875/44625892-b344b300-a94d-11e8-8b3d-3097110bddb1.png)

    1. Preorder
      결과 : 1 - 2 - 4 - 5 -3

    2. Postorder
      결과 : 4 - 2 - 5 - 1 -3

    3. Inorder
      결과 : 4 - 5 - 2 - 3 -1


~~~java

package sort;

class Node{
	int key;
	Node left,right;

	public Node(int item) {
		key=item;
		left = right =null;
	}
}

public class BinaryTree {

	Node root;

	BinaryTree(){
		root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder tree is");
		tree.printPreorder();

		System.out.println("Inorder tree is");
		tree.printInorder();

		System.out.println("Postorder tree is");
		tree.printPostorder();


	}

	private void printPostorder(Node node) {
		if(node == null) {
			return ;
		}

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + " ");

	}

	private void printInorder(Node node) {
		if(node == null) {
			return ;
		}
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}

	private void printPreorder(Node node) {
		if(node == null) {
			return ;
		}
		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	void printPostorder() {
		printPostorder(root);
	}
	void printInorder() {
		printInorder(root);
	}
	void printPreorder() {
		printPreorder(root);
	}

}

~~~
