import java.util.ArrayList;
import java.util.Scanner;

public class Base extends Usuario implements Membresia {
    public Base(String nomUs, String contra, boolean tipoPlan, String estado, int reservaciones, ArrayList<String> ultReuniones, ArrayList<String> ultContactos){
        super(nomUs, contra, tipoPlan, estado, reservaciones, ultReuniones, ultContactos);
    }

    @Override
    public void listarReuniones(ArrayList<String> reuniones, Scanner scan){}
    public void listarContactos(ArrayList<String> contactos, Scanner scan){}
    public void crearReunion(Scanner scan){

    }
}
