import java.util.ArrayList;

public class Base extends Usuario {
    public Base(String nomUs, String contra, boolean tipoPlan, String estado, int reservaciones, ArrayList<String> ultReuniones, ArrayList<String> ultContactos){
        super(nomUs, contra, tipoPlan, estado, reservaciones, ultReuniones, ultContactos);
    }
}
