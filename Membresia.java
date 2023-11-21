import java.util.ArrayList;
import java.util.Scanner;

public interface Membresia {
    /**
     * @param reuniones
     * @param scan
     */
    public void listarReuniones(ArrayList<String> reuniones, Scanner scan);
    /**
     * @param contactos
     * @param scan
     */
    public void listarContactos(ArrayList<String> contactos, Scanner scan);
    
    /**
     * @param scan
     */
    public void crearReunion(Scanner scan, ArrayList<Reunion> reunion);
}
