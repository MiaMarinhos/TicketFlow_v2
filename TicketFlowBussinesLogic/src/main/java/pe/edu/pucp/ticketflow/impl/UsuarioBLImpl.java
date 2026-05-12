package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.*;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;
import pe.edu.pucp.ticketflow.usuario.model.*;

import java.util.Date;

public class UsuarioBLImpl implements IUsuarioBL {

    private IDistritoDAO distritoDAO = new DistritoDAOImpl();
    private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private ITipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
    private IEstadoUsuarioDAO estadoUsuarioDAO = new EstadoUsuarioDAOImpl();
    private IClienteDAO clienteDAO = new ClienteDAOImpl();
    private IAnfitrionDAO anfitrionDAO = new AnfitrionDAOImpl();

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws BusinessLogicException{
        try{
            Distrito distrito = distritoDAO.read(usuario.getIdDistrito());
            usuario.setDistrito(distrito);

            String nombreTipo = "";
            if (usuario instanceof Cliente) {
                nombreTipo = "CLIENTE";
            } else if (usuario instanceof Anfitrion) {
                nombreTipo = "ANFITRION";
            }

            TipoUsuario tipo = tipoUsuarioDAO.buscarTipoUsuarioPorTipo(nombreTipo);
            usuario.setTipo(tipo);
            /*
            *   1 : Activo
            *   2 : Eliminado
            * */
            EstadoUsuario estadoUsuario = estadoUsuarioDAO.read(1);
            usuario.setEstado(estadoUsuario);

            usuario.setFechaRegistro(java.sql.Date.valueOf(java.time.LocalDate.now()));

            return usuarioDAO.create(usuario);
        }
        catch (Exception ex){
            if (ex instanceof BusinessLogicException) {
                throw (BusinessLogicException)ex;
            } else {
                throw new BusinessLogicException(ex);
            }
        }
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws BusinessLogicException {
        try {
            registrarUsuario(cliente);

            /*int idUsuario = user.getIdUsuario();
            cliente.setIdUsuario(idUsuario);*/

            cliente.setPuntosBonus(0);
            return clienteDAO.create(cliente);
        }
        catch (Exception ex) {
            if (ex instanceof BusinessLogicException) throw (BusinessLogicException) ex;
            else throw new BusinessLogicException(ex);
        }
    }

    @Override
    public Anfitrion registrarAnfitrion(Anfitrion anfitrion) throws BusinessLogicException {
        try {
            registrarUsuario(anfitrion);

            return anfitrionDAO.create(anfitrion);
        }
        catch (Exception ex) {
            if (ex instanceof BusinessLogicException) throw (BusinessLogicException) ex;
            else throw new BusinessLogicException(ex);
        }
    }

    @Override
    public Usuario verPerfil(Integer idUsuario)
            throws BusinessLogicException {

        try {

            Usuario usuario =
                    usuarioDAO.read(idUsuario);

            if(usuario == null){
                throw new BusinessLogicException(
                        "Usuario no encontrado"
                );
            }

            String tipo =
                    usuario.getTipo().getTipoUsuario();
            switch (tipo){

                case "CLIENTE":
                    return clienteDAO.read(idUsuario);

                case "ANFITRION":
                    return anfitrionDAO.read(idUsuario);

                default:
                    throw new BusinessLogicException(
                            "Tipo de usuario inválido"
                    );
            }

        } catch(Exception ex){

            if(ex instanceof BusinessLogicException)
                throw (BusinessLogicException) ex;

            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public void editarPerfil() throws BusinessLogicException {
        System.out.println("Usuario está editando su perfil.");
    }

    @Override
    public void buscarEventos() throws BusinessLogicException {
        System.out.println("Usuario está buscando eventos.");
    }

    @Override
    public void enviarSolicitud() throws BusinessLogicException {
        System.out.println("Usuario está enviando una solicitud.");
    }

}
