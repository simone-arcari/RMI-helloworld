import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Richiesta dell'IP del server
            System.out.print("Inserisci l'indirizzo IP del server: ");
            String serverIP = scanner.nextLine();

            // Richiesta della porta del server
            System.out.print("Inserisci la porta del server: ");
            int serverPort = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline rimasta dopo scanner.nextInt()

            // Connessione al registro RMI
            Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);

            // Recupero dell'oggetto remoto
            Hello stub = (Hello) registry.lookup("Hello");

            // Ciclo per invocare il metodo remoto
            while (true) {
                System.out.print("digita 'exit' per terminare o premi invio per continuare: ");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Terminazione del programma...");
                    break;
                }

                // Invocazione del metodo remoto
                String response = stub.sayHello();
                System.out.println("Risposta dal server: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
