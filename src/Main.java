public class Main {
    public static void main(String[] args) {
        HastableSC<String, String> coloresFavoritos = new HastableSC<>();
        coloresFavoritos.insert("Andrea", "Rojo / Rosa");
        coloresFavoritos.insert("Irene", "Morado");
        System.out.println("Se redimenciono");
        coloresFavoritos.insert("Gabo", "Verde");
        coloresFavoritos.insert("Camila", "Morado");
        System.out.println("Se redimenciono");
        coloresFavoritos.insert("Didier", "Negro");
        coloresFavoritos.insert("Sebas", "Morado");
        coloresFavoritos.insert("Andrea", "Rojo");
        coloresFavoritos.insert("Luis", "Negro");
        coloresFavoritos.insert("Belem", "Amarillo");


        System.out.println("Color favorito de Andrea: " + coloresFavoritos.get("Andrea"));
        System.out.println("Color favorito de Irene: " + coloresFavoritos.get("Irene"));
        System.out.println("Color favorito de Didier: " + coloresFavoritos.get("Didier"));
        System.out.println("Color favorito de Luis: " + coloresFavoritos.get("Luis"));
        System.out.println("Color favorito de Gabo: " + coloresFavoritos.get("Gabo"));
        System.out.println("Color favorito de Jose: " + coloresFavoritos.get("Jose"));


        coloresFavoritos.remove("Andrea");


    }
}
