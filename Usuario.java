import java.util.ArrayList;

public abstract class Usuario {
    protected String nomUs;
    protected String contra;
    protected boolean tipoPlan;
    protected String estado;
    protected int reservaciones;
    protected ArrayList<Reunion> ultReuniones;
    protected ArrayList<String> ultContactos;

    public Usuario(String nomUs, String contra, boolean tipoPlan, String estado, int reservaciones, ArrayList<Reunion> ultReuniones, ArrayList<String> ultContactos) {
        this.nomUs = nomUs;
        this.contra = contra;
        this.tipoPlan = tipoPlan;
        this.estado = estado;
        this.reservaciones = reservaciones;
        this.ultReuniones = ultReuniones;
        this.ultContactos = ultContactos;
    }

    public String getNomUs() {
        return nomUs;
    }

    public void setNomUs(String nomUs) {
        this.nomUs = nomUs;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(boolean tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(int reservaciones) {
        this.reservaciones = reservaciones;
    }

    public ArrayList<Reunion> getUltReuniones() {
        return ultReuniones;
    }

    public ArrayList<String> getUltContactos() {
        return ultContactos;
    }
}
