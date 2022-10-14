import java.util.Arrays;

public class QueueArr<T> {
    private T[] queue;
    private int head, tail;

    public QueueArr(int size){
        queue = (T[]) new Object[size];
        head = tail = -1;
    }

    public void enqueue(T valueToAdd) {
        if(!full()) {
            tail = move(tail);
            if (empty()) {
                head++;
            }
            queue[tail] = valueToAdd;
        }
    }

    public void dequeue() {
        if(!empty()) {
            if (head == tail) {
                head = tail = -1;
            } else {
                head = move(head);
            }
        }
    }

    public boolean empty() {
        return head == -1;
    }

    public boolean full() {
        return move(tail) == head;
    }

    private int move(int number) {
        return (number + 1) % queue.length;
    }

    @Override
    public String toString() {
        String result = "";
        if (!empty()) {
            int aux = head;
            do {
                result += queue[aux] + " ";
                aux = move(aux);
            } while (aux != move(tail));
        } else {
            result += "null";
        }
        return result;
    }
}
