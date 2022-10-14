public class Main {
    public static void main(String[] args) {
        QueueArr<Integer> queue = new QueueArr<>(5);
        System.out.println(queue);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

    }
}
