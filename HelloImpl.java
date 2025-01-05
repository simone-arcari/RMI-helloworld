import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementazione dell'interfaccia remota
public class HelloImpl extends UnicastRemoteObject implements Hello {
    
    // Costruttore
    protected HelloImpl() throws RemoteException {
        super();
    }

    // Implementazione del metodo remoto
    @Override
    public String sayHello() throws RemoteException {
        System.out.println("Richiesta elaborata!");
        return "Ciao dal server remoto!";
    }

    // Metodo main per avviare il server
    public static void main(String[] args) {
        try {
            // Creazione dell'oggetto remoto
            HelloImpl hello = new HelloImpl();

            // Registrazione dell'oggetto remoto nel registro RMI
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("Hello", hello);
            System.out.println("Server pronto e in ascolto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
