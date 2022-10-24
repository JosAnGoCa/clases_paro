public class Main {
    public static void main(String[] args) {
        HastableSC<String, String> coloresFavoritos = new HastableSC<>();
        coloresFavoritos.insert("Andrea", "Rojo / Rosa");
        coloresFavoritos.insert("Irene", "Morado");
        coloresFavoritos.insert("Gabo", "Verde");
        coloresFavoritos.insert("Camila", "Morado");
        coloresFavoritos.insert("Didier", "Negro");
        coloresFavoritos.insert("Sebas", "Morado");
        System.out.println("ANDREA");
        coloresFavoritos.insert("Andrea", "Rojo");
    }
}
