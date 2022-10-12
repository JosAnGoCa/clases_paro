public class SimpleLinkedList<T> {
    private class Node<T> {
        public T value;
        public Node<T> next;
    }

    private Node<T> head;

    public SimpleLinkedList() {}

    public SimpleLinkedList(T startValue) {
        head = new Node<>();
        head.value = startValue;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T valueToAdd) {
        Node<T> newNode = new Node<>();
        newNode.value = valueToAdd;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T valueToAdd) {
        if(isEmpty()) {
            addFirst(valueToAdd);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node<T> newNode = new Node<>();
            newNode.value = valueToAdd;
            current.next = newNode;
        }
    }

    public boolean has(T valueToSearch) {
        Node<T> current = head;
        while (current != null) {
            if (valueToSearch.equals(current.value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void searchAndDelete(T valueToDelete) {
        if (!has(valueToDelete))
            return;
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null && !valueToDelete.equals(curr.value)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == head) {
            deleteFirst();
            return;
        }
        prev.next = curr.next;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    public String toString(){
        String resultado = "";
        Node<T> current = head;
        while (current != null) {
            resultado += current.value + " -> ";
            current = current.next;
        }
        resultado += "null";
        return resultado;
    }
}
