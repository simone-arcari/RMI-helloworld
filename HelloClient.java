import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            // Connessione al registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Recupero dell'oggetto remoto
            Hello stub = (Hello) registry.lookup("Hello");
            
            // Invocazione del metodo remoto
            String response = stub.sayHello();
            System.out.println("Risposta dal server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
