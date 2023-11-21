import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverSum {
    String fileUsuarios = "UsuariosBaseSum.csv";
    String fileReuniones = "ReunionesBaseSum.csv";

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
        try(BufferedReader br = new BufferedReader(new FileReader(fileUsuarios))){
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsuarios))) {
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

/**
     * @return
     */
    public ArrayList<Reunion> leerReunionesCSV(){
        ArrayList<Reunion> reuniones = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileReuniones))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atr = linea.split(",");
                String fecha = atr[0];
                String hora = atr[1];
                String nomRe = atr[2];
                String pin = atr[3];
                String duración = atr[4];
                ArrayList<String> listInv = new ArrayList<>();
                try{
                    String[] invitados=atr[5].split("-");
                    for(String invitado:invitados){
                        listInv.add(invitado);}
                }catch(Exception e){
                    listInv = new ArrayList<>();
                }
                Reunion reunion = new Reunion(fecha, hora, nomRe, pin, duración, listInv);
                reuniones.add(reunion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reuniones;
        
    }

    /**
     * @param reuniones
     */
    public void escribirReunionesCSV(ArrayList<Reunion> reuniones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReuniones))) {
            for (Reunion reunion : reuniones) {
                String fecha = reunion.getFecha();
                String hora = reunion.getHora();
                String nomRe = reunion.getNomRe();
                String pin = reunion.getPin();
                String duracion = reunion.getDuracion();
                String listInv = String.join("-",reunion.getListInv());
                String linea = String.join(",",fecha,hora,nomRe,pin,duracion,listInv);
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


