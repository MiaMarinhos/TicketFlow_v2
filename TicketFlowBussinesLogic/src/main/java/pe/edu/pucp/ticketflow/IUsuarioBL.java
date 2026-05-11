package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

public interface IUsuarioBL {
    public Usuario registrarUsuario(Usuario usuario) throws BusinessLogicException;


    public Cliente registrarCliente(Cliente cliente) throws BusinessLogicException;


    public Anfitrion registrarAnfitrion(Anfitrion anfitrion) throws BusinessLogicException;

    //void iniciarSesion();
    /*
    void editarPerfil() throws BusinessLogicException;
    void verPerfil() throws BusinessLogicException;
    void buscarEventos() throws BusinessLogicException;
    void enviarSolicitud() throws BusinessLogicException;

     */
}
