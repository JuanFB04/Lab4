import java.util.ArrayList;
import java.util.Scanner;

public class MainSum{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DriverSum drive = new DriverSum();
        ArrayList<Usuario> usuarios = drive.leerUsuariosCSV();
        //drive.registrarUsuario(scan, usuarios);
        //drive.escribirUsuariosCSV(usuarios);

        System.out.println(usuarios.get(0).getUltReuniones());
    }
}