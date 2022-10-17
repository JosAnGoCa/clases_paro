public class BinarySearchTree<T extends Comparable<T>> {
    private class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;
    }

    private Node<T> root;

    public void insert(T valueToInsert) {
        root = insert(valueToInsert, root);
    }

    public Node<T> insert(T valueToInsert, Node<T> curr) {
        if(curr == null) {
            Node<T> newNode = new Node<>();
            newNode.value = valueToInsert;
            return newNode;
        }

        int compare =  valueToInsert.compareTo(curr.value);
        if(compare < 0) {
            curr.left = insert(valueToInsert, curr.left);
        } else if (compare > 0) {
            curr.right = insert(valueToInsert, curr.right);
        }
        return curr;
    }
}
