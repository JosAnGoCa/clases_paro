public class Main {
    public static void main(String[] args) {
        HashtableOA<String, String> coloresFavoritos = new HashtableOA<>();
        System.out.println("Inserta Andrea");
        coloresFavoritos.insert("Andrea", "Rojo / Rosa");
        System.out.println(coloresFavoritos.size());
        System.out.println("Inserta Irene");
        coloresFavoritos.insert("Irene", "Morado");
        System.out.println(coloresFavoritos.size());
        System.out.println("Inserta Gabo");
        coloresFavoritos.insert("Gabo", "Verde");
        System.out.println(coloresFavoritos.size());
        System.out.println("Inserta Camila");
        coloresFavoritos.insert("Camila", "Morado");
        System.out.println(coloresFavoritos.size());
        System.out.println("Inserta Didier");
        coloresFavoritos.insert("Didier", "Negro");
        System.out.println(coloresFavoritos.size());

        System.out.println("Elimina a Gabo");
        coloresFavoritos.remove("Gabo");
        System.out.println(coloresFavoritos.size());


        System.out.println("Inserta Belem");
        coloresFavoritos.insert("Belem", "Amarillo");
        System.out.println(coloresFavoritos.size());

        System.out.println("Actualiza Belem");
        coloresFavoritos.insert("Belem", "Amarillo");
        System.out.println(coloresFavoritos.size());

        SimpleLinkedList<String> keys = coloresFavoritos.keys();
        for (String key: keys) {
            System.out.println(key);
        }
    }
}
