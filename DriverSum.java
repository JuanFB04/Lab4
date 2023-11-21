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
        ArrayList<String> contactos = new ArrayList<>();
        if(tipoPlan==false){
            Base base = new Base(nomUs, contra, tipoPlan, "disponible", 0, contactos);
            usuarios.add(base);
        }
        if(tipoPlan==true){
            Premium premium = new Premium(nomUs, contra, tipoPlan, "disponible", 0, contactos);
            usuarios.add(premium);
        }
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
                ArrayList<String> ultContactos = new ArrayList<>();
                try{
                    String[] contactos=atr[5].split("-");
                    for(String contacto:contactos){
                        ultContactos.add(contacto);}
                }catch(Exception e){
                    ultContactos = new ArrayList<>();
                }
                if(tipoPlan==false){
                    Base base = new Base(nomUs, contra, tipoPlan, "disponible", 0, ultContactos);
                    usuarios.add(base);
                }
                if(tipoPlan==true){
                    Premium premium = new Premium(nomUs, contra, tipoPlan, "disponible", 0, ultContactos);
                    usuarios.add(premium);
                }
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
                String ultContactos = String.join("-",usuario.getUltContactos());
                String linea = String.join(",",nomUs,contra,tipoPlan,estado,reservaciones,ultContactos);
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
                String dueno = atr[0];
                String fecha = atr[1];
                String hora = atr[2];
                String nomRe = atr[3];
                String pin = atr[4];
                int duración = Integer.valueOf(atr[5]);
                ArrayList<String> listInv = new ArrayList<>();
                try{
                    String[] invitados=atr[6].split("-");
                    for(String invitado:invitados){
                        listInv.add(invitado);}
                }catch(Exception e){
                    listInv = new ArrayList<>();
                }
                Reunion reunion = new Reunion(dueno, fecha, hora, nomRe, pin, duración, listInv);
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
                String dueno = reunion.getDueno();
                String fecha = reunion.getFecha();
                String hora = reunion.getHora();
                String nomRe = reunion.getNomRe();
                String pin = reunion.getPin();
                String duracion = String.valueOf(reunion.getDuracion());
                String listInv = String.join("-",reunion.getListInv());
                String linea = String.join(",",dueno,fecha,hora,nomRe,pin,duracion,listInv);
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}