public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    //reference to the root node
    private Node<T> root;

    @Override
    public void insert(T data) {
        if(root == null){
            //first node or root node
            root = new Node<>(data,null);
        } else {
            //there are already items in the BST
            insert(data,root);
        }
    }

    private void insert(T data,Node<T> node) {
        //If true, then it means the case when data is smaller than the value in the node, so we've to go to
        //left subtree
        if(node.getData().compareTo(data) > 0) {
            if(node.getLeftChild() != null) {
                insert(data,node.getLeftChild());
            } else {
                //means the left child is null, so we've to create a new left child
                node.setLeftChild(new Node<>(data,node));
            }
        } else {
            //This means the data is greater than the value of node, so we've to go to the right sub tree
            if(node.getRightChild() != null) {
                insert(data,node.getRightChild());
            } else {
                //means the right child is null, so we've to create a new left child
                node.setRightChild(new Node<>(data,node));
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal() {
        //in order O(N) linear running time
        if(root == null) return;
        traversal(root);
    }

    private void traversal(Node<T> node) {
        if(node.getLeftChild() != null)
            traversal(node.getLeftChild());
        System.out.println(node.getData() +"-");
        if(node.getRightChild() != null)
            traversal(node.getRightChild());
    }

    @Override
    public T getMax() {
        //right most item in the tree
        if(root == null) {
            return  null;
        } else {
            return getMax(root);
        }
    }

    private T getMax(Node<T> node) {
        if(node.getRightChild() != null) {
            return getMax(node.getRightChild());
        } else {
            return node.getData();
        }
    }

    @Override
    public T getMin() {
        if(root == null) {
            return  null;
        } else {
            return getMin(root);
        }
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        } else {
            return node.getData();
        }
    }
}
