package pe.edu.pucp.ticketflow.usuario.model;

import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;

import java.sql.Date;

public class Cliente extends Usuario{
    int puntosBonus;

    public Cliente (){}

    public Cliente(int idUsuario, String dni, String nombre, String apellidoPaterno,
                   String apellidoMaterno, String telefono, String correoElectronico,
                   String contrasena, Date fechaRegistro, Date fechaNacimiento,
                   String estado, Distrito distrito, int puntosBonus) {
        super(idUsuario, dni, nombre, apellidoPaterno, apellidoMaterno, telefono,
                correoElectronico, contrasena, fechaRegistro, fechaNacimiento, estado,
                distrito);
        this.puntosBonus = puntosBonus;
    }

    public Cliente(int puntosBonus) {
        this.puntosBonus = puntosBonus;
    }

    public int getPuntosBonus() {
        return puntosBonus;
    }

    public void setPuntosBonus(int puntosBonus) {
        this.puntosBonus = puntosBonus;
    }


}
