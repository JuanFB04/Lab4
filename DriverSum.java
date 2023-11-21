import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverSum {
    String file = "UsuariosBaseSum.csv";

    /**
     * @param scan
     * @param usuarios
     */
    public void registrarUsuario(Scanner scan, ArrayList<Usuario> usuarios){
        System.out.println("Ingrese su nombre de usuario:");
        String nomUs = scan.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contra = scan.nextLine();
        int tipoPlanInt=0;
        boolean tipoPlan=false;
        do {
            System.out.println("Elegir plan: Base (con funciones limitadas) o Premium (acceso a todo)\nPresione 1 para Base\nPresione 2 para Premium");
            try {
                tipoPlanInt = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
            }
        } while (tipoPlanInt<1||tipoPlanInt>2);
        if(tipoPlanInt==2){tipoPlan=true;}
        ArrayList<String> reuniones = new ArrayList<>();
        ArrayList<String> contactos = new ArrayList<>();
        Usuario usuario = new Usuario(nomUs, contra, tipoPlan, "disponible", 0, reuniones, contactos);
        usuarios.add(usuario);
    }

    /**
     * @return
     */
    public ArrayList<Usuario> leerUsuariosCSV(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atr = linea.split(",");
                String nomUs = atr[0];
                String contra = atr[1];
                boolean tipoPlan = Boolean.parseBoolean(atr[2]);
                String estado = atr[3];
                int reservaciones= Integer.parseInt(atr[4]);
                ArrayList<String> ultReuniones = new ArrayList<>();
                try{
                    String[] reuniones=atr[5].split("-");
                    for(String reunion:reuniones){
                        ultReuniones.add(reunion);}
                }catch(Exception e){
                    ultReuniones = new ArrayList<>();
                }
                ArrayList<String> ultContactos = new ArrayList<>();
                try{
                    String[] contactos=atr[6].split("-");
                    for(String contacto:contactos){
                        ultContactos.add(contacto);}
                }catch(Exception e){
                    ultContactos = new ArrayList<>();
                }
                Usuario usuario = new Usuario(nomUs, contra, tipoPlan, estado, reservaciones, ultReuniones, ultContactos);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
        
    }

    /**
     * @param usuarios
     */
    public void escribirUsuariosCSV(ArrayList<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Usuario usuario : usuarios) {
                String nomUs=usuario.getNomUs();
                String contra=usuario.getContra();
                String tipoPlan=String.valueOf(usuario.getTipoPlan());
                String estado=usuario.getEstado();
                String reservaciones=String.valueOf(usuario.getReservaciones());
                String ultReuniones = String.join("-",usuario.getUltReuniones());
                String ultContactos = String.join("-",usuario.getUltContactos());
                String linea = String.join(",",nomUs,contra,tipoPlan,estado,reservaciones,ultReuniones,ultContactos);
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
