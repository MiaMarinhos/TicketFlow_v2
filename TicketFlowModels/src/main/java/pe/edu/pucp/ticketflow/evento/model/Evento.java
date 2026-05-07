package pe.edu.pucp.ticketflow.evento.model;

import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;

import java.sql.Time;
import java.util.Date;

public class Evento {
    private int idEvento;
    private String titulo;
    private String descripcion;
    private int capacidad_entradas;
    private categoria_evento categoria;
    private Date fecha;
    private Time hora_inicio;
    private Time hora_fin;
    private String ubicacion;
    private String nombre_establecimiento;
    private String img;
    private double precio;
    private Distrito distrito;
    private int idAnfitrion;
    private EstadoPublicacion estadoPublicacion;
    private EstadoEvento estadoEvento;

    public Evento() {

    }
    public Evento(String titulo,String descripcion,int capacidad_entradas,
                  categoria_evento categoria, Date fecha,Time hora_inicio,Time hora_fin,
                  String ubicacion,String nombre_establecimiento,String img,double precio,
                  Distrito distrito,int idAnfitrion,EstadoPublicacion estadoPublicacion, EstadoEvento estadoEvento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad_entradas = capacidad_entradas;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.ubicacion = ubicacion;
        this.nombre_establecimiento = nombre_establecimiento;
        this.img = img;
        this.precio = precio;
        this.distrito = distrito;
        this.idAnfitrion = idAnfitrion;
        this.estadoPublicacion = estadoPublicacion;
        this.estadoEvento = estadoEvento;
    }

    public Evento(int idEvento,String titulo,String descripcion,int capacidad_entradas,
                  categoria_evento categoria, Date fecha,Time hora_inicio,Time hora_fin,
                  String ubicacion,String nombre_establecimiento,String img,double precio,
                  Distrito distrito,int idAnfitrion,EstadoPublicacion estadoPublicacion, EstadoEvento estadoEvento) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad_entradas = capacidad_entradas;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.ubicacion = ubicacion;
        this.nombre_establecimiento = nombre_establecimiento;
        this.img = img;
        this.precio = precio;
        this.distrito = distrito;
        this.idAnfitrion = idAnfitrion;
        this.estadoPublicacion = estadoPublicacion;
        this.estadoEvento = estadoEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad_entradas() {
        return capacidad_entradas;
    }

    public void setCapacidad_entradas(int capacidad_entradas) {
        this.capacidad_entradas = capacidad_entradas;
    }

    public categoria_evento getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria_evento categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public int getIdAnfitrion() {
        return idAnfitrion;
    }

    public void setIdAnfitrion(int idAnfitrion) {
        this.idAnfitrion = idAnfitrion;
    }

    public EstadoPublicacion getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public EstadoEvento getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEvento estadoEvento) {
        this.estadoEvento = estadoEvento;
    }
}
