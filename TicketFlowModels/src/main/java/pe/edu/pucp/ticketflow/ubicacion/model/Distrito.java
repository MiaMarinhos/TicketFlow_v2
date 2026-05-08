package pe.edu.pucp.ticketflow.ubicacion.model;

public class Distrito {
    private int idDistrito;
    private String nombre;
    private int idRegion;

    public Distrito(){

    }
    public Distrito(int idDistrito, String nombre, int idRegion) {
        this.idDistrito = idDistrito;
        this.nombre = nombre;
        this.idRegion = idRegion;
    }
    public Distrito(String nombre, int idRegion) {
        this.nombre = nombre;
        this.idRegion = idRegion;
    }

    public int getIdDistrito() {
        return idDistrito;
    }
    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }
}
