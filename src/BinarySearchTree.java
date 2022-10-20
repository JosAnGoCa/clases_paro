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

    private Node<T> insert(T valueToInsert, Node<T> curr) {
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

    public boolean empty() {
        return root == null;
    }

    public void inOrder() {
        inOrder(root);
        System.out.print("\n");
    }

    private void inOrder(Node<T> curr) {
        if(curr == null) {
            return;
        }
        // L
        inOrder(curr.left);
        // D
        System.out.print(curr.value + " ");
        // R
        inOrder(curr.right);
    }

    public void preOrder() {
        preOrder(root);
        System.out.print("\n");
    }

    private void preOrder(Node<T> curr) {
        if(curr == null) {
            return;
        }
        // D
        System.out.print(curr.value + " ");
        // L
        preOrder(curr.left);
        // R
        preOrder(curr.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.print("\n");
    }

    private void postOrder(Node<T> curr) {
        if(curr == null) {
            return;
        }
        // L
        postOrder(curr.left);
        // R
        postOrder(curr.right);
        // D
        System.out.print(curr.value + " ");
    }

    public void levelOrderTraversal() {
        QueueList<Node<T>> list = new QueueList<>();

        if (!this.empty()) {
            list.enqueue(root);
        }
        while (!list.empty()) {
            Node<T> curr = list.dequeue();
            if (curr.left != null) list.enqueue(curr.left);
            if (curr.right != null) list.enqueue(curr.right);
            System.out.print(curr.value + " ");
        }
        System.out.print("\n");
    }

    public T findMinTreeBucle() {
        return findMinBucle(root).value;
    }

    public T findMaxTreeBucle() {
        return findMaxBucle(root).value;
    }

    private Node<T> findMinBucle(Node<T> root) {
        Node<T> aux = root;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux;
    }

    private Node<T> findMaxBucle(Node<T> root) {
        Node<T> aux = root;
        while (aux.right != null) {
            aux = aux.right;
        }
        return aux;
    }

    public T findMinTreeRecursive() {
        return findMinRecursive(root).value;
    }

    public T findMaxTreeRecursive() {
        return findMaxRecursive(root).value;
    }

    private Node<T> findMinRecursive(Node<T> curr) {
        if(curr == null) {
            return null;
        } else if (curr.left == null) {
            return curr;
        }
        return findMinRecursive(curr.left);
    }

    private Node<T> findMaxRecursive(Node<T> curr) {
        if(curr == null) {
            return null;
        } else if (curr.right == null) {
            return curr;
        }
        return findMaxRecursive(curr.right);
    }

    public boolean findBucle(T valueToSearch) {
        Node<T> curr = root;
        while (curr != null) {
            int comparable = valueToSearch.compareTo(curr.value);
            if ( comparable == 0 )  return true;
            else if ( comparable < 0 ) curr = curr.left;
            else if ( comparable > 0 ) curr = curr.right;
        }
        return false;
    }

    public boolean findRecursive(T valueToSearch) {
        return findRecursive(valueToSearch, root);
    }

    private boolean findRecursive(T valueToSearch, Node<T> curr) {
        if ( curr == null ) return false;

        int comparable = valueToSearch.compareTo(curr.value);
        if( comparable == 0 ) return true;
        else if ( comparable < 0 ) return findRecursive(valueToSearch, curr.left);
        else if ( comparable > 0 ) return findRecursive(valueToSearch, curr.right);
        return false;
    }

    public void deleteNode(T valueToDelete) {
        root = deleteNode(root, valueToDelete);
    }

    public Node<T> deleteNode(Node<T> curr, T valueToDelete) {
        if ( curr == null ) return curr;

        int comparable = valueToDelete.compareTo(curr.value);
        if ( comparable < 0 ) curr.left = deleteNode(curr.left, valueToDelete);
        else if ( comparable > 0 ) curr.right = deleteNode(curr.right, valueToDelete);
        else if ( comparable == 0 ) {
            // 0 hijos
            if(curr.right == null && curr.left == null) {
                curr = null;
            }
            // 1 hijo
            // el hijo esta a la izquierda
            else if (curr.right == null && curr.left != null) {
                curr = curr.left;
            }
            // el hijo esta a la derecha
            else if (curr.right != null && curr.left == null) {
                curr = curr.right;
            }
            // 2 hijos
            else {
                Node<T> aux = findMaxBucle(curr.left);
                curr.value = aux.value;
                curr.right = deleteNode(curr.right, aux.value);
            }
        }
        return curr;
    }
}
