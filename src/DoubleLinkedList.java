public class DoubleLinkedList<T> {
    private class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;
    }

    private Node<T> head;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T valueToAdd){
        if(isEmpty()) {
            head = new Node<>();
            head.value = valueToAdd;
        } else {
            Node<T> newNode = new Node<>();
            newNode.value = valueToAdd;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) return;
        head = head.next;
        if (head == null) return;
        head.prev = null;
    }

    public String toString(){
        String resultado = "null - ";
        Node<T> current = head;
        while (current != null) {
            resultado += current.value + " - ";
            current = current.next;
        }
        resultado += "null";
        return resultado;
    }
}
