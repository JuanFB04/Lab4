import java.util.ArrayList;

public class Reunion {
    private String dueno;
    private String fecha;
    private String hora;
    private String nomRe;
    private String pin;
    private int duracion;
    private ArrayList<String> listInv;

    public Reunion(String dueno, String fecha, String hora, String nomRe, String pin, int duracion, ArrayList<String> listInv) {
        this.dueno = dueno;
        this.fecha = fecha;
        this.hora = hora;
        this.nomRe = nomRe;
        this.pin = pin;
        this.duracion = duracion;
        this.listInv = listInv;
    }

    /**
     * @return
     */
    public String getDueno() {return dueno;}

    /**
     * @param dueno
     */
    public void setDueno(String dueno) {this.dueno=dueno;}

    /**
     * @return
     */
    public String getFecha() {return fecha;}

    /**
     * @param fecha
     */
    public void setFecha(String fecha) {this.fecha = fecha;}

    /**
     * @return
     */
    public String getHora() {return hora;}

    /**
     * @param hora
     */
    public void setHora(String hora) {this.hora = hora;}

    /**
     * @return
     */
    public String getNomRe() {return nomRe;}

    /**
     * @param nomRe
     */
    public void setNomRe(String nomRe) {this.nomRe = nomRe;}

    /**
     * @return
     */
    public String getPin() {return pin;}

    /**
     * @param pin
     */
    public void setPin(String pin) {this.pin = pin;}

    /**
     * @return
     */
    public int getDuracion() {return duracion;}

    /**
     * @param duracion
     */
    public void setDuracion(int duracion) {this.duracion = duracion;}

    /**
     * @return
     */
    public ArrayList<String> getListInv() {return listInv;}

    /**
     * @param listInv
     */
    public void setListInv(ArrayList<String> listInv) {this.listInv = listInv;}
}