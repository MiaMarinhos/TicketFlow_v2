package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

import java.util.List;

public interface IAdministradorBL {

    // ACCIONES PROPIAS DEL ADMINISTRADOR DENTRO DEL SISTEMA:

    void verSolicitudes() throws BusinessLogicException;
    void responderSolicitudes() throws BusinessLogicException;
    void editarCuentasDeUsuarios() throws BusinessLogicException;
    void generarReporte() throws BusinessLogicException;
    // void listarUsuarios() throws BusinessLogicException;
    // void listarEventos() throws BusinessLogicException;
    void publicarEvento() throws BusinessLogicException;

    // CRUD BASICO DEL ADMINISTRADOR:
    Administrador registrarAdministrador(Administrador administrador) throws BusinessLogicException;
    Administrador buscarAdministradorPorId(Integer id) throws BusinessLogicException;
    Administrador actualizarAdministrador(Administrador administrador, Integer id) throws BusinessLogicException;
    void eliminarAdministrador(Integer id) throws BusinessLogicException;
    List<Administrador> listarAdministradores() throws BusinessLogicException;

    //GESTION DE USUARIOS
    List<Usuario> listarUsuarios()  throws BusinessLogicException;
    List<Usuario> buscarUsuario(String nombre)  throws BusinessLogicException;
    List<Usuario> filtrarUsuariosPorTipo(Integer idTipoUsuario)  throws BusinessLogicException;
    List<Usuario> filtrarUsuariosPorEstado(Integer idEstado)  throws BusinessLogicException;
    Usuario registrarUsuario(Usuario usuario)  throws BusinessLogicException;
    Usuario editarUsuario(Usuario usuario)  throws BusinessLogicException;
    Usuario bloquearUsuario(Integer idUsuario)  throws BusinessLogicException;
    Usuario desbloquearUsuario(Integer idUsuario)  throws BusinessLogicException;

    //GESTION DE EVENTOS
    List<Evento> listarEventos()  throws BusinessLogicException;
    List<Evento> buscarEvento(String titulo) throws BusinessLogicException;
    List<Evento> filtrarEventosPorEstado(Integer idEstadoEvento) throws BusinessLogicException;
    Evento detalleEvento(Integer idEvento) throws BusinessLogicException;
    Evento registrarEvento(Evento evento) throws BusinessLogicException;
    Evento editarEvento(Evento evento) throws BusinessLogicException;
    Evento aprobarEvento(Integer idEvento) throws BusinessLogicException;
    Evento rechazarEvento(Integer idEvento) throws BusinessLogicException;
    Evento eliminarEvento(Integer idEvento) throws BusinessLogicException;
}
