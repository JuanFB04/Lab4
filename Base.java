import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Base extends Usuario implements Membresia {
    public Base(String nomUs, String contra, boolean tipoPlan, String estado, int reservaciones, ArrayList<String> ultContactos){
        super(nomUs, contra, tipoPlan, estado, reservaciones, ultContactos);
    }

    @Override
    public void listarReuniones(ArrayList<Reunion> reuniones, Scanner scan){
        System.out.println("Listado de las reuniones pasadas del usuario " + getNomUs() + ":");
        for (Reunion reunion: reuniones){
            if (reunion.getDueno().equals(getNomUs())){
                System.out.println("Fecha: " + reunion.getFecha() + ", Hora: " + reunion.getHora() + ", Nombre: " + reunion.getNomRe() 
                + ", Duración: " + reunion.getDuracion() + "minutos");
            }
        }
    }
    public void listarContactos(ArrayList<String> contactos, Scanner scan){
        System.out.println("Los últimos contactos del usuario " + getNomUs() + " son:");
        for (String contacto: getUltContactos()){
            System.out.println(contacto);
            }
    }

    public void crearReunion(Scanner scan, ArrayList<Reunion> reuniones){
        if(reservaciones<2){
            System.out.println("Ingrese la fecha de la reunión en el siguiente formato DD/MM/AA: ");
            String fecha = scan.nextLine();

            System.out.println("Ingrese la hora de la reunión el siguient formato HH:MM ");
            String hora = scan.nextLine();

            ArrayList<Reunion> ultReuniones = new ArrayList<>();
            for(Reunion reu: reuniones){
                if(reu.getDueno().equals(nomUs)){
                    ultReuniones.add(reu);
                }
            }
            boolean horario = false;
            for(Reunion reudueno: ultReuniones){
                if(reudueno.getFecha().equals(fecha) && reudueno.getHora().equals(hora)){horario=true;}
            }
            
            while(horario){
                System.out.println("Lo sentimos, parece que este espacio ya está ocupado, prueba en otro horario");
                System.out.println("Ingrese la fecha de la reunión en el siguiente formato DD/MM/AA: ");
                fecha = scan.nextLine();
                System.out.println("Ingrese la hora de la reunión el siguient formato HH:MM ");
                hora = scan.nextLine();
            }
            System.out.println("Ingrese el nombre de la reunión:");
            String nomRe = scan.nextLine();
            System.out.println("Ingrese el número de minutos de duración: (15 minutos máximo para usuarios base)");
            int duracion=16;
            do{
                try{
                    duracion = scan.nextInt();
                    scan.nextLine();
                } catch(Exception e){
                    System.out.println("Ingrese solamente el número");
                }
            }while(duracion>15);
            System.out.println("Ingrese la cantidad de invitados desea agregar: (5 personas máximo para usuarios base)");
            int invitados=6;
            do{
                try{
                    invitados = scan.nextInt();
                    scan.nextLine();
                } catch(Exception e){
                    System.out.println("Ingrese solamente el número");
                }
            }while(invitados>5);
            System.out.println("Ingrese los nombres: ");
            ArrayList<String> contactos = new ArrayList<>();
            for(int i=0;i<=invitados;i++){
                String nomInvitado = scan.nextLine();
                contactos.add(nomInvitado);
                ultContactos.add(nomInvitado);
            }
            Random random = new Random();
            String pin = String.valueOf(100 + random.nextInt(900));
            Reunion reunion = new Reunion(nomUs, fecha, hora, nomRe, pin, duracion, contactos);
            reuniones.add(reunion);
            System.out.println("Reunión creada con éxito, su pin es "+pin);
            setReservaciones(reservaciones+1);
        }
        else{
            System.out.println("Lo sentimos, ya ha alcanzado el límite de reservaciones máximas por el día, mejore su membresía a Premium para más reuniones");
        }
    }
}
