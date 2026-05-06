package pe.edu.pucp.ticketflow.compra.model;


import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
    private int idCompra;
    private int entradasCompradas;
    private LocalDate fechaCompra;
    private LocalTime horaCompra;
    private String metodoPago;
    private double montoParcial;
    private double montoTotal;
    private int puntosCanjeados;
    private int descuento;
    private String estado;

    //private Cliente cliente;
    //private Evento evento;
}
