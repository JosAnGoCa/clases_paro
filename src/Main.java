public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> arbolBinario = new BinarySearchTree<>();
        arbolBinario.insert(53);
        arbolBinario.insert(47);
        arbolBinario.insert(46);
        arbolBinario.insert(44);
        arbolBinario.insert(45);
        arbolBinario.insert(50);
        arbolBinario.insert(49);
        arbolBinario.insert(48);
        arbolBinario.insert(52);
        arbolBinario.insert(51);
        arbolBinario.insert(57);
        arbolBinario.insert(56);
        arbolBinario.insert(54);
        arbolBinario.insert(55);
        arbolBinario.insert(60);
        arbolBinario.insert(59);
        arbolBinario.insert(58);
        arbolBinario.insert(62);
        arbolBinario.insert(61);
        System.out.println(arbolBinario.findHeight());
    }
}
