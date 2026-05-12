package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

import java.util.List;

public interface IAdministradorBL {

    // ACCIONES PROPIAS DEL ADMINISTRADOR DENTRO DEL SISTEMA:

    void verSolicitudes() throws BusinessLogicException;
    void responderSolicitudes() throws BusinessLogicException;
    void editarCuentasDeUsuarios() throws BusinessLogicException;
    void generarReporte() throws BusinessLogicException;
    void listarUsuarios() throws BusinessLogicException;
    void listarEventos() throws BusinessLogicException;
    void publicarEvento() throws BusinessLogicException;

    // CRUD BASICO DEL ADMINISTRADOR:
    Administrador registrarAdministrador(Administrador administrador) throws BusinessLogicException;
    Administrador buscarAdministradorPorId(Integer id) throws BusinessLogicException;
    Administrador actualizarAdministrador(Administrador administrador, Integer id) throws BusinessLogicException;
    void eliminarAdministrador(Integer id) throws BusinessLogicException;
    List<Administrador> listarAdministradores() throws BusinessLogicException;

}
