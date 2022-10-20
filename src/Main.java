public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> arbolBinario = new BinarySearchTree<>();
        arbolBinario.insert(50);
        arbolBinario.insert(30);
        arbolBinario.insert(20);
        arbolBinario.insert(25);
        arbolBinario.insert(23);
        arbolBinario.insert(40);
        arbolBinario.insert(35);
        arbolBinario.insert(70);
        arbolBinario.insert(60);
        arbolBinario.insert(55);
        arbolBinario.insert(53);
        arbolBinario.insert(65);
        arbolBinario.insert(80);
        arbolBinario.insert(75);
        arbolBinario.insert(50);
        arbolBinario.inOrder();
        System.out.println("Busca 65: ");
        System.out.println(arbolBinario.findBucle(65));
        arbolBinario.deleteNode(65);
        System.out.println("Busca 65: ");
        System.out.println(arbolBinario.findBucle(65));
        arbolBinario.inOrder();
    }
}
