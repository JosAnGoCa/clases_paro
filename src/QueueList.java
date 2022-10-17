public class QueueList<T> {
    private class Node<T> {
        public T value;
        public Node<T> next;
    }

    private Node<T> head, tail;

    public boolean empty() {
        return head == null;
    }

    public void enqueue(T valueToAdd) {
        Node<T> newNode = new Node<>();
        newNode.value = valueToAdd;
        if (empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void dequeue(){
        if(!empty()) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    public String toString(){
        String result = "";
        Node<T> aux = head;
        while (aux != null) {
            result += aux.value + " ";
            aux = aux.next;
        }
        if (result == "") {
            result = "null";
        }
        return result;
    }
}
