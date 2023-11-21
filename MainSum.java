import java.util.ArrayList;
import java.util.Scanner;

public class MainSum{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DriverSum drive = new DriverSum();
        ArrayList<Usuario> usuarios = drive.leerUsuariosCSV();
        ArrayList<Reunion> reuniones = drive.leerReunionesCSV();
        Usuario usuario = usuarios.get(0);
        Base base = (Base) usuario;
        base.crearReunion(scan, reuniones);


        drive.escribirUsuariosCSV(usuarios);
        drive.escribirReunionesCSV(reuniones);
    }
}