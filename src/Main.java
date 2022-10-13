public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> listaLigada = new DoubleLinkedList<>();
        System.out.println(listaLigada);
        listaLigada.addFirst(3);
        listaLigada.addFirst(4);
        listaLigada.addFirst(6);
        System.out.println(listaLigada);
        listaLigada.deleteFirst();
        System.out.println(listaLigada);
        listaLigada.deleteFirst();
        System.out.println(listaLigada);
        listaLigada.deleteFirst();
        System.out.println(listaLigada);
    }
}
