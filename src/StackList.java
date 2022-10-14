public class StackList<T> {
    private class Node<T> {
        public T value;
        public Node<T> next;
    }

    private Node<T> top;

    public boolean empty(){
        return top == null;
    }

    public void push(T valueToAdd) {
        Node<T> newNode = new Node<>();
        newNode.value = valueToAdd;
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (!empty()) {
            top = top.next;
        }
    }

    public T top() {
        if(empty()) {
            return null;
        }
        return top.value;
    }

    public void imprimeR() {
        imprimeR(top);
    }

    private void imprimeR(Node<T> curr) {
        if (curr == null) return;
        System.out.print(curr.value + " ");
        imprimeR(curr.next);
    }

    @Override
    public String toString() {
        String result = "[ ";
        Node<T> current = top;
        while (current != null) {
            result += current.value + " ";
            current = current.next;
        }
        result += "]";
        return result;
    }
}
