import java.util.ArrayList;

public class Reunion {
    private String fecha;
    private String hora;
    private String nomRe;
    private String pin;
    private String duracion;
    private ArrayList<String> listInv;

    public Reunion(String fecha, String hora, String nomRe, String pin, String duracion, ArrayList<String> listInv) {
        this.fecha = fecha;
        this.hora = hora;
        this.nomRe = nomRe;
        this.pin = pin;
        this.duracion = duracion;
        this.listInv = listInv;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNomRe() {
        return nomRe;
    }

    public void setNomRe(String nomRe) {
        this.nomRe = nomRe;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ArrayList<String> getListInv() {
        return listInv;
    }

    public void setListInv(ArrayList<String> listInv) {
        this.listInv = listInv;
    }
}
