import java.rmi.Remote;
import java.rmi.RemoteException;

// Definizione dell'interfaccia remota
public interface Hello extends Remote {
    // Metodo che può essere invocato remotamente
    String sayHello() throws RemoteException;
}
