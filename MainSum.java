import java.util.ArrayList;
import java.util.Scanner;

public class MainSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DriverSum drive = new DriverSum();

        // Leer usuarios y reuniones desde el archivo CSV
        ArrayList<Usuario> usuarios = drive.leerUsuariosCSV();
        ArrayList<Reunion> reuniones = drive.leerReunionesCSV();

        // Verificar si hay al menos un usuario de tipo Membresia para probar el método crearReunion
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Membresia) {
                Membresia membresia = (Membresia) usuario;
                if (membresia instanceof Base) {
                    Base base = (Base) membresia;
                    base.crearReunion(scan, reuniones);

                    // Imprimir la lista de reuniones después de crear una nueva
                    base.listarReuniones(reuniones, scan);

                    // Imprimir la lista de contactos
                    membresia.listarContactos(usuario.getUltContactos(), scan);
                    break; // Solo probaremos con el primer usuario de tipo Membresia
                }
            }
        }

        // Escribir los cambios de vuelta al archivo CSV
        drive.escribirUsuariosCSV(usuarios);
        drive.escribirReunionesCSV(reuniones);
    }
}
