public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> arbolBinario = new BinarySearchTree<>();
        arbolBinario.insert(30);
        arbolBinario.insert(20);
        arbolBinario.insert(15);
        arbolBinario.insert(25);
        arbolBinario.insert(40);
        arbolBinario.insert(35);
        arbolBinario.insert(45);
        arbolBinario.levelOrderTraversal();
    }
}
