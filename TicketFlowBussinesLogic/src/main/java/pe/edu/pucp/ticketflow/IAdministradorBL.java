package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.solicitud.model.Solicitud;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

import java.util.List;

public interface IAdministradorBL {

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

    //GESTION DE SOLICITUDES
    List<Solicitud> listarSolicitudes() throws BusinessLogicException;
    List<Solicitud> buscarSolicitud(String nombre) throws BusinessLogicException;
    List<Solicitud> filtrarSolicitudesPorEstado(Integer idEstado) throws BusinessLogicException;
    Solicitud detalleSolicitud(Integer idSolicitud) throws BusinessLogicException;
    Solicitud editarSolicitud(Solicitud solicitud) throws BusinessLogicException;
    Solicitud aprobarSolicitud(Integer idSolicitud) throws BusinessLogicException;
    Solicitud rechazarSolicitud(Integer idSolicitud) throws BusinessLogicException;
    void eliminarSolicitud(Integer idSolicitud) throws BusinessLogicException;

}
