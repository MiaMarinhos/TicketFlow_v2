package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

public interface IAdministradorBL {
    void verSolicitudes() throws BusinessLogicException;
    void responderSolicitudes() throws BusinessLogicException;
    void editarCuentasDeUsuarios() throws BusinessLogicException;
    void generarReporte() throws BusinessLogicException;
    void listarUsuarios() throws BusinessLogicException;
    void listarEventos() throws BusinessLogicException;
    void publicarEvento() throws BusinessLogicException;
}
