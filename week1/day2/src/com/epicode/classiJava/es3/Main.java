package src.com.epicode.classiJava.es3;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(
                "Giovanni", "Muciaccia",
                "abc@gmail.com",
                "123",
                "12/05/1994");
        Articolo art1 = new Articolo("123", "Articolo 1", 5.5, 5);
        Articolo art2 = new Articolo("345", "Articolo 2", 9.99, 2);
        Articolo art3 = new Articolo("567", "Articolo 3", 2.5, 9);
        Carrello carrello = new Carrello(cliente, new Articolo[]{art1, art2, art3});
        carrello.stampa();
    }
}
