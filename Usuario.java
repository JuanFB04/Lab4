import java.util.ArrayList;

public class Usuario {
    protected String nomUs;
    protected String contra;
    protected boolean tipoPlan;
    protected String estado;
    protected int reservaciones;
    protected ArrayList<String> ultReuniones;
    protected ArrayList<String> ultContactos;

    public Usuario(String nomUs, String contra, boolean tipoPlan, String estado, int reservaciones, ArrayList<String> ultReuniones, ArrayList<String> ultContactos) {
        this.nomUs = nomUs;
        this.contra = contra;
        this.tipoPlan = tipoPlan;
        this.estado = estado;
        this.reservaciones = reservaciones;
        this.ultReuniones = ultReuniones;
        this.ultContactos = ultContactos;
    }

    /**
     * @return
     */
    public String getNomUs() {return nomUs;}

    /**
     * @param nomUs
     */
    public void setNomUs(String nomUs) {this.nomUs = nomUs;}

    /**
     * @return
     */
    public String getContra() {return contra;}

    /**
     * @param contra
     */
    public void setContra(String contra) {this.contra = contra;}

    /**
     * @return
     */
    public boolean getTipoPlan() {return tipoPlan;}

    /**
     * @param tipoPlan
     */
    public void setTipoPlan(boolean tipoPlan) {this.tipoPlan = tipoPlan;}

    /**
     * @return
     */
    public String getEstado() {return estado;}

    /**
     * @param estado
     */
    public void setEstado(String estado) {this.estado = estado;}

    /**
     * @return
     */
    public int getReservaciones() {return reservaciones;}

    /**
     * @param reservaciones
     */
    public void setReservaciones(int reservaciones) {this.reservaciones = reservaciones;}

    /**
     * @return
     */
    public ArrayList<String> getUltReuniones() {return ultReuniones;}

    /**
     * @return
     */
    public ArrayList<String> getUltContactos() {return ultContactos;}
}
