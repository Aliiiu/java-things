public class CountTress {
  class TreeNode{
  	private int data;
  	private TreeNode leftChild;
  	private TreeNode rightChild;
  
  	public TreeNode (int data){
    	this.data = data;
  	}
	}

	public int countNodesWithBothChildren(TreeNode root) {
    	if (root == null) {
        	return 0;
    	}
    	int count = 0;
    	if (root.leftChild != null && root.rightChild != null) {
        	count++;
    	}
    	count += countNodesWithBothChildren(root.leftChild);
    	count += countNodesWithBothChildren(root.rightChild);
    	return count;
	}
}
