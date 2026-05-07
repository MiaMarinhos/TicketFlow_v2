package pe.edu.pucp.ticketflow.pago.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;

import java.time.LocalDate;

public class Pago {
    private int idPago;
    private LocalDate fechaPago;
    private LocalDate fechaLimitePago;
    private double totalAPagar;
    private String comprobante;
    private String estado;

    private Evento evento;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDate getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDate fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pago() {}

    public Pago(int idPago, LocalDate fechaPago, LocalDate fechaLimitePago,
                double totalAPagar, String comprobante, String estado, Evento evento){
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.fechaLimitePago = fechaLimitePago;
        this.totalAPagar = totalAPagar;
        this.comprobante = comprobante;
        this.estado = estado;
        this.evento = evento;
    }
}
