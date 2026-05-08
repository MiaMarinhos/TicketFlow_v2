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

            TipoUsuario tipo = tipoUsuarioDAO.buscarTipoUsuarioPorTipo("nombreTipo");
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


}
