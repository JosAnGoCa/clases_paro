public class Main {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> listaLigada = new SimpleLinkedList<>();
        listaLigada.addFirst(222);
        listaLigada.addFirst(1);
        listaLigada.addFirst(9);
        listaLigada.addLast(3);
        listaLigada.addLast(5);
        listaLigada.addLast(6);
        System.out.println(listaLigada);
        System.out.println("Busca 1: " + listaLigada.has(1));
        System.out.println("Busca 9: " + listaLigada.has(9));
        System.out.println("Busca 21: " + listaLigada.has(21));
        System.out.println("Busca 222: " + listaLigada.has(222));
        System.out.println(listaLigada);
        listaLigada.searchAndDelete(222);
        System.out.println(listaLigada);
        listaLigada.searchAndDelete(1);
        System.out.println(listaLigada);
        listaLigada.searchAndDelete(1);
        System.out.println(listaLigada);
        listaLigada.searchAndDelete(9);
        System.out.println(listaLigada);
        listaLigada.deleteFirst();
        System.out.println(listaLigada);
    }
}
